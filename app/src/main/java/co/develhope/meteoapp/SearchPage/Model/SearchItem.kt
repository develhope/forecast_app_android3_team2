package co.develhope.meteoapp.SearchPage.Model

sealed class SearchItem{
    data class SearchCard(val info: SearchCity):SearchItem()
   object RicercheRecenti:SearchItem()
}
