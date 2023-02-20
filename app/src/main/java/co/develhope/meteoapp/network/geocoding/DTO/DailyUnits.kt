package co.develhope.meteoapp.network.geocoding.DTO

data class DailyUnits(
    val precipitation_sum: String,
    val temperature_2m_max: String,
    val temperature_2m_min: String,
    val time: String,
    val uv_index_max: String,
    val weathercode: String,
    val windspeed_10m_max: String
)