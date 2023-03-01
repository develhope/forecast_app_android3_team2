package co.develhope.meteoapp.network.service

import co.develhope.meteoapp.network.dto.DaySummary
import co.develhope.meteoapp.network.dto.WeeklySummary
import org.threeten.bp.OffsetDateTime
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

//  true&timezone=Europe%2FBerlin&start_date=2022-10-03&end_date=2022-10-03
interface WeatherService {
    @GET("forecast?")
    suspend fun getDaySummary(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("hourly") hourly: List<String> = listOf(
            "temperature_2m",
            "rain",
            "showers",
            "snowfall",
            "weathercode",
            "windspeed_10m",
            "cloudcover",
            "precipitation_probability",
            "relativehumidity_2m",
            "apparent_temperature",

        ),
        @Query("current_weather") currentWeather: Boolean = true,
        @Query("timezone") timeZone: String = "auto"
    ): DaySummary

    @GET("forecast?")
    suspend fun getWeeklySummary(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("daily") daily: List<String> = listOf(
            "weathercode",
            "temperature_2m_max",
            "temperature_2m_min",
            "sunrise",
            "sunset",
            "precipitation_sum",
            "rain_sum",
            "windspeed_10m_max"
        ),
        @Query("current_weather") currentWeather: Boolean = true,
        @Query("timezone") timeZone: String = "auto"
    ): Response<WeeklySummary>
}