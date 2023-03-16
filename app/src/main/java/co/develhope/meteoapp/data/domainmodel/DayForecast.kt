package co.develhope.meteoapp.data.domainmodel

import org.threeten.bp.OffsetDateTime

data class DayForecast(
    val place: Place,
    val weatherSummary: WeatherSummary
)