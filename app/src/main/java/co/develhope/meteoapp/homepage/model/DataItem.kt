package co.develhope.meteoapp.homepage.model

import co.develhope.meteoapp.R

object DataItem {
    private val listClass = mutableListOf<HomePageItem>(
        HomePageItem.CurrentCity("palermo","sicilia"),
        HomePageItem.CardItem("oggi", R.drawable.sun,22,22,22,22,22),
        HomePageItem.SubTitle("prossimi 5 giorni"),
        HomePageItem.CardItem("domani", R.drawable.sun,22,22,22,22,22),
        HomePageItem.CardItem("mercoledi", R.drawable.sun,22,22,22,22,22),
        HomePageItem.CardItem("giovedi", R.drawable.sun,22,22,22,22,22),
        HomePageItem.CardItem("venerdi", R.drawable.sun,22,22,22,22,22),
        HomePageItem.CardItem("sabato", R.drawable.sun,22,22,22,22,22),
    )
    fun loadData():List<HomePageItem> {
        return listClass
    }
}