package co.develhope.meteoapp.data

import co.develhope.meteoapp.data.domainmodel.CardSpecificDay
import co.develhope.meteoapp.data.domainmodel.DayForecast
import co.develhope.meteoapp.data.domainmodel.DaySpecificDay
import co.develhope.meteoapp.data.domainmodel.HourlySpecificDay
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.data.domainmodel.SearchCity
import co.develhope.meteoapp.data.domainmodel.WeatherSummary
import co.develhope.meteoapp.data.domainmodel.WeatherType
import java.util.Date

object DataSource {
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
                log = 0.0,
                date = Date()
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
                log = 0.0,
                date = Date()
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
                log = 0.0,
                date = Date()
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
                log = 0.0,
                date = Date()
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
                log = 0.0,
                date = Date()
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
                log = 0.0,
                date = Date()
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
                log = 0.0,
                date = Date()
            )
        ),
    )
    fun getDayForecast(): List<DayForecast> = dailyForecastList

    val searchList= listOf<SearchCity>(
        SearchCity(
            cityName = "Palermo"
        ),
        SearchCity(
            cityName = "Casteltermini"
        ),
        SearchCity(
            cityName = "Agrigento"
        ),
        SearchCity(
            cityName = "Catania"
        ),
    )
    fun loadSearchData(): List<SearchCity> {
        return searchList
    }



    private val specificaDayList = listOf<DaySpecificDay>(
        DaySpecificDay(

            cardSpecificDay = CardSpecificDay(
                percepita = 45,
                umidita= 60,
                copertura=24,
                uv=5,
                vento=7,
                pioggia=0
            ),
            hourlySpecificDay = HourlySpecificDay(
                time=1100,
                weatherType= WeatherType.SUNNY,
                temp=5,
                umidity=2
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = Date()
            )
        ),
        DaySpecificDay(

            cardSpecificDay = CardSpecificDay(
                percepita = 45,
                umidita= 60,
                copertura=24,
                uv=5,
                vento=7,
                pioggia=0
            ),
            hourlySpecificDay = HourlySpecificDay(
                time=1200,
                weatherType= WeatherType.SUNNY,
                temp=5,
                umidity=2
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = Date()
            )

        ),
        DaySpecificDay(

            cardSpecificDay = CardSpecificDay(
                percepita = 45,
                umidita= 60,
                copertura=24,
                uv=5,
                vento=7,
                pioggia=0
            ),
            hourlySpecificDay = HourlySpecificDay(
                time=1300,
                weatherType= WeatherType.SUNNY,
                temp=5,
                umidity=2
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = Date()
            )

        ),
        DaySpecificDay(

            cardSpecificDay = CardSpecificDay(
                percepita = 45,
                umidita= 60,
                copertura=24,
                uv=5,
                vento=7,
                pioggia=0
            ),
            hourlySpecificDay = HourlySpecificDay(
                time=1400,
                weatherType= WeatherType.SUNNY,
                temp=5,
                umidity=2
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = Date()
            )
        ),
        DaySpecificDay(

            cardSpecificDay = CardSpecificDay(
                percepita = 45,
                umidita= 60,
                copertura=24,
                uv=5,
                vento=7,
                pioggia=0
            ),
            hourlySpecificDay = HourlySpecificDay(
                time=1500,
                weatherType= WeatherType.SUNNY,
                temp=5,
                umidity=2
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = Date()
            )
        ),
        DaySpecificDay(

            cardSpecificDay = CardSpecificDay(
                percepita = 45,
                umidita= 60,
                copertura=24,
                uv=5,
                vento=7,
                pioggia=0
            ),
            hourlySpecificDay = HourlySpecificDay(
                time=1600,
                weatherType= WeatherType.SUNNY,
                temp=5,
                umidity=2
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = Date()
            )
        ),
        DaySpecificDay(

            cardSpecificDay = CardSpecificDay(
                percepita = 45,
                umidita= 60,
                copertura=24,
                uv=5,
                vento=7,
                pioggia=0
            ),
            hourlySpecificDay = HourlySpecificDay(
                time=1700,
                weatherType= WeatherType.SUNNY,
                temp=5,
                umidity=2
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = Date()
            )
        ), DaySpecificDay(

            cardSpecificDay = CardSpecificDay(
                percepita = 45,
                umidita= 60,
                copertura=24,
                uv=5,
                vento=7,
                pioggia=0
            ),
            hourlySpecificDay = HourlySpecificDay(
                time=1800,
                weatherType= WeatherType.SUNNY,
                temp=5,
                umidity=2
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = Date()
            )
        ),
        DaySpecificDay(

            cardSpecificDay = CardSpecificDay(
                percepita = 45,
                umidita= 60,
                copertura=24,
                uv=5,
                vento=7,
                pioggia=0
            ),
            hourlySpecificDay = HourlySpecificDay(
                time=1900,
                weatherType= WeatherType.SUNNY,
                temp=5,
                umidity=2
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = Date()
            )
        ),
        DaySpecificDay(

            cardSpecificDay = CardSpecificDay(
                percepita = 45,
                umidita= 60,
                copertura=24,
                uv=5,
                vento=7,
                pioggia=0
            ),
            hourlySpecificDay = HourlySpecificDay(
                time=2000,
                weatherType= WeatherType.SUNNY,
                temp=5,
                umidity=2
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = Date()
            )
        ),
        DaySpecificDay(

            cardSpecificDay = CardSpecificDay(
                percepita = 45,
                umidita= 60,
                copertura=24,
                uv=5,
                vento=7,
                pioggia=0
            ),
            hourlySpecificDay = HourlySpecificDay(
                time=2100,
                weatherType= WeatherType.SUNNY,
                temp=5,
                umidity=2
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = Date()
            )
        ),
        DaySpecificDay(

            cardSpecificDay = CardSpecificDay(
                percepita = 45,
                umidita= 60,
                copertura=24,
                uv=5,
                vento=7,
                pioggia=0
            ),
            hourlySpecificDay = HourlySpecificDay(
                time=2200,
                weatherType= WeatherType.SUNNY,
                temp=5,
                umidity=2
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = Date()
            )
        ),
        DaySpecificDay(

            cardSpecificDay = CardSpecificDay(
                percepita = 45,
                umidita= 60,
                copertura=24,
                uv=5,
                vento=7,
                pioggia=0
            ),
            hourlySpecificDay = HourlySpecificDay(
                time=2300,
                weatherType= WeatherType.SUNNY,
                temp=5,
                umidity=2
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = Date()
            )
        )

    )
    fun getSpecificDay(): List<DaySpecificDay> = specificaDayList


}