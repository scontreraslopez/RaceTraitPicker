package net.iessochoa.sergiocontreras.racetraitpicker.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import net.iessochoa.sergiocontreras.racetraitpicker.model.RaceOption
import net.iessochoa.sergiocontreras.racetraitpicker.ui.screens.RaceCreationScreen
import net.iessochoa.sergiocontreras.racetraitpicker.ui.screens.RaceCreationViewModel
import net.iessochoa.sergiocontreras.racetraitpicker.ui.theme.RaceTraitPickerTheme

@Composable
fun RaceTraitPickerApp() {

    val viewModel: RaceCreationViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val onPopulationOptionClick: (RaceOption) -> Unit = { selectedOption -> viewModel.onPopulationOptionClick(selectedOption) }
    val onFarmingOptionClick: (RaceOption) -> Unit = { selectedOption -> viewModel.onFarmingOptionClick(selectedOption) }


    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        RaceCreationScreen(
            modifier = Modifier.padding(innerPadding),
            uiState = uiState,
            onPopulationOptionClick = onPopulationOptionClick,
            onFarmingOptionClick = onFarmingOptionClick
        )
    }
}

/*
@Preview(showBackground = true)
@Composable
fun RaceTraitPickerAppPreview() {
    RaceTraitPickerTheme() {
        RaceTraitPickerApp()
    }
}
*/
