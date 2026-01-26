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

    fun onPopulationOptionClick(selectedOption: RaceOption) {
        _uiState.update { currentState ->
            currentState.copy(
                selectedPopulationOption = selectedOption,
                remainingPoints = currentState.remainingPoints + currentState.selectedPopulationOption.optionCost - selectedOption.optionCost
            )

        }
    }

    fun onAgricultureOptionClick(selectedOption: RaceOption) {
        _uiState.update { currentState ->
            currentState.copy(
                selectedAgricultureOption = selectedOption,
                remainingPoints = currentState.remainingPoints + currentState.selectedAgricultureOption.optionCost - selectedOption.optionCost
            )

        }
    }

    //(RaceOption) -> Unit = {selectedPopulationOption = it}


}