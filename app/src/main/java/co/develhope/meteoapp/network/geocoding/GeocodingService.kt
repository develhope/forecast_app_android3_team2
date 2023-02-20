package co.develhope.meteoapp.network.geocoding

import co.develhope.meteoapp.network.geocoding.dto.CityInfo
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingService {

    @GET("search?")
    suspend fun getCityInfo(@Query("name") name : String, @Query("language") language: String = "IT"): CityInfo

}