package co.develhope.meteoapp.data

import co.develhope.meteoapp.data.domainmodel.CardSpecificDay
import co.develhope.meteoapp.data.domainmodel.DayForecast
import co.develhope.meteoapp.data.domainmodel.DaySpecificDay
import co.develhope.meteoapp.data.domainmodel.HourlySpecificDay
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.data.domainmodel.WeatherSummary
import co.develhope.meteoapp.data.domainmodel.WeatherType
import org.threeten.bp.OffsetDateTime

object DataSource {

    private var placeSelected: Place? =  null
    fun saveSelectedPlace(place: Place){
        placeSelected = place
    }
    fun getSelectedPlace(): Place? = placeSelected
    fun getDate(): OffsetDateTime = OffsetDateTime.now()

}

    

