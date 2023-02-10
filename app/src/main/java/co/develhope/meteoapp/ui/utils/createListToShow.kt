package co.develhope.meteoapp.ui.utils

import co.develhope.meteoapp.homepage.Model.DayForecast
import co.develhope.meteoapp.homepage.Model.HomePageItem

fun createListToShow(dayForecastList: List<DayForecast>): List<HomePageItem> {
    val listToReturn = mutableListOf<HomePageItem>()

    listToReturn.add(HomePageItem.Title(dayForecastList.first().place))
    listToReturn.add(HomePageItem.CardItem(dayForecastList.first()))
    listToReturn.add(HomePageItem.Subtitle)

    val othersDays: MutableList<HomePageItem.CardItem> = dayForecastList.map {
        HomePageItem.CardItem(it)
    }.toMutableList()

    listToReturn.addAll(othersDays)
    listToReturn.removeLast()
    listToReturn.removeLast()

    return listToReturn
}