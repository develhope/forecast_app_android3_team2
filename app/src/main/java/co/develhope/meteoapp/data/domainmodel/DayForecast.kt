package co.develhope.meteoapp.data.domainmodel

import java.util.Date

data class DayForecast(
    val place: Place,
    val date: Date,
    val weatherSummary: WeatherSummary
)