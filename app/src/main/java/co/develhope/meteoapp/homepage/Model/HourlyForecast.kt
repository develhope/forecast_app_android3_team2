package co.develhope.meteoapp.homepage.Model

data class HourlyForecast(
    val day: String,
    val data: String,
    val type: WeatherType,
    val tempMin: Int,
    val tempMax: Int,
    val umidity: Int,
    val kmh: Int
)
