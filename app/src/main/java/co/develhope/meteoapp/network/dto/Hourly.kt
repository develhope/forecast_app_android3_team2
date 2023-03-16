package co.develhope.meteoapp.network.dto


import co.develhope.meteoapp.data.domainmodel.CardSpecificDay
import co.develhope.meteoapp.data.domainmodel.HourlyForecast
import co.develhope.meteoapp.data.domainmodel.HourlySpecificDay
import co.develhope.meteoapp.data.domainmodel.getWeatherType
import com.google.gson.annotations.SerializedName
import org.threeten.bp.OffsetDateTime

data class Hourly(
    @SerializedName("rain")
    val rain: List<Double>,
    @SerializedName("showers")
    val showers: List<Double>,
    @SerializedName("snowfall")
    val snowfall: List<Double>,
    @SerializedName("temperature_2m")
    val temperature2m: List<Double>,
    @SerializedName("time")
    val time: List<OffsetDateTime>,
    @SerializedName("weathercode")
    val weathercode: List<Int>,
    @SerializedName("windspeed_10m")
    val windspeed10m: List<Double>,
    @SerializedName("cloudcover")
    val cloudcover: List<Double>,
    @SerializedName("precipitation_probability")
    val precipitation_probability: List<Double>,
    @SerializedName("relativehumidity_2m")
    val relativehumidity_2m: List<Double>,
    @SerializedName("apparent_temperature")
    val apparent_temperature: List<Double>,
    @SerializedName("winddirection_10m")
    val windDirection: List<Int>,


    ) {
    fun toDomain(): List<HourlyForecast> {
        return this.time.mapIndexed { index, time ->
            HourlyForecast(
                cardSpecificDay = CardSpecificDay(
                    uv = null,
                    copertura = this.cloudcover.getOrNull(index)?.toInt() ?: 0,
                    vento = this.windspeed10m.getOrNull(index)?.toInt() ?: 0,
                    pioggia = this.rain.getOrNull(index)?.toInt() ?: 0,
                    umidita = this.relativehumidity_2m.getOrNull(index)?.toInt() ?: 0,
                    percepita = this.apparent_temperature.getOrNull(index)?.toInt() ?: 0
                ),
                hourlySpecificDay = HourlySpecificDay(
                    time = time,
                    weatherType = this.weathercode.getOrNull(index).getWeatherType(),
                    temp = this.apparent_temperature.getOrNull(index)?.toInt() ?: 0,
                    umidity = this.relativehumidity_2m.getOrNull(index)?.toInt() ?: 0

                )
            )
        }
    }
}