package co.develhope.meteoapp.homepage.Model

import co.develhope.meteoapp.homepage.Data.WeatherSummary
import java.util.*

data class DayForecast(
    val place: Place,
    val date: Date,
    val weatherSummary: WeatherSummary
)
data class Place(
    val city: String,
    val region: String,
    val lat: Double,
    val log: Double
)
data class WeatherSummary(
    val weatherType: WeatherType,
    val humidity: Int,
    val wind: Int,
    val tempMin: Int,
    val tempMax: Int,
    val rain : Int
)