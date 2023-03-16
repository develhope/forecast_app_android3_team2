package co.develhope.meteoapp.data.domainmodel


data class DaySpecificDay(
    val place: Place,
    val cardSpecificDay: CardSpecificDay,
    val hourlySpecificDay: HourlySpecificDay,
)
