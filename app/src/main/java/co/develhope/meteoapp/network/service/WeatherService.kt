package co.develhope.meteoapp.network.service

import co.develhope.meteoapp.network.dto.DaySummary
import co.develhope.meteoapp.network.dto.WeeklySummary
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface WeatherService {
    @GET("forecast?")
    suspend fun getDaySummary(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("start_date") startDate: Date,
        @Query("end_date") endDate: Date,
        @Query("hourly") hourly: List<String> = listOf(
            "temperature_2m",
            "rain",
            "showers",
            "snowfall",
            "weathercode",
            "windspeed_10m"),
        @Query("current_weather") currentWeather: Boolean = true,
        @Query("timezone") timeZone: String = "Europe%2FBerlin"
    ): DaySummary

    @GET("forecast?")
    suspend fun getWeeklySummary(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("start_date") startDate: Date,
        @Query("end_date") endDate: Date,
        @Query("daily") daily: List<String> = listOf(
            "weathercode",
            "temperature_2m_max",
            "temperature_2m_min",
            "sunrise",
            "sunset",
            "precipitation_sum",
            "rain_sum"),
        @Query("current_weather") currentWeather: Boolean = true,
        @Query("timezone") timeZone: String = "Europe%2FBerlin"

    ): WeeklySummary
}