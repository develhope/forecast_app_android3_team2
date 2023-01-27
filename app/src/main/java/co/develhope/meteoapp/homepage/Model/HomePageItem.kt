package co.develhope.meteoapp.homepage.Model

import co.develhope.meteoapp.homepage.Data.DailyForecast

sealed class HomePageItem {
    data class CardItem(
        val day: String,
        val data: String,
        val type: WeatherType,
        val tempMin: String,
        val tempMax: String,
        val umidity: String,
        val kmh: String
    ) : HomePageItem()

    data class CurrentCity(
        val city: String,
        val region: String
    ) : HomePageItem()

    data class SubTitle(val string: String) : HomePageItem()

    data class WheatherType(val type: Int) : HomePageItem()

    data class DailyWeather(val dailyForecast: DailyForecast) : HomePageItem()

    object Title : HomePageItem()
    object Sub : HomePageItem()


}

