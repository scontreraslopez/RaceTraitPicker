package net.iessochoa.sergiocontreras.racetraitpicker.ui.screens

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RaceCreationViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(RaceCreationUiState())
    val uiState: StateFlow<RaceCreationUiState> = _uiState.asStateFlow()

}