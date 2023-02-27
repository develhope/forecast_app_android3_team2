package co.develhope.meteoapp.data.domainmodel

import co.develhope.meteoapp.R

enum class WeatherType {
    SUNNY, CLOUDY, RAINY;

    fun setIconWeatherType(): Int {
        return when (this) {
            SUNNY -> R.drawable.sun
            RAINY -> R.drawable.rain
            CLOUDY -> R.drawable.sun_cloud
        }
    }

}
fun Int?.getWeatherType(): WeatherType {
    return when (this) {
        0, 1 -> WeatherType.SUNNY
        2, 3 -> WeatherType.RAINY
        4, 5 -> WeatherType.CLOUDY
        else -> WeatherType.CLOUDY

    }
}