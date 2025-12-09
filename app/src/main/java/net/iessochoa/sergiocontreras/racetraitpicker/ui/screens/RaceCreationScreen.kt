package net.iessochoa.sergiocontreras.racetraitpicker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.iessochoa.sergiocontreras.racetraitpicker.data.RaceTraitsRepository
import net.iessochoa.sergiocontreras.racetraitpicker.model.RaceOption
import net.iessochoa.sergiocontreras.racetraitpicker.model.TraitsCategories
import net.iessochoa.sergiocontreras.racetraitpicker.ui.components.CategoryOptions
import net.iessochoa.sergiocontreras.racetraitpicker.ui.theme.RaceTraitPickerTheme

@Composable
fun RaceCreationScreen(modifier: Modifier = Modifier) {

    val populationOptions = RaceTraitsRepository.getRaceOptionsByCategory(TraitsCategories.POPULATION)
    val agricultureOptions = RaceTraitsRepository.getRaceOptionsByCategory(TraitsCategories.AGRICULTURE)


    var selectedPopulationOption by remember { mutableStateOf(populationOptions[1]) }
    val onPopulationOptionClick: (RaceOption) -> Unit = {selectedPopulationOption = it}
    var selectedAgricultureOption by remember { mutableStateOf(agricultureOptions[1]) }
    val onAgricultureOptionClick: (RaceOption) -> Unit = {selectedAgricultureOption = it}

    Column {
        CategoryOptions(
            categoryName = TraitsCategories.POPULATION.name,
            options = populationOptions,
            selectedOption = selectedPopulationOption,
            onOptionClick = onPopulationOptionClick
        )
        CategoryOptions(
            categoryName = TraitsCategories.AGRICULTURE.name,
            options = agricultureOptions,
            selectedOption = selectedAgricultureOption,
            onOptionClick = onAgricultureOptionClick
        )

    }
}

@Preview(showBackground = true)
@Composable
fun RaceCreationScreenPreview() {
    RaceTraitPickerTheme() {
       RaceCreationScreen()
    }
}

