package net.iessochoa.sergiocontreras.racetraitpicker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.iessochoa.sergiocontreras.racetraitpicker.model.RaceOption
import net.iessochoa.sergiocontreras.racetraitpicker.model.TraitsCategories
import net.iessochoa.sergiocontreras.racetraitpicker.ui.components.CategoryOptions
import net.iessochoa.sergiocontreras.racetraitpicker.ui.theme.RaceTraitPickerTheme

@Composable
fun RaceCreationScreen(
    modifier: Modifier = Modifier,
    uiState: RaceCreationUiState = RaceCreationUiState(),
    onPopulationOptionClick: (RaceOption) -> Unit,
    onFarmingOptionClick: (RaceOption) -> Unit
) {
    when (uiState.requestStatus) {
        is RequestStatus.Success -> {
            val options = uiState.requestStatus
            val populationOptionsList = options.populationOptions
            val farmingOptionsList = options.farmingOptions
            val remainingPoints = uiState.remainingPoints
            val selectedPopulationOption = uiState.selectedPopulationOption
            val selectedFarmingOption = uiState.selectedFarmingOption

            Column(
                modifier = modifier
            ) {
                val populationOptions = populationOptionsList.map { option ->
                    Pair(option, option.optionCost <= (remainingPoints + (selectedPopulationOption?.optionCost ?: 0)))
                }

                val farmingOptions = farmingOptionsList.map { option ->
                    Pair(option, option.optionCost <= (remainingPoints + (selectedFarmingOption?.optionCost ?: 0)))
                }

                CategoryOptions(
                    categoryName = TraitsCategories.POPULATION.name,
                    options = populationOptions,
                    selectedOption = selectedPopulationOption,
                    onOptionClick = onPopulationOptionClick
                )
                CategoryOptions(
                    categoryName = TraitsCategories.FARMING.name,
                    options = farmingOptions,
                    selectedOption = selectedFarmingOption,
                    onOptionClick = onFarmingOptionClick
                )

                Text(
                    text = "Remaining points: ${remainingPoints.toString()}"
                )
            }
        }
        is RequestStatus.Idle -> {}
        is RequestStatus.Error -> {}
        is RequestStatus.Loading -> {}
    }
}


@Preview(showBackground = true)
@Composable
fun RaceCreationScreenPreview() {
    RaceTraitPickerTheme() {
       RaceCreationScreen(
           onPopulationOptionClick = {},
           onFarmingOptionClick = {}
       )
    }
}
