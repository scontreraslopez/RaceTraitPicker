package net.iessochoa.sergiocontreras.racetraitpicker.network

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RaceTraitApiService {

    @GET("options")
    suspend fun getRaceOptions(): List<optionDtoResponse>

}