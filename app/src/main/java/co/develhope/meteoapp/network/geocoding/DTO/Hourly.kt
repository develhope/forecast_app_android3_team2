package co.develhope.meteoapp.network.geocoding.DTO

data class Hourly(
    val temperature_2m: List<Double>,
    val time: List<String>
)