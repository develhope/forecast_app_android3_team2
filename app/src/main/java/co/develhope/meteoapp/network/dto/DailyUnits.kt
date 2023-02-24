package co.develhope.meteoapp.network.dto


import com.google.gson.annotations.SerializedName

data class DailyUnits(
    @SerializedName("precipitation_sum")
    val precipitationSum: String,
    @SerializedName("rain_sum")
    val rainSum: String,
    @SerializedName("sunrise")
    val sunrise: String,
    @SerializedName("sunset")
    val sunset: String,
    @SerializedName("temperature_2m_max")
    val temperature2mMax: String,
    @SerializedName("temperature_2m_min")
    val temperature2mMin: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("weathercode")
    val weathercode: String
)