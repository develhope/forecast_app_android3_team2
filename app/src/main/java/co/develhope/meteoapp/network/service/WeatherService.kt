package co.develhope.meteoapp.network.service

import co.develhope.meteoapp.network.dto.DaySummary
import co.develhope.meteoapp.network.dto.WeeklySummary
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface WeatherService {
    @GET("forecast?hourly=temperature_2m,rain,showers,snowfall,weathercode,windspeed_10m&current_weather=true&timezone=Europe%2FBerlin")
    suspend fun getDaySummary (@Query("latitude") latitude : Double = 41.8955,
                               @Query("longitude") longitude : Double = 12.4823,
                               @Query("start_date") startDate: Date,
                               @Query("end_date") endDate: Date
    ):DaySummary

    @GET("forecast?daily=weathercode,temperature_2m_max,temperature_2m_min,sunrise,sunset,precipitation_sum,rain_sum&current_weather=true&timezone=Europe%2FBerlin")
    suspend fun getWeeklySummary(@Query("latitude") latitude : Double = 41.8955,
                                 @Query("longitude") longitude : Double = 12.4823,
                                 @Query("start_date") startDate : Date,
                                 @Query("end_date") endDate : Date
    ) : WeeklySummary
}