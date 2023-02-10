package co.develhope.meteoapp.ui.adapter

import co.develhope.meteoapp.SearchPage.Model.SearchCity

sealed class SearchItem {
    data class SearchCard(val info: SearchCity) : SearchItem()
    object RicercheRecenti : SearchItem()
}
