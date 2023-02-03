package co.develhope.meteoapp.data


import co.develhope.meteoapp.model.WeatherType
import java.util.Date


data class Place(
        val city: String,
        val region: String,
        val date: Date,
    )

data class DaySpecificDay(
    val place: Place,
    val cardSpecificDay: CardSpecificDay,
    val hourlySpecificDay: HourlySpecificDay

)

data class CardSpecificDay(
    val percepita: Int,
    val umidita: Int,
    val copertura: Int,
    val uv: Int,
    val vento: Int,
    val pioggia: Int
)

data class HourlySpecificDay(
    val time: Int,
    val weatherType: WeatherType,
    val temp: Int,
    val umidity: Int
)



object SpecificDayObject {


    private val specificaDayList = listOf<DaySpecificDay>(
        DaySpecificDay(

            cardSpecificDay = CardSpecificDay(
                percepita = 10,
                umidita= 1,
                copertura=4,
                uv=2,
                vento=2,
                pioggia=4
            ),
            hourlySpecificDay = HourlySpecificDay(
                 time=1100,
                 weatherType= WeatherType.SUN,
                 temp=5,
                 umidity=2
            ),
            place = Place(
                city = "palermo",
                region = "sicilia" ,
                date = Date(),
            )

        ),
        DaySpecificDay(

            cardSpecificDay = CardSpecificDay(
                percepita = 10,
                umidita= 1,
                copertura=4,
                uv=2,
                vento=2,
                pioggia=4
            ),
            hourlySpecificDay = HourlySpecificDay(
                time=1200,
                weatherType= WeatherType.SUN,
                temp=5,
                umidity=2
            ),
            place = Place(
                city = "palermo",
                region = "sicilia",
                date = Date(),
            )

        ),
        DaySpecificDay(

            cardSpecificDay = CardSpecificDay(
                percepita = 10,
                umidita= 1,
                copertura=4,
                uv=2,
                vento=2,
                pioggia=4
            ),
            hourlySpecificDay = HourlySpecificDay(
                time=1300,
                weatherType= WeatherType.SUN,
                temp=5,
                umidity=2
            ),
            place = Place(
                city = "palermo",
                region = "sicilia",
                date = Date(),
            )

        ),
        DaySpecificDay(

            cardSpecificDay = CardSpecificDay(
                percepita = 10,
                umidita= 1,
                copertura=4,
                uv=2,
                vento=2,
                pioggia=4
            ),
            hourlySpecificDay = HourlySpecificDay(
                time=1400,
                weatherType= WeatherType.SUN,
                temp=5,
                umidity=2
            ),
            place = Place(
                city = "palermo",
                region = "sicilia",
                date = Date(),
            )

        ),
        DaySpecificDay(

            cardSpecificDay = CardSpecificDay(
                percepita = 10,
                umidita= 1,
                copertura=4,
                uv=2,
                vento=2,
                pioggia=4
            ),
            hourlySpecificDay = HourlySpecificDay(
                time=1500,
                weatherType= WeatherType.SUN,
                temp=5,
                umidity=2
            ),
            place = Place(
                city = "palermo",
                region = "sicilia",
                date = Date(),
            )

        ),
        DaySpecificDay(

            cardSpecificDay = CardSpecificDay(
                percepita = 10,
                umidita= 1,
                copertura=4,
                uv=2,
                vento=2,
                pioggia=4
            ),
            hourlySpecificDay = HourlySpecificDay(
                time=1600,
                weatherType= WeatherType.SUN,
                temp=5,
                umidity=2
            ),
            place = Place(
                city = "palermo",
                region = "sicilia",
                date = Date(),
            )

        ),
        DaySpecificDay(

            cardSpecificDay = CardSpecificDay(
                percepita = 10,
                umidita= 1,
                copertura=4,
                uv=2,
                vento=2,
                pioggia=4
            ),
            hourlySpecificDay = HourlySpecificDay(
                time=1700,
                weatherType= WeatherType.SUN,
                temp=5,
                umidity=2
            ),
            place = Place(
                city = "palermo",
                region = "sicilia",
                date = Date(),
            )

        ), DaySpecificDay(

            cardSpecificDay = CardSpecificDay(
                percepita = 10,
                umidita= 1,
                copertura=4,
                uv=2,
                vento=2,
                pioggia=4
            ),
            hourlySpecificDay = HourlySpecificDay(
                time=1800,
                weatherType= WeatherType.SUN,
                temp=5,
                umidity=2
            ),
            place = Place(
                city = "palermo",
                region = "sicilia",
                date = Date(),
            )

        ),
        DaySpecificDay(

            cardSpecificDay = CardSpecificDay(
                percepita = 10,
                umidita= 1,
                copertura=4,
                uv=2,
                vento=2,
                pioggia=4
            ),
            hourlySpecificDay = HourlySpecificDay(
                time=1900,
                weatherType= WeatherType.SUN,
                temp=5,
                umidity=2
            ),
            place = Place(
                city = "palermo",
                region = "sicilia",
                date = Date(),
            )

        ),
        DaySpecificDay(

            cardSpecificDay = CardSpecificDay(
                percepita = 10,
                umidita= 1,
                copertura=4,
                uv=2,
                vento=2,
                pioggia=4
            ),
            hourlySpecificDay = HourlySpecificDay(
                time=2000,
                weatherType= WeatherType.SUN,
                temp=5,
                umidity=2
            ),
            place = Place(
                city = "palermo",
                region = "sicilia",
                date = Date(),
            )

        ),
        DaySpecificDay(

            cardSpecificDay = CardSpecificDay(
                percepita = 10,
                umidita= 1,
                copertura=4,
                uv=2,
                vento=2,
                pioggia=4
            ),
            hourlySpecificDay = HourlySpecificDay(
                time=2100,
                weatherType= WeatherType.SUN,
                temp=5,
                umidity=2
            ),
            place = Place(
                city = "palermo",
                region = "sicilia",
                date = Date(),
            )

        ),
        DaySpecificDay(

            cardSpecificDay = CardSpecificDay(
                percepita = 10,
                umidita= 1,
                copertura=4,
                uv=2,
                vento=2,
                pioggia=4
            ),
            hourlySpecificDay = HourlySpecificDay(
                time=2200,
                weatherType= WeatherType.SUN,
                temp=5,
                umidity=2
            ),
            place = Place(
                city = "palermo",
                region = "sicilia",
                date = Date(),
            )

        ),
        DaySpecificDay(

            cardSpecificDay = CardSpecificDay(
                percepita = 10,
                umidita= 1,
                copertura=4,
                uv=2,
                vento=2,
                pioggia=4
            ),
            hourlySpecificDay = HourlySpecificDay(
                time=2300,
                weatherType= WeatherType.SUN,
                temp=5,
                umidity=2
            ),
            place = Place(
                city = "palermo",
                region = "sicilia",
                date = Date(),
            )

        )

    )
   fun getSpecificDay(): List<DaySpecificDay> = specificaDayList
}

