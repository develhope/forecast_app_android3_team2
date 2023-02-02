package co.develhope.meteoapp.homepage.Data

import co.develhope.meteoapp.homepage.Model.HomePageItem
import co.develhope.meteoapp.homepage.Model.HourlyForecast
import co.develhope.meteoapp.homepage.Model.WeatherType
import java.util.Date

data class Place(
    val city: String,
    val region: String,
    val lat: Double,
    val log: Double
)

data class DayForecast(
    val place: Place,
    val date: Date,
    val weatherSummary: WeatherSummary
)

data class WeatherSummary(
    val weatherType: WeatherType,
    val humidity: Int,
    val wind: Int,
    val tempMin: Int,
    val tempMax: Int,
)

object HomePageObject {

    private val dailyForecastList = listOf<DayForecast>(
        DayForecast(
            date = Date(),
            weatherSummary = WeatherSummary(
                weatherType = WeatherType.sun,
                humidity = 20,
                wind = 3,
                tempMin = 5,
                tempMax = 16
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0
            )
        ),
        DayForecast(
            date = Date(),
            weatherSummary = WeatherSummary(
                weatherType = WeatherType.sun,
                humidity = 20,
                wind = 3,
                tempMin = 5,
                tempMax = 16
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0
            )
        ),
        DayForecast(
            date = Date(),
            weatherSummary = WeatherSummary(
                weatherType = WeatherType.sun,
                humidity = 20,
                wind = 3,
                tempMin = 5,
                tempMax = 16
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0
            )
        ),
        DayForecast(
            date = Date(),
            weatherSummary = WeatherSummary(
                weatherType = WeatherType.sun,
                humidity = 20,
                wind = 3,
                tempMin = 5,
                tempMax = 16
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0
            )
        ),
        DayForecast(
            date = Date(),
            weatherSummary = WeatherSummary(
                weatherType = WeatherType.sun,
                humidity = 20,
                wind = 3,
                tempMin = 5,
                tempMax = 16
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0
            )
        ),
        DayForecast(
            date = Date(),
            weatherSummary = WeatherSummary(
                weatherType = WeatherType.sun,
                humidity = 20,
                wind = 3,
                tempMin = 5,
                tempMax = 16
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0
            )
        ),
        DayForecast(
            date = Date(),
            weatherSummary = WeatherSummary(
                weatherType = WeatherType.sun,
                humidity = 20,
                wind = 3,
                tempMin = 5,
                tempMax = 16
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0
            )
        ),
    )


    /*  listOf<HomePageItem>(
         HomePageItem.Title(
             Place(
                 city = "Palermo",
                 region = "Sicilia",
                 lat = 0.0,
                 log = 0.0
             )
         ),
         HomePageItem.CardItem(
             dailyForecast = DayForecast(
                 date = Date(),
                 weatherSummary = WeatherSummary(
                     weatherType = WeatherType.sun,
                     humidity = 20,
                     wind = 3,
                     tempMin = 5,
                     tempMax = 16)
             )
         ),
         HomePageItem.Subtitle,

     )*/

    private val hourlyList = listOf(
        HourlyForecast(
            day = "oggi",
            data = "21/07",
            type = WeatherType.sun_cloud,
            umidity = 34,
            kmh = 12,
            tempMax = 22,
            tempMin = 6
        )
    )

    @Deprecated("Use the new fun that take the right info")
    fun getHourlyList(): List<HourlyForecast> = hourlyList


    fun getDayForecast(): List<DayForecast> = dailyForecastList

}




