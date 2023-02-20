package co.develhope.meteoapp.network.weather

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


const val BASE_URL= "https://api.open-meteo.com/v1/"
class WeatherProvider {

    val retrofit =Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

    fun providerWeatherService(): WeatherService {
        return retrofit.create(WeatherService::class.java)
    }

}