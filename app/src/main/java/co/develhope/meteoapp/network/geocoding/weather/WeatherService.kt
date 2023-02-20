package co.develhope.meteoapp.network.geocoding.weather

import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherService {
@GET("forecast?latitude=52.52&longitude=13.41&hourly=temperature_2m&daily=weathercode,temperature_2m_max,temperature_2m_min,uv_index_max,precipitation_sum,windspeed_10m_max&timezone=auto")
suspend fun getWeatherResponse(@Query("latitude")latitude:Double,@Query("longitude")longitude :Double)
}