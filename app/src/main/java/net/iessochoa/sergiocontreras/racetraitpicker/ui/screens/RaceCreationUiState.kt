package net.iessochoa.sergiocontreras.racetraitpicker.ui.screens

import net.iessochoa.sergiocontreras.racetraitpicker.data.RaceTraitsRepository
import net.iessochoa.sergiocontreras.racetraitpicker.model.RaceOption
import net.iessochoa.sergiocontreras.racetraitpicker.model.TraitsCategories

data class RaceCreationUiData (
    val populationOptions: List<RaceOption> = emptyList(),
    val farmingOptions: List<RaceOption> = emptyList(),
    val selectedPopulationOption: RaceOption? = null,
    val selectedFarmingOption: RaceOption? = null,
    val remainingPoints: Int = 10
)

/* Como ahora es nullable vamos a gestionar los estados para que no cortocircuite
* Sealed interface para when táctico */
sealed interface RaceCreationUiState {
    data class Success(val uiData: RaceCreationUiData): RaceCreationUiState
    object Error: RaceCreationUiState
    object Loading: RaceCreationUiState
    object Empty: RaceCreationUiState
}

