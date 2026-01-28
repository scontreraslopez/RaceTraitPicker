package net.iessochoa.sergiocontreras.racetraitpicker.ui.screens

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import net.iessochoa.sergiocontreras.racetraitpicker.model.RaceOption

class RaceCreationViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(RaceCreationUiState())
    val uiState: StateFlow<RaceCreationUiState> = _uiState.asStateFlow()

    /* Me creo el bloque init para arrancar */
    init {

    }

    fun onPopulationOptionClick(selectedOption: RaceOption) {
        _uiState.update { currentState ->
            currentState.copy(
                selectedPopulationOption = selectedOption,
                remainingPoints = currentState.remainingPoints + currentState.selectedPopulationOption.optionCost - selectedOption.optionCost
            )

        }
    }

    fun onFarmingOptionClick(selectedOption: RaceOption) {
        _uiState.update { currentState ->
            currentState.copy(
                selectedFarmingOption = selectedOption,
                remainingPoints = currentState.remainingPoints + currentState.selectedFarmingOption.optionCost - selectedOption.optionCost
            )

        }
    }

    //(RaceOption) -> Unit = {selectedPopulationOption = it}


}