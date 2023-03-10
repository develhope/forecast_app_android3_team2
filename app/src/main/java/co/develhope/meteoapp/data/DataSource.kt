package co.develhope.meteoapp.data

import co.develhope.meteoapp.data.domainmodel.CardSpecificDay
import co.develhope.meteoapp.data.domainmodel.DayForecast
import co.develhope.meteoapp.data.domainmodel.DaySpecificDay
import co.develhope.meteoapp.data.domainmodel.HourlySpecificDay
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.data.domainmodel.SearchCity
import co.develhope.meteoapp.data.domainmodel.WeatherSummary
import co.develhope.meteoapp.data.domainmodel.WeatherType
import org.threeten.bp.OffsetDateTime

object DataSource {
    private val dailyForecastList = mutableListOf<DayForecast>(
        DayForecast(
            date = OffsetDateTime.now(),
            weatherSummary = WeatherSummary(
                weatherType = WeatherType.RAINY,
                humidity = 30,
                wind = 12,
                tempMin = 7,
                tempMax = 12,
                rain = 70
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = OffsetDateTime.now()
            )
        ),
        DayForecast(
            date = OffsetDateTime.now().plusDays(1),
            weatherSummary = WeatherSummary(
                weatherType = WeatherType.SUNNY,
                humidity = 12,
                wind = 7,
                tempMin = 15,
                tempMax = 21,
                rain = 9
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = OffsetDateTime.now()
            )
        ),
        DayForecast(
            date = OffsetDateTime.now().plusDays(2),
            weatherSummary = WeatherSummary(
                weatherType = WeatherType.CLOUDY,
                humidity = 15,
                wind = 15,
                tempMin = 9,
                tempMax = 16,
                rain = 22
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = OffsetDateTime.now()
            )
        ),
        DayForecast(
            date = OffsetDateTime.now().plusDays(3),
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
                date = OffsetDateTime.now()
            )
        ),
        DayForecast(
            date = OffsetDateTime.now().plusDays(4),
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
                date = OffsetDateTime.now()
            )
        ),
        DayForecast(
            date = OffsetDateTime.now().plusDays(5),
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
                date = OffsetDateTime.now()
            )
        ),
    )
    fun getDayForecast(): MutableList<DayForecast> = dailyForecastList

    private val searchList= listOf<SearchCity>(
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



    private val specificDayList = listOf<DaySpecificDay>(
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
                time=OffsetDateTime.now().hour.plus(1),
                weatherType= WeatherType.SUNNY,
                temp=31,
                umidity=0
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = OffsetDateTime.now()
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
                time=OffsetDateTime.now().hour.plus(2),
                weatherType= WeatherType.SUNNY,
                temp=29,
                umidity=0
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = OffsetDateTime.now()
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
                time=OffsetDateTime.now().hour.plus(3),
                weatherType= WeatherType.SUNNY,
                temp=30,
                umidity=0
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = OffsetDateTime.now()
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
                time=OffsetDateTime.now().hour.plus(4),
                weatherType= WeatherType.RAINY,
                temp=32,
                umidity=60
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = OffsetDateTime.now()
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
                time=OffsetDateTime.now().hour.plus(5),
                weatherType= WeatherType.RAINY,
                temp=28,
                umidity=70
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = OffsetDateTime.now()
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
                time=OffsetDateTime.now().hour.plus(6),
                weatherType= WeatherType.CLOUDY,
                temp=25,
                umidity=20
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = OffsetDateTime.now()
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
                time=OffsetDateTime.now().hour.plus(7),
                weatherType= WeatherType.SUNNY,
                temp=22,
                umidity=0
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = OffsetDateTime.now()
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
                time=OffsetDateTime.now().hour.plus(8),
                weatherType= WeatherType.SUNNY,
                temp=22,
                umidity=0
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = OffsetDateTime.now()
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
                time=OffsetDateTime.now().hour.plus(9),
                weatherType= WeatherType.CLOUDY,
                temp=20,
                umidity=10
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = OffsetDateTime.now()
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
                time=OffsetDateTime.now().hour.plus(10),
                weatherType= WeatherType.CLOUDY,
                temp=20,
                umidity=20
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = OffsetDateTime.now()
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
                time=OffsetDateTime.now().hour.plus(11),
                weatherType= WeatherType.RAINY,
                temp=18,
                umidity=60
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = OffsetDateTime.now()
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
                time=OffsetDateTime.now().hour.plus(12),
                weatherType= WeatherType.RAINY,
                temp=15,
                umidity=70
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = OffsetDateTime.now()
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
                time=OffsetDateTime.now().hour.plus(13),
                weatherType= WeatherType.RAINY,
                temp=15,
                umidity=70
            ),
            place = Place(
                city = "Palermo",
                region = "Sicilia",
                lat = 0.0,
                log = 0.0,
                date = OffsetDateTime.now()
            )
        ),


    )

    fun getSpecificDay(): List<DaySpecificDay> = specificDayList
}

    

