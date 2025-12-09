package net.iessochoa.sergiocontreras.racetraitpicker.model

data class RaceOption(
    val optionDescription: String,
    val optionCost: Int,
    val optionCategory: TraitsCategories
)

enum class TraitsCategories() {
    POPULATION,
    AGRICULTURE
}