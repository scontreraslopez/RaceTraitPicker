package net.iessochoa.sergiocontreras.racetraitpicker.ui.screens

import net.iessochoa.sergiocontreras.racetraitpicker.data.RaceTraitsRepository
import net.iessochoa.sergiocontreras.racetraitpicker.model.RaceOption
import net.iessochoa.sergiocontreras.racetraitpicker.model.TraitsCategories

data class RaceCreationUiState (
    val populationOptions: List<RaceOption> = RaceTraitsRepository.getRaceOptionsByCategory(TraitsCategories.POPULATION),
    val agricultureOptions: List<RaceOption> = RaceTraitsRepository.getRaceOptionsByCategory(TraitsCategories.AGRICULTURE),
    val selectedPopulationOption: RaceOption = populationOptions[1],
    val selectedAgricultureOption: RaceOption = agricultureOptions[1],
    val remainingPoints: Int = 10
)