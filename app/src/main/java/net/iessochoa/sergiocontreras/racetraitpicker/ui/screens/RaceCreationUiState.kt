package net.iessochoa.sergiocontreras.racetraitpicker.ui.screens

import net.iessochoa.sergiocontreras.racetraitpicker.model.RaceOption

data class RaceCreationUiState(
    // Datos de la pantalla (persisten siempre)
    val selectedPopulationOption: RaceOption? = null,
    val selectedFarmingOption: RaceOption? = null,
    val remainingPoints: Int = 10,
    // Estado de la petición (lógica excluyente para las opciones)
    val requestStatus: RequestStatus = RequestStatus.Idle
)

// Estado exclusivo solo para la carga de datos
sealed interface RequestStatus {
    object Idle : RequestStatus
    object Loading : RequestStatus
    data class Success(
        val populationOptions: List<RaceOption>,
        val farmingOptions: List<RaceOption>
    ) : RequestStatus
    object Error : RequestStatus
}

