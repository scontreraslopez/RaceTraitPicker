package net.iessochoa.sergiocontreras.racetraitpicker.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.iessochoa.sergiocontreras.racetraitpicker.model.RaceOption
import net.iessochoa.sergiocontreras.racetraitpicker.ui.theme.RaceTraitPickerTheme

@Composable
fun RowOption(
    isSelected: Boolean,
    onOptionClick: (RaceOption) -> Unit,
    option: RaceOption,
    modifier: Modifier = Modifier
) {

    val optionDescription: String = option.optionDescription
    val optionCost: String = option.optionCost.toString()

    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ) {
        RadioButton(
            selected = isSelected,
            onClick = {onOptionClick(option)}
        )
        Text(
            text = optionDescription,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = optionCost
        )
    }


}

/*
@Preview(showBackground = true)
@Composable
fun RowOptionPreview() {
    RaceTraitPickerTheme() {
        RowOption(
            isSelected = true,
            onOptionClick = {},
            optionDescription = "+50% Growth",
            optionCost = "3"
        )
    }
}
*/



