package co.develhope.meteoapp.network.geocoding.dto
import com.google.gson.annotations.SerializedName


data class CityInfo(
    @SerializedName("generationtime_ms")
    val generationtimeMs: Double,
    @SerializedName("results")
    val results: List<Result>
)

