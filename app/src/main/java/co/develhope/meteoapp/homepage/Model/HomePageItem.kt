package co.develhope.meteoapp.homepage.Model




sealed class HomePageItem {
    data class CardItem(
        val dailyForecast: DayForecast
        ) : HomePageItem()

    data class Title(val place: Place) : HomePageItem()
    object Subtitle : HomePageItem()
}

