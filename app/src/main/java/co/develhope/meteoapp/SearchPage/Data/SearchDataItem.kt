package co.develhope.meteoapp.SearchPage.Data

import co.develhope.meteoapp.SearchPage.Model.SearchCity
import co.develhope.meteoapp.SearchPage.Model.SearchItem

object SearchDataItem {
    val searchList= listOf<SearchCity>(
        SearchCity(
            cityName = "Palermo"
        ),SearchCity(
            cityName = "Casteltermini"
        ),SearchCity(
            cityName = "Agrigento"
        ),SearchCity(
            cityName = "Catania"
        ),
    )
    fun loadSearchData(): List<SearchCity> {
        return searchList
    }
}