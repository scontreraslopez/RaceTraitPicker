package net.iessochoa.sergiocontreras.racetraitpicker.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import net.iessochoa.sergiocontreras.racetraitpicker.data.RaceTraitsRepository.getRaceOptionsByCategory
import net.iessochoa.sergiocontreras.racetraitpicker.model.RaceOption
import net.iessochoa.sergiocontreras.racetraitpicker.model.TraitsCategories

class RaceCreationViewModel: ViewModel() {

    // Digo que empiece cargando...
    private val _uiState = MutableStateFlow<RaceCreationUiState>(RaceCreationUiState.Loading) //Ojo que esta línea es un pelín diferente con el sealed interface
    val uiState: StateFlow<RaceCreationUiState> = _uiState.asStateFlow()


    /* Me creo el bloque init para arrancar */

    init {
        viewModelScope.launch {

            try {
                val populationOptions = getRaceOptionsByCategory(TraitsCategories.POPULATION)
                val farmingOptions = getRaceOptionsByCategory(TraitsCategories.FARMING)

                _uiState.value = RaceCreationUiState.Success(
                    RaceCreationUiData(
                        populationOptions = populationOptions,
                        farmingOptions = farmingOptions
                    )
                )
            } catch (e: Exception) {
                _uiState.value = RaceCreationUiState.Error
            }
        }
    }


    fun onPopulationOptionClick(selectedOption: RaceOption) {
        _uiState.update { currentState ->
            if (currentState is RaceCreationUiState.Success) {
                val data = currentState.uiData
                currentState.copy(
                    uiData = data.copy(
                        selectedPopulationOption = selectedOption,
                        remainingPoints = data.remainingPoints + (data.selectedPopulationOption?.optionCost ?: 0) - selectedOption.optionCost
                    )
                )
            } else currentState
        }
    }

    fun onFarmingOptionClick(selectedOption: RaceOption) {
        _uiState.update { currentState ->
            if (currentState is RaceCreationUiState.Success) {
                val data = currentState.uiData
                currentState.copy(
                    uiData = data.copy(
                        selectedFarmingOption = selectedOption,
                        remainingPoints = data.remainingPoints + (data.selectedFarmingOption?.optionCost ?: 0) - selectedOption.optionCost
                    )
                )
            } else currentState
        }
    }


    //(RaceOption) -> Unit = {selectedPopulationOption = it}


}