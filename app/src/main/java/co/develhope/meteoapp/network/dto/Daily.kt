package co.develhope.meteoapp.network.dto


import co.develhope.meteoapp.data.domainmodel.WeatherSummary
import co.develhope.meteoapp.data.domainmodel.WeatherType
import co.develhope.meteoapp.data.domainmodel.getWeatherType
import com.google.gson.annotations.SerializedName

data class Daily(
    @SerializedName("precipitation_sum")
    val precipitationSum: List<Double>,
    @SerializedName("rain_sum")
    val rainSum: List<Double>,
    @SerializedName("sunrise")
    val sunrise: List<String>,
    @SerializedName("sunset")
    val sunset: List<String>,
    @SerializedName("temperature_2m_max")
    val temperature2mMax: List<Double>,
    @SerializedName("temperature_2m_min")
    val temperature2mMin: List<Double>,
    @SerializedName("time")
    val time: List<String>,
    @SerializedName("weathercode")
    val weathercode: List<Int>,
    @SerializedName("windspeed_10m_max")
    val windspeed_10m_max : List<Double>,

){
    fun toDomain(): List<WeatherSummary> {
        return this.time.mapIndexed { index, date ->
            WeatherSummary(
                weatherType = this.weathercode.getOrNull(index).getWeatherType(),
                humidity = this.rainSum.getOrNull(index)?.toInt() ?:0 ,
                wind =  this.windspeed_10m_max.getOrNull(index)?.toInt() ?:0,
                tempMin = this.temperature2mMin.getOrNull(index)?.toInt() ?:0 ,
                tempMax = this.temperature2mMax.getOrNull(index)?.toInt() ?:0 ,
                rain = this.precipitationSum.getOrNull(index)?.toInt() ?:0
            )
        }
    }
}