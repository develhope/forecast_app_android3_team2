package co.develhope.meteoapp.homepage.Model


sealed class HomePageItem {
    data class CardItem(
        val info :HourlyForecast,
    ) : HomePageItem()

    object Title: HomePageItem(){
        val city =("palermo")
        val region =("sicilia")
    }
    object Sub: HomePageItem(){
        val info =("Prossimi 5 giorni")
    }
}

