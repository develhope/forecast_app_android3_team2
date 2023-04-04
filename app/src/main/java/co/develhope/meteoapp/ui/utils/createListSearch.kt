package co.develhope.meteoapp.ui.utils

import android.util.Log
import co.develhope.meteoapp.ApplicationMeteo
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.ui.adapter.SearchItem

fun createListSearch(searchCity: List<Place>): List<SearchItem> {
    val listToReturn = mutableListOf<SearchItem>()

    listToReturn.add(SearchItem.RicercheRecenti)

    val listSearchCity: MutableList<SearchItem.SearchCard> = searchCity.map {
        SearchItem.SearchCard(it)
    }.toMutableList()

    listToReturn.addAll(listSearchCity)
    return listToReturn
}



