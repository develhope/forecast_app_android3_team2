package co.develhope.meteoapp.homepage.model

data class HourlyForecast(
    val day: String,
    val data: String,
    val type: WheatherType,
    val tempMin: Int,
    val tempMax: Int,
    val umidity: Int,
    val kmh: Int
)
