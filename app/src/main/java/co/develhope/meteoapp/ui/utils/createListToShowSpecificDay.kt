package co.develhope.meteoapp.ui.utils

import co.develhope.meteoapp.data.domainmodel.HourlyForecast
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.ui.adapter.SpecificDayModel
import org.threeten.bp.OffsetDateTime

fun createListToShowSpecificDay(list: List<HourlyForecast>, place: Place, date: OffsetDateTime): List<SpecificDayModel> {
    val listToReturn = mutableListOf<SpecificDayModel>()
    val filteredList =
        list.filter { hourlyForecast -> hourlyForecast.hourlySpecificDay.time.isAfter(date) }


    listToReturn.add(SpecificDayModel.SpecificDayTitle(place,date))
    listToReturn.add(SpecificDayModel.SpecificDayHourly(filteredList.first()))
    val otherHours: MutableList<SpecificDayModel.SpecificDayHourly> = filteredList.map {
        SpecificDayModel.SpecificDayHourly(it)
    }.toMutableList()
    listToReturn.addAll(otherHours)

    listToReturn.removeAt(3)
    return listToReturn
}