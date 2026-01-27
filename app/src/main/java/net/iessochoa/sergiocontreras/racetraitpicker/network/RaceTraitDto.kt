package net.iessochoa.sergiocontreras.racetraitpicker.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import net.iessochoa.sergiocontreras.racetraitpicker.model.TraitsCategories



@Serializable
data class CategoriesDto(
    val categories: List<CategoryDto>
)

@Serializable
data class CategoryDto(
    val id: String,
    val name: String,
    val options: List<OptionDto>
)

@Serializable
data class OptionDto(
    @SerialName(value="name") val name: String,
    val cost: Int
)



/*


@Serializable
data class RickAndMortyResponse(
    @SerialName(value="info") val pageInfo: PageInfo,
    @SerialName(value="results") val results: List<RickAndMortyCharacter>
)

@Serializable
data class PageInfo(
    @SerialName(value="count") val count: Int,
    @SerialName(value="pages") val pages: Int,
    @SerialName(value="next") val next: String?,
    @SerialName(value="prev") val  prev: String?
)


@Serializable
data class RickAndMortyCharacter(
    @SerialName(value="id") val id: Int,
    @SerialName(value="name") val name: String,
    @SerialName(value="status") val status: String,
    @SerialName(value="species") val species: String
)
 */


/** Sabemos que la llamada a
 * https://moo2.contry-1990.workers.dev/options
 *
 * Va a devolver este json
 *
 * Esto es un único objeto, categories, compuesto por un array de categorias
 * Cada categoria tiene a su vez un array de opciones que es su propio objeto.
 *
 *
 * Entonces cuando recupere el DTO que tengo que montar tendrá esa misma forma
 * Categorias que es una lista de categoria, que tiene id, nombre y lista de opciones
 * Opciones a su vez es un objeto con nombre y coste.
 *
 *
 *
 * {
 *   "categories": [
 *     {
 *       "id": "population",
 *       "name": "Population",
 *       "options": [
 *         {
 *           "name": "-50% Growth",
 *           "cost": -4
 *         },
 *         {
 *           "name": "+50% Growth",
 *           "cost": 3
 *         },
 *         {
 *           "name": "+100% Growth",
 *           "cost": 6
 *         }
 *       ]
 *     },
 *     {
 *       "id": "farming",
 *       "name": "Farming",
 *       "options": [
 *         {
 *           "name": "-1/2 Food",
 *           "cost": -3
 *         },
 *         {
 *           "name": "-1 Food",
 *           "cost": -4
 *         },
 *         {
 *           "name": "+1 Food",
 *           "cost": 3
 *         }
 *       ]
 *     },
 *     {
 *       "id": "industry",
 *       "name": "Industry",
 *       "options": [
 *         {
 *           "name": "-1 Production",
 *           "cost": -2
 *         },
 *         {
 *           "name": "-2 Production",
 *           "cost": -3
 *         },
 *         {
 *           "name": "+1 Production",
 *           "cost": 2
 *         },
 *         {
 *           "name": "+2 Production",
 *           "cost": 4
 *         }
 *       ]
 *     },
 *     {
 *       "id": "science",
 *       "name": "Science",
 *       "options": [
 *         {
 *           "name": "-1 Research",
 *           "cost": -3
 *         },
 *         {
 *           "name": "-2 Research",
 *           "cost": -5
 *         },
 *         {
 *           "name": "+1 Research",
 *           "cost": 2
 *         },
 *         {
 *           "name": "+2 Research",
 *           "cost": 4
 *         }
 *       ]
 *     },
 *     {
 *       "id": "money",
 *       "name": "Money",
 *       "options": [
 *         {
 *           "name": "-0.5 BC",
 *           "cost": -2
 *         },
 *         {
 *           "name": "+0.5 BC",
 *           "cost": 2
 *         }
 *       ]
 *     },
 *     {
 *       "id": "ship_defense",
 *       "name": "Ship Defense",
 *       "options": [
 *         {
 *           "name": "-20",
 *           "cost": -2
 *         },
 *         {
 *           "name": "-10",
 *           "cost": -1
 *         },
 *         {
 *           "name": "+10",
 *           "cost": 1
 *         },
 *         {
 *           "name": "+20",
 *           "cost": 2
 *         }
 *       ]
 *     },
 *     {
 *       "id": "ship_attack",
 *       "name": "Ship Attack",
 *       "options": [
 *         {
 *           "name": "-20",
 *           "cost": -2
 *         },
 *         {
 *           "name": "-10",
 *           "cost": -1
 *         },
 *         {
 *           "name": "+10",
 *           "cost": 1
 *         },
 *         {
 *           "name": "+20",
 *           "cost": 2
 *         }
 *       ]
 *     },
 *     {
 *       "id": "ground_combat",
 *       "name": "Ground Combat",
 *       "options": [
 *         {
 *           "name": "-10",
 *           "cost": -2
 *         },
 *         {
 *           "name": "-5",
 *           "cost": -1
 *         },
 *         {
 *           "name": "+5",
 *           "cost": 1
 *         },
 *         {
 *           "name": "+10",
 *           "cost": 2
 *         }
 *       ]
 *     },
 *     {
 *       "id": "spying",
 *       "name": "Spying",
 *       "options": [
 *         {
 *           "name": "-10",
 *           "cost": -3
 *         },
 *         {
 *           "name": "-5",
 *           "cost": -2
 *         },
 *         {
 *           "name": "+5",
 *           "cost": 2
 *         },
 *         {
 *           "name": "+10",
 *           "cost": 3
 *         }
 *       ]
 *     },
 *     {
 *       "id": "governments",
 *       "name": "Governments",
 *       "options": [
 *         {
 *           "name": "Feudal",
 *           "cost": -4
 *         },
 *         {
 *           "name": "Dictatorship",
 *           "cost": 0
 *         },
 *         {
 *           "name": "Democracy",
 *           "cost": 7
 *         },
 *         {
 *           "name": "Unification",
 *           "cost": 6
 *         }
 *       ]
 *     },
 *     {
 *       "id": "special_abilities",
 *       "name": "Special Abilities",
 *       "options": [
 *         {
 *           "name": "Low-G World",
 *           "cost": -5
 *         },
 *         {
 *           "name": "High-G World",
 *           "cost": -3
 *         },
 *         {
 *           "name": "Aquatic",
 *           "cost": 4
 *         },
 *         {
 *           "name": "Subterranean",
 *           "cost": 5
 *         },
 *         {
 *           "name": "Large Home World",
 *           "cost": 4
 *         },
 *         {
 *           "name": "Rich Home World",
 *           "cost": 3
 *         },
 *         {
 *           "name": "Poor Home World",
 *           "cost": -1
 *         },
 *         {
 *           "name": "Artifacts World",
 *           "cost": 3
 *         },
 *         {
 *           "name": "Cybernetic",
 *           "cost": 6
 *         },
 *         {
 *           "name": "Lithovore",
 *           "cost": 10
 *         },
 *         {
 *           "name": "Repulsive",
 *           "cost": -6
 *         },
 *         {
 *           "name": "Charismatic",
 *           "cost": 3
 *         },
 *         {
 *           "name": "Uncreative",
 *           "cost": -6
 *         },
 *         {
 *           "name": "Creative",
 *           "cost": 8
 *         },
 *         {
 *           "name": "Tolerant",
 *           "cost": 5
 *         },
 *         {
 *           "name": "Fantastic Traders",
 *           "cost": 2
 *         },
 *         {
 *           "name": "Telepathic",
 *           "cost": 4
 *         },
 *         {
 *           "name": "Lucky",
 *           "cost": 4
 *         },
 *         {
 *           "name": "Omniscient",
 *           "cost": 6
 *         },
 *         {
 *           "name": "Stealthy Ships",
 *           "cost": 4
 *         },
 *         {
 *           "name": "Trans Dimensional",
 *           "cost": 4
 *         },
 *         {
 *           "name": "Warlord",
 *           "cost": 3
 *         }
 *       ]
 *     }
 *   ]
 * }
 */