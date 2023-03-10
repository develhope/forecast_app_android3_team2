package co.develhope.meteoapp.data.domainmodel

data class CardSpecificDay(
    val percepita: Int,
    val umidita: Int,
    val copertura: Int,
    val uv: Int?,
    val vento: Int,
    val pioggia: Int
)