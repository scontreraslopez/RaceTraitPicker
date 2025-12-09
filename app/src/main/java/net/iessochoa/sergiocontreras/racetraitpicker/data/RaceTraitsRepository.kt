package net.iessochoa.sergiocontreras.racetraitpicker.data

import net.iessochoa.sergiocontreras.racetraitpicker.model.RaceOption
import net.iessochoa.sergiocontreras.racetraitpicker.model.TraitsCategories

object RaceTraitsRepository {

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
            optionCategory = TraitsCategories.AGRICULTURE
        ),
        RaceOption(
            optionDescription = "Standard",
            optionCost = 0,
            optionCategory = TraitsCategories.AGRICULTURE
        ),
        RaceOption(
            optionDescription = "+1 Food",
            optionCost = 4,
            optionCategory = TraitsCategories.AGRICULTURE
        ),
        RaceOption(
            optionDescription = "+2 Food",
            optionCost = 7,
            optionCategory = TraitsCategories.AGRICULTURE
        )
    )

    fun getRaceTraits(): List<RaceOption> = traits
    fun getRaceOptionsByCategory(category: TraitsCategories): List<RaceOption> {
        return traits.filter {
            it.optionCategory == category
        }
    }




}