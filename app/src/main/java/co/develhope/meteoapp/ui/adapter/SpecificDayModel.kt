package co.develhope.meteoapp.ui.adapter

import co.develhope.meteoapp.CardSpecificDay
import co.develhope.meteoapp.DaySpecificDay
import co.develhope.meteoapp.homepage.Model.Place


sealed class SpecificDayModel {

    data class SpecificDayCard(val cardSpecificDay: CardSpecificDay) : SpecificDayModel()

    data class SpecificDayHourly(val daySpecificDay: DaySpecificDay) : SpecificDayModel()

    data class SpecificDayTitle(val place: Place) : SpecificDayModel()

}

