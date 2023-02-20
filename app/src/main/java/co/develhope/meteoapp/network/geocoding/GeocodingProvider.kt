package co.develhope.meteoapp.network.geocoding

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

const val BASE_URL = "https://geocoding-api.open-meteo.com/v1/"

class GeocodingProvider {

    val retrofit= Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    fun provideGeocodingService(): GeocodingService{
        return retrofit.create(GeocodingService::class.java)
    }

}