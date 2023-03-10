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

    private val searchList = listOf<Place>(

        Place(
            city = "Palermo",
            region = "Sicilia",
            lat = 0.0,
            log = 0.0,
        ),
        Place(
            city = "Casteltermini",
            region = "Sicilia",
            lat = 0.0,
            log = 0.0,
        ),
        Place(
            city = "Catania",
            region = "Sicilia",
            lat = 0.0,
            log = 0.0,
        ),
    )

    fun loadSearchData(): List<Place> {
        return searchList
    }

}

    

