package co.develhope.meteoapp.network.weather.DTO

data class CurrentWeatherX(
    val temperature: Double,
    val time: String,
    val weathercode: Int,
    val winddirection: Double,
    val windspeed: Double
)