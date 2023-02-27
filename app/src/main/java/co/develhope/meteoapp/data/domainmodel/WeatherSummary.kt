package co.develhope.meteoapp.data.domainmodel

data class WeatherSummary(
    val weatherType: WeatherType,
    val humidity: Int,
    val wind: Int,
    val tempMin: Int,
    val tempMax: Int,
    val rain : Int
)
