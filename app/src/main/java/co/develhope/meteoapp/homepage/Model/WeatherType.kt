package co.develhope.meteoapp.homepage.Model

import co.develhope.meteoapp.R

enum class WeatherType {
    sun, sun_cloud, rain;

    fun setIconWeatherType(): Int {
        return when(this){
            sun -> R.drawable.sun
            rain -> R.drawable.rain
            sun_cloud -> R.drawable.sun_cloud
        }
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

