package net.iessochoa.sergiocontreras.racetraitpicker.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import net.iessochoa.sergiocontreras.racetraitpicker.model.TraitsCategories


@Serializable
data class optionDto(
    val name: String,
    val cost: Int,
    val category: TraitsCategories
)

@Serializable
data class optionDtoResponse(
    @SerialName(value="options") val options: List<optionDto>
)
