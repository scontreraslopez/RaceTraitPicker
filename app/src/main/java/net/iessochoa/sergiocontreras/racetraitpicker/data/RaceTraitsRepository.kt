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


    private val traits = listOf<RaceOption>(
        RaceOption(
            optionDescription = "-50% Growth",
            optionCost = -4,
            optionCategory = TraitsCategories.POPULATION
        ),
        RaceOption(
            optionDescription = "Standard",
            optionCost = 0,
            optionCategory = TraitsCategories.POPULATION
        ),
        RaceOption(
            optionDescription = "+50% Growth",
            optionCost = 3,
            optionCategory = TraitsCategories.POPULATION
        ),
        RaceOption(
            optionDescription = "+100% Growth",
            optionCost = 6,
            optionCategory = TraitsCategories.POPULATION
        ),
        RaceOption(
            optionDescription = "-1/2 Food",
            optionCost = -3,
            optionCategory = TraitsCategories.FARMING
        ),
        RaceOption(
            optionDescription = "Standard",
            optionCost = 0,
            optionCategory = TraitsCategories.FARMING
        ),
        RaceOption(
            optionDescription = "+1 Food",
            optionCost = 4,
            optionCategory = TraitsCategories.FARMING
        ),
        RaceOption(
            optionDescription = "+2 Food",
            optionCost = 7,
            optionCategory = TraitsCategories.FARMING
        )
    )

    fun getRaceTraits(): List<RaceOption> = traits
    fun getRaceOptionsByCategory(category: TraitsCategories): List<RaceOption> {
        return traits.filter {
            it.optionCategory == category
        }
    }



    //Empezamos a inicializar primero Retrofit, siempre lazy.








}