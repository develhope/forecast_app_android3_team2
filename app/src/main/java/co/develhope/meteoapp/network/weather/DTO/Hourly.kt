package co.develhope.meteoapp.network.weather.DTO

data class Hourly(
    val temperature_2m: List<Double>,
    val time: List<String>
)