package co.develhope.meteoapp.network.weather.dto

data class CurrentWeatherX(
    val temperature: Double,
    val time: String,
    val weathercode: Int,
    val winddirection: Double,
    val windspeed: Double
)