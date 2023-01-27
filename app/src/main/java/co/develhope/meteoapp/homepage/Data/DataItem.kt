package co.develhope.meteoapp.homepage.Data

import co.develhope.meteoapp.R
import co.develhope.meteoapp.homepage.Model.HomePageItem
import co.develhope.meteoapp.homepage.Model.WeatherType
import java.util.Date

data class DailyForecast(
    val date: Date,
    val weather: WeatherType,
    val wind: Int,
    val rain: Int
)

object DataItem {

    fun setIconWeather(weather: WeatherType): Int {
        return when (weather) {
            WeatherType.SUN -> R.drawable.sun
            WeatherType.SUN_CLOUD -> R.drawable.sun_cloud
            WeatherType.RAIN -> R.drawable.rain
        }
    }


    private val listClass = mutableListOf<HomePageItem>(
        HomePageItem.CurrentCity("palermo", "sicilia"),
        HomePageItem.CardItem("oggi", "11/10", WeatherType.SUN, "2°", "15°", "7%", "19kmh"),
        HomePageItem.SubTitle("PROSSIMI 5 GIORNI"),
        HomePageItem.CardItem("domani", "11/10", WeatherType.SUN_CLOUD, "2°", "15", "7", "19"),
        HomePageItem.CardItem("mercoledi", "11/10", WeatherType.RAIN, "2", "15", "7", "19"),
        HomePageItem.CardItem("giovedi", "11/10", WeatherType.SUN_CLOUD, "2", "15", "7", "19"),
        HomePageItem.CardItem("venerdi", "11/10", WeatherType.SUN_CLOUD, "2", "15", "7", "19"),
        HomePageItem.CardItem("sabato", "11/10", WeatherType.SUN, "2", "15", "7", "19"),


        )
    fun loadData():List<HomePageItem> {
        return listClass
    }

    private val dailyForecastList =  listOf<DailyForecast>(
        DailyForecast(
            date =Date(),
            weather = WeatherType.SUN,
            wind = 10,
            rain = 2
        )
    )


    fun getDailyForecast() : List<DailyForecast> = dailyForecastList
}