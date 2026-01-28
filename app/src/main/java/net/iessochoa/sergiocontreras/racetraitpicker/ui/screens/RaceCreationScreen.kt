package net.iessochoa.sergiocontreras.racetraitpicker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import net.iessochoa.sergiocontreras.racetraitpicker.data.RaceTraitsRepository
import net.iessochoa.sergiocontreras.racetraitpicker.model.RaceOption
import net.iessochoa.sergiocontreras.racetraitpicker.model.TraitsCategories
import net.iessochoa.sergiocontreras.racetraitpicker.ui.components.CategoryOptions
import net.iessochoa.sergiocontreras.racetraitpicker.ui.theme.RaceTraitPickerTheme
import kotlin.text.compareTo

@Composable
fun RaceCreationScreen(
    modifier: Modifier = Modifier,
    uiState: RaceCreationUiState = RaceCreationUiState.Loading,
    onPopulationOptionClick: (RaceOption) -> Unit,
    onFarmingOptionClick: (RaceOption) -> Unit
) {

    when (uiState) {
        is RaceCreationUiState.Success -> {
            val data = uiState.uiData
            val populationOptions = data.populationOptions
            val farmingOptions = data.farmingOptions
            val remainingPoints = data.remainingPoints
            val selectedPopulationOption = data.selectedPopulationOption
            val selectedFarmingOption = data.selectedFarmingOption

            Column(
                modifier = modifier
            ) {
                val populationOptions = populationOptions.map { option ->
                    Pair(option, option.optionCost <= (remainingPoints + (selectedPopulationOption?.optionCost ?: 0)))
                }

                val farmingOptions = farmingOptions.map { option ->
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
        is RaceCreationUiState.Empty -> {}
        is RaceCreationUiState.Error -> {}
        is RaceCreationUiState.Loading -> {}

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
