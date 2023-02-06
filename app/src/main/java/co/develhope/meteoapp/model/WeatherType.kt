package co.develhope.meteoapp.model

import co.develhope.meteoapp.R

enum class WeatherType {
    SUN, SUN_CLOUD, RAIN, MOON;

    fun setIconWeatherType(): Int {
        return when(this){
            SUN -> R.drawable.sun
            RAIN -> R.drawable.rain
            SUN_CLOUD -> R.drawable.sun_cloud
            MOON -> R.drawable.moon
        }
    }
}

fun Int.getWeatherType():WeatherType {
    return when (this) {
        0, 1 -> WeatherType.SUN
        2, 3 -> WeatherType.RAIN
        4, 5 -> WeatherType.SUN_CLOUD
        else -> WeatherType.SUN

    }
}

