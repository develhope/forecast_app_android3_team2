package co.develhope.meteoapp.data

import co.develhope.meteoapp.data.domainmodel.DayForecast
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.data.domainmodel.WeatherType
import co.develhope.meteoapp.data.domainmodel.WeatherSummary
import java.util.Date

object HomePageObject {

    private val dailyForecastList = listOf<DayForecast>(
        DayForecast(
            date = Date(),
            weatherSummary = WeatherSummary(
                weatherType = WeatherType.SUNNY,
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
                weatherType = WeatherType.SUNNY,
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
                weatherType = WeatherType.SUNNY,
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
                weatherType = WeatherType.SUNNY,
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
                weatherType = WeatherType.SUNNY,
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
                weatherType = WeatherType.SUNNY,
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
                weatherType = WeatherType.SUNNY,
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




