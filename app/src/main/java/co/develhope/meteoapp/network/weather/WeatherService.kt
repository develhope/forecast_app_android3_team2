package co.develhope.meteoapp.network.weather

import co.develhope.meteoapp.network.weather.dto.DaySummary
import co.develhope.meteoapp.network.weather.dto.WeeklySummary
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("forecast?hourly=temperature_2m,rain,showers,snowfall,weathercode,windspeed_10m&current_weather=true&timezone=Europe%2FBerlin&start_date=2022-10-03&end_date=2022-10-03")
    suspend fun GetDaySummary (@Query("latitude") latitude : Double = 41.8955, @Query("longitude") longitude : Double = 12.4823):DaySummary


}