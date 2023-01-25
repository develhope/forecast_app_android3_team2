package co.develhope.meteoapp.SearchPage.Model

sealed class SearchItem{
    data class RicercheRecenti(val string: String):SearchItem()
    data class SearchCity(val cityName: String):SearchItem()
}
