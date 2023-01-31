package co.develhope.meteoapp.homepage.Data

import co.develhope.meteoapp.R
import co.develhope.meteoapp.homepage.Model.HomePageItem
import co.develhope.meteoapp.homepage.Model.HourlyForecast
import co.develhope.meteoapp.homepage.Model.WeatherType

object HomePageObject {
    fun setIconWeatherType(weatherType: WeatherType):Int{
        return when(weatherType){
            WeatherType.sun -> R.drawable.sun
            WeatherType.rain -> R.drawable.rain
            WeatherType.sun_cloud -> R.drawable.sun_cloud
        }
    }
    fun Int.getWeatherType():WeatherType {
        return when (this) {
            0, 1 -> WeatherType.sun
            2, 3 -> WeatherType.rain
            4, 5 -> WeatherType.sun_cloud
            else -> WeatherType.sun

        }
    }
    private val hourlyList= listOf<HourlyForecast>(
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




