package co.develhope.meteoapp.ui.adapter

import co.develhope.meteoapp.data.domainmodel.DayForecast
import co.develhope.meteoapp.data.domainmodel.Place


sealed class HomePageItem {
    data class CardItem(
        val dailyForecast: DayForecast
        ) : HomePageItem()

    data class Title(val place: Place) : HomePageItem()
    object Subtitle : HomePageItem()
}

