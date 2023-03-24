package co.develhope.meteoapp.ui.utils

import co.develhope.meteoapp.data.DataSource
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.data.domainmodel.WeatherSummary
import co.develhope.meteoapp.ui.adapter.HomePageItem
import org.threeten.bp.OffsetDateTime

fun createListToShowHome(dayForecastList: List<WeatherSummary>, place: Place, date: OffsetDateTime): List<HomePageItem> {
    val listToReturn = mutableListOf<HomePageItem>()
    listToReturn.add(HomePageItem.Title(place))
    listToReturn.add(HomePageItem.CardItem(dayForecastList.first()))
    listToReturn.add(HomePageItem.Subtitle)

    val filteredList = dayForecastList.drop(1)
    val othersDays: MutableList<HomePageItem.CardItem> = filteredList.map {
        HomePageItem.CardItem(it)
    }.toMutableList()

    listToReturn.addAll(othersDays)
    listToReturn.removeLast()
    return listToReturn
}