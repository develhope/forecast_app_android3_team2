package co.develhope.meteoapp.ui.adapter

import co.develhope.meteoapp.data.domainmodel.CardSpecificDay
import co.develhope.meteoapp.data.domainmodel.HourlyForecast
import co.develhope.meteoapp.data.domainmodel.Place
import org.threeten.bp.OffsetDateTime

sealed class SpecificDayModel {

    data class SpecificDayHourly(val hourlyForecast: HourlyForecast) : SpecificDayModel()

    data class SpecificDayTitle(val place: Place, val date: OffsetDateTime) : SpecificDayModel()

}

