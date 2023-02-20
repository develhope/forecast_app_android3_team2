package co.develhope.meteoapp.network.geocoding.DTO

data class Daily(
    val precipitation_sum: List<Double>,
    val temperature_2m_max: List<Double>,
    val temperature_2m_min: List<Double>,
    val time: List<String>,
    val uv_index_max: List<Double>,
    val weathercode: List<Int>,
    val windspeed_10m_max: List<Double>
)