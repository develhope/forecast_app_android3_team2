package co.develhope.meteoapp.data

import org.threeten.bp.OffsetDateTime

object DataSource {
    private var dateSelected: OffsetDateTime? = null

    fun saveDate(date: OffsetDateTime){
        dateSelected = date

    }
    fun getDate() = dateSelected

}