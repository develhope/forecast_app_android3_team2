package co.develhope.meteoapp.data.domainmodel

import java.util.Date

data class DaySpecificDay(
    val place: Place,
    val cardSpecificDay: CardSpecificDay,
    val hourlySpecificDay: HourlySpecificDay,
    val date: Date

)
