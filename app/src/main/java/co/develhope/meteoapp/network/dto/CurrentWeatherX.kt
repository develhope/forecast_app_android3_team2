package co.develhope.meteoapp.network.dto


import com.google.gson.annotations.SerializedName

data class CurrentWeatherX(
    @SerializedName("temperature")
    val temperature: Double,
    @SerializedName("time")
    val time: String,
    @SerializedName("weathercode")
    val weathercode: Int,
    @SerializedName("winddirection")
    val winddirection: Double,
    @SerializedName("windspeed")
    val windspeed: Double
)