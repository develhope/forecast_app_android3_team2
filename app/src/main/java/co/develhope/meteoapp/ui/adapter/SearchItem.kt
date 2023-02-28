package co.develhope.meteoapp.ui.adapter

import co.develhope.meteoapp.data.domainmodel.Place

sealed class SearchItem {
    data class SearchCard(val info: Place) : SearchItem()
    object RicercheRecenti : SearchItem()
}
