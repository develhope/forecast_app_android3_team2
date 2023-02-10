package co.develhope.meteoapp.SearchPage.Data

import co.develhope.meteoapp.SearchPage.Model.SearchCity

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