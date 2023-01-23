package co.develhope.meteoapp.homepage.model

data class HourlyForecast(
val time: String,
val type: Int,
val tempMin: Int,
val tempMax: Int,
val umidity: Int,
val kmh: Int
)
