package co.develhope.meteoapp.homepage.Data

import co.develhope.meteoapp.R
import co.develhope.meteoapp.homepage.Model.HomePageItem
import co.develhope.meteoapp.homepage.Model.HourlyForecast
import co.develhope.meteoapp.homepage.Model.WeatherType

object HomePageObject {

    private val hourlyList= listOf(
        HourlyForecast(
            day ="oggi" ,
            data ="21/07",
            type = WeatherType.sun_cloud,
            umidity = 34,
            kmh = 12,
            tempMax = 22,
            tempMin = 6
        )
    )

    fun getHourlyList():List<HourlyForecast> = hourlyList

}




