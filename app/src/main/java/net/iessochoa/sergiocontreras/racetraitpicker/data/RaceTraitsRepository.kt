package net.iessochoa.sergiocontreras.racetraitpicker.data

import kotlinx.serialization.json.Json
import net.iessochoa.sergiocontreras.racetraitpicker.model.RaceOption
import net.iessochoa.sergiocontreras.racetraitpicker.model.TraitsCategories
import net.iessochoa.sergiocontreras.racetraitpicker.network.RaceTraitApiService
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlin.getValue

object RaceTraitsRepository {

    private val baseUrl = "https://moo2.contry-1990.workers.dev/"

    private val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(baseUrl)
            .build()
    }

    private val retrofitService: RaceTraitApiService by lazy {
        retrofit.create(RaceTraitApiService::class.java)
    }

    suspend fun getRaceOptionsByCategory(category: TraitsCategories): List<RaceOption> {

        /** Casi nada este mapeo... con razón estaba atascado
         *
         * Pero bueno más allá de lo enrevesado de la transformación esto es porque
         * tenemos que transfomar el DTO en una lista de RaceOption (modelo)
         * y como estaba muy improvisado se complica.
         *
         * Con mejor tino DTO y modelo pueden ser unificado.
         *
         * Ejemplo si DTO y modelo son iguales
         *
         *     suspend fun getCharacters() = retrofitService.getCharacters()
         *
         *
         * Nótese que esto mezcla la obtención de datos con la transformación de datos (mapper) y se podría separar
         *          *
         */
        val categoriesDto = retrofitService.getRaceOptions()

        return categoriesDto.categories.flatMap { dtoCategory ->
            val mappedCategory = runCatching { //Esto es como un try catch
                TraitsCategories.valueOf(dtoCategory.name)
            }.getOrNull()

            if (mappedCategory == null) {
                emptyList()
            } else {
                dtoCategory.options.map { option ->
                    RaceOption(
                        optionDescription = option.name,
                        optionCost = option.cost,
                        optionCategory = mappedCategory )
                }
            }
        }
            .filter { it.optionCategory == category }
    }

}

