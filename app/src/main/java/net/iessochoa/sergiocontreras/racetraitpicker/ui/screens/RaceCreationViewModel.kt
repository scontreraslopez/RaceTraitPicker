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

    private val _uiState = MutableStateFlow(RaceCreationUiState())
    val uiState: StateFlow<RaceCreationUiState> = _uiState.asStateFlow()

    init {
        loadRaceOptions()
    }

    private fun loadRaceOptions() {
        _uiState.update { it.copy(requestStatus = RequestStatus.Loading) }

        viewModelScope.launch {
            try {
                val populationOptions = getRaceOptionsByCategory(TraitsCategories.POPULATION)
                val farmingOptions = getRaceOptionsByCategory(TraitsCategories.FARMING)

                _uiState.update {
                    it.copy(
                        requestStatus = RequestStatus.Success(
                            populationOptions = populationOptions,
                            farmingOptions = farmingOptions
                        )
                    )
                }
            } catch (e: Exception) {
                _uiState.update { it.copy(requestStatus = RequestStatus.Error) }
            }
        }
    }

    fun onPopulationOptionClick(selectedOption: RaceOption) {
        _uiState.update { currentState ->
            currentState.copy(
                selectedPopulationOption = selectedOption,
                remainingPoints = currentState.remainingPoints +
                    (currentState.selectedPopulationOption?.optionCost ?: 0) -
                    selectedOption.optionCost
            )
        }
    }

    fun onFarmingOptionClick(selectedOption: RaceOption) {
        _uiState.update { currentState ->
            currentState.copy(
                selectedFarmingOption = selectedOption,
                remainingPoints = currentState.remainingPoints +
                    (currentState.selectedFarmingOption?.optionCost ?: 0) -
                    selectedOption.optionCost
            )
        }
    }
}