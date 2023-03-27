package co.develhope.meteoapp.network.dto


import co.develhope.meteoapp.data.domainmodel.Place
import com.google.gson.annotations.SerializedName

data class CityInfo(
    @SerializedName("generationtime_ms")
    val generationtimeMs: Double,
    @SerializedName("results")
    val results: List<Result>
){
    fun toDomain(): List<Place> {
        return this.results.mapIndexed { index, result ->
            Place(
                city = this.results.getOrNull(index)?.name.toString() ?: "Casteltermini",
                region = this.results.getOrNull(index)?.admin1.toString() ?: "sicilia",
                lat = this.results.getOrNull(index)?.latitude.toString().toDouble() ?: 37.3227,
                log = this.results.getOrNull(index)?.longitude.toString().toDouble(),
            )
        }
    }
}
