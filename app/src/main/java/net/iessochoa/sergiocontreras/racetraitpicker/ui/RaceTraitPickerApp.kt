package net.iessochoa.sergiocontreras.racetraitpicker.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.iessochoa.sergiocontreras.racetraitpicker.ui.screens.RaceCreationScreen
import net.iessochoa.sergiocontreras.racetraitpicker.ui.theme.RaceTraitPickerTheme

@Composable
fun RaceTraitPickerApp() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        RaceCreationScreen(modifier = Modifier.padding(innerPadding))
    }
}

@Preview(showBackground = true)
@Composable
fun RaceTraitPickerAppPreview() {
    RaceTraitPickerTheme() {
        RaceTraitPickerApp()
    }
}
