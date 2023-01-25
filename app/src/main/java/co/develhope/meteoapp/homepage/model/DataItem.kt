package co.develhope.meteoapp.homepage.model

import co.develhope.meteoapp.R
import co.develhope.meteoapp.homepage.model.WheatherType.*

object DataItem {

    fun setIconWheather(weather:WheatherType): Int {
        return when (weather) {
            SUN -> R.drawable.sun
            SUN_CLOUD -> R.drawable.sun_cloud
            RAIN -> R.drawable.rain
        }
    }


    private val listClass = mutableListOf<HomePageItem>(
        HomePageItem.CurrentCity("palermo","sicilia"),
        HomePageItem.CardItem("oggi","11/10", SUN,"2°","15°","7%","19kmh"),
        HomePageItem.SubTitle("PROSSIMI 5 GIORNI"),
        HomePageItem.CardItem("domani","11/10", SUN_CLOUD,"2°","15","7","19"),
        HomePageItem.CardItem("mercoledi","11/10",RAIN,"2","15","7","19"),
        HomePageItem.CardItem("giovedi","11/10", SUN_CLOUD,"2","15","7","19"),
        HomePageItem.CardItem("venerdi","11/10",SUN_CLOUD,"2","15","7","19"),
        HomePageItem.CardItem("sabato","11/10", SUN,"2","15","7","19"),


        )
    fun loadData():List<HomePageItem> {
        return listClass
    }
}