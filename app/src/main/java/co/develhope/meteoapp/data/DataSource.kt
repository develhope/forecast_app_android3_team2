package co.develhope.meteoapp.data

import co.develhope.meteoapp.data.domainmodel.Place
import org.threeten.bp.OffsetDateTime

object DataSource {

    private var placeSelected: Place? =  null
    fun saveSelectedPlace(place: Place){
        placeSelected = place
    }
    fun getSelectedPlace(): Place? = placeSelected
    fun getDate(): OffsetDateTime = OffsetDateTime.now()

}

    

