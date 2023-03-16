package co.develhope.meteoapp.network.dto


import co.develhope.meteoapp.data.domainmodel.Place
import com.google.gson.annotations.SerializedName
import org.threeten.bp.OffsetDateTime

data class CityInfo(
    @SerializedName("generationtime_ms")
    val generationtimeMs: Double,
    @SerializedName("results")
    val results: List<Result>
){
    fun toDomain(): List<Place>{
        return this.results.mapIndexed{ index, result ->
            Place(
                city = this.results.getOrNull(index)?.name.toString(),
                region = this.results.getOrNull(index)?.admin1.toString(),
                lat = this.results.getOrNull(index)?.latitude.toString().toDouble(),
                log = this.results.getOrNull(index)?.longitude.toString().toDouble(),
            )
        }
    }
}