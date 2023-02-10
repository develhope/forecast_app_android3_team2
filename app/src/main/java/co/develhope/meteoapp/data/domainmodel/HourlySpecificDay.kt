package co.develhope.meteoapp.data.domainmodel

data class HourlySpecificDay(
    val time: Int,
    val weatherType: WeatherType,
    val temp: Int,
    val umidity: Int
)