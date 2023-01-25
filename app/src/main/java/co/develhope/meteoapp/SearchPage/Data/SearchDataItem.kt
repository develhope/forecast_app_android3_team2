package co.develhope.meteoapp.SearchPage.Data

import co.develhope.meteoapp.SearchPage.Model.SearchItem

object SearchDataItem {
    val searchList= mutableListOf<SearchItem>(
        SearchItem.RicercheRecenti("Ricerche recenti"),
        SearchItem.SearchCity("palermo"),
        SearchItem.SearchCity("casteltermini"),
        SearchItem.SearchCity("ribera")
    )
    fun loadSearchData():List<SearchItem>{
        return searchList
    }
}