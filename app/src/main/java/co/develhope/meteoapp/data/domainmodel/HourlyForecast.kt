package co.develhope.meteoapp.data.domainmodel

data class HourlyForecast(
    val cardSpecificDay: CardSpecificDay,
    val hourlySpecificDay: HourlySpecificDay
)
