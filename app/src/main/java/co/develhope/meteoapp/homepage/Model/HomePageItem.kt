package co.develhope.meteoapp.homepage.Model

import co.develhope.meteoapp.homepage.Data.DayForecast
import co.develhope.meteoapp.homepage.Data.Place


sealed class HomePageItem {
    data class CardItem(
        val dailyForecast: DayForecast
        ) : HomePageItem()

    data class Title(val place: Place) : HomePageItem()
    object Subtitle : HomePageItem()
}

