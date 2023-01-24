package co.develhope.meteoapp.homepage.model

import co.develhope.meteoapp.R

object DataItem {
    private val listClass = mutableListOf<HomePageItem>(
        HomePageItem.CurrentCity("palermo","sicilia"),
        HomePageItem.CardItem("oggi","11/10", WheatherType(R.drawable.sun),2,15,7,19),
        HomePageItem.SubTitle("PROSSIMI 5 GIORNI"),
        HomePageItem.CardItem("domani","11/10", WheatherType(R.drawable.sun),2,15,7,19),
        HomePageItem.CardItem("mercoledi","11/10", WheatherType(R.drawable.sun),2,15,7,19),
        HomePageItem.CardItem("giovedi","11/10", WheatherType(R.drawable.sun),2,15,7,19),
        HomePageItem.CardItem("venerdi","11/10", WheatherType(R.drawable.sun),2,15,7,19),
        HomePageItem.CardItem("sabato","11/10", WheatherType(R.drawable.sun),2,15,7,19),
        )
    fun loadData():List<HomePageItem> {
        return listClass
    }
}