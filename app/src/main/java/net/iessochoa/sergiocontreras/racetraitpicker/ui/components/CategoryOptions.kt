package net.iessochoa.sergiocontreras.racetraitpicker.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.iessochoa.sergiocontreras.racetraitpicker.data.RaceTraitsRepository
import net.iessochoa.sergiocontreras.racetraitpicker.model.RaceOption
import net.iessochoa.sergiocontreras.racetraitpicker.model.TraitsCategories
import net.iessochoa.sergiocontreras.racetraitpicker.ui.theme.RaceTraitPickerTheme
import net.iessochoa.sergiocontreras.racetraitpicker.ui.theme.Typography

@Composable
fun CategoryOptions(
    categoryName: String,
    options: List<RaceOption>,
    selectedOption: RaceOption,
    onOptionClick: (RaceOption) -> Unit,
    modifier: Modifier = Modifier
) {

    Column (
        modifier = modifier
    ) {
        Text(
            text = categoryName,
            style = Typography.headlineMedium
        )
        options.forEach { option ->
            RowOption(
                isSelected = option == selectedOption,
                onOptionClick = { onOptionClick(option) },
                option = option
            )

        }
    }

}

@Preview(showBackground = true)
@Composable
fun CategoryOptionsPreview() {

    val categoryNamePreview = TraitsCategories.POPULATION.name
    val racePopulationOptions = RaceTraitsRepository.getRaceOptionsByCategory(TraitsCategories.POPULATION)

    RaceTraitPickerTheme() {
        CategoryOptions(
            categoryName = categoryNamePreview,
            options = racePopulationOptions,
            selectedOption = racePopulationOptions[0],
            onOptionClick = { }
        )
    }
}


