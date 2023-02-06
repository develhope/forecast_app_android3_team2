package co.develhope.meteoapp.model

import co.develhope.meteoapp.SpecificDay
import co.develhope.meteoapp.data.CardSpecificDay

import co.develhope.meteoapp.data.DaySpecificDay
import co.develhope.meteoapp.data.HourlySpecificDay
import co.develhope.meteoapp.data.Place



sealed class SpecificDayModel {

    data class SpecificDayCard(val cardSpecificDay: CardSpecificDay ) : SpecificDayModel()

   data class SpecificDayHourly(val daySpecificDay: DaySpecificDay): SpecificDayModel()

    data class SpecificDayTitle(val place: Place) : SpecificDayModel()

    }


