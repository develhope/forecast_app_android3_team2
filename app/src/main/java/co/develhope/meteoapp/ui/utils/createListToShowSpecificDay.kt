package co.develhope.meteoapp.ui.utils

import co.develhope.meteoapp.data.DataSource
import co.develhope.meteoapp.data.domainmodel.HourlyForecast
import co.develhope.meteoapp.ui.adapter.SpecificDayModel

fun createListToShowSpecificDay(list: List<HourlyForecast>): List<SpecificDayModel> {
    val listToReturn = mutableListOf<SpecificDayModel>()
    val filteredList =
        list.filter { hourlyForecast -> hourlyForecast.hourlySpecificDay.time.isAfter(DataSource.getDate()) }


    listToReturn.add(SpecificDayModel.SpecificDayTitle(DataSource.getSelectedPlace()!!, date = DataSource.getDate()))
    listToReturn.add(SpecificDayModel.SpecificDayHourly(filteredList.first()))
    listToReturn.add(SpecificDayModel.SpecificDayCard(filteredList.first().cardSpecificDay))

    val otherHours: MutableList<SpecificDayModel.SpecificDayHourly> = filteredList.map {
        SpecificDayModel.SpecificDayHourly(it)
    }.toMutableList()
    listToReturn.addAll(otherHours)

    listToReturn.removeAt(3)
    return listToReturn
}