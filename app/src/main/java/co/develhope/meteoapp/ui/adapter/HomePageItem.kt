package co.develhope.meteoapp.ui.adapter

import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.data.domainmodel.WeatherSummary


sealed class HomePageItem {
    data class CardItem(
        val dailyForecast: WeatherSummary
        ) : HomePageItem()

    data class Title(val place: Place) : HomePageItem()
    object Subtitle : HomePageItem()
}

