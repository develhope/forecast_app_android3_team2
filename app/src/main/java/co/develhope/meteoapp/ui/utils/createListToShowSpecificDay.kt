package co.develhope.meteoapp.ui.utils

import co.develhope.meteoapp.ApplicationMeteo
import co.develhope.meteoapp.data.domainmodel.HourlyForecast
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.ui.adapter.SpecificDayModel
import org.threeten.bp.OffsetDateTime

fun createListToShowSpecificDay(
    list: List<HourlyForecast>,
    place: Place,
    date: OffsetDateTime
): List<SpecificDayModel> {
    val listToReturn = mutableListOf<SpecificDayModel>()


    listToReturn.add(SpecificDayModel.SpecificDayTitle(place, date))
    val otherHours: List<SpecificDayModel.SpecificDayHourly> = list.map {
        SpecificDayModel.SpecificDayHourly(it)
    }
    listToReturn.addAll(otherHours)

    return listToReturn
}