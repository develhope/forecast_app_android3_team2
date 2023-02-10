package co.develhope.meteoapp.data

import co.develhope.meteoapp.data.domainmodel.SearchCity

object SearchDataItem {
    val searchList= listOf<SearchCity>(
        SearchCity(
            cityName = "Palermo"
        ),
        SearchCity(
            cityName = "Casteltermini"
        ),
        SearchCity(
            cityName = "Agrigento"
        ),
        SearchCity(
            cityName = "Catania"
        ),
    )
    fun loadSearchData(): List<SearchCity> {
        return searchList
    }
}