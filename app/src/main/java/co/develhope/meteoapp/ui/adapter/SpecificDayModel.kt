package co.develhope.meteoapp.ui.adapter

import co.develhope.meteoapp.data.domainmodel.CardSpecificDay
import co.develhope.meteoapp.data.domainmodel.DaySpecificDay
import co.develhope.meteoapp.data.domainmodel.HourlyForecast
import co.develhope.meteoapp.data.domainmodel.Place

sealed class SpecificDayModel {

    data class SpecificDayCard(val cardSpecificDay: CardSpecificDay) : SpecificDayModel()

    data class SpecificDayHourly(val hourlyForecast: HourlyForecast) : SpecificDayModel()

    data class SpecificDayTitle(val place: Place) : SpecificDayModel()

}

