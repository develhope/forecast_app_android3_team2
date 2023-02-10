package co.develhope.meteoapp.data.domainmodel

import java.util.Date

data class Place(
    val city: String,
    val region: String,
    val lat: Double,
    val log: Double,
    val date: Date
)