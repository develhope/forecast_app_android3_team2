package co.develhope.meteoapp.homepage.Data

import co.develhope.meteoapp.homepage.Model.DayForecast
import co.develhope.meteoapp.homepage.Model.Place
import co.develhope.meteoapp.homepage.Model.WeatherType
import java.util.Date





data class WeatherSummary(
    val weatherType: WeatherType,
    val humidity: Int,
    val wind: Int,
    val tempMin: Int,
    val tempMax: Int,
    val rain : Int
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
                tempMax = 16,
                rain = 4
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
                tempMax = 16,
                rain = 4
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
                tempMax = 16,
                rain = 4
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
                tempMax = 16,
                rain = 4
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
                tempMax = 16,
                rain = 4

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
                tempMax = 16,
                rain = 4
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
                tempMax = 16,
                rain = 4
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0
            )
        ),
    )
    fun getDayForecast(): List<DayForecast> = dailyForecastList
}




