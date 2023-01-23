package co.develhope.meteoapp.homepage.model

sealed class HomePageItem {
    data class CardItem(
        val oggi: String,
        val WheatherType: Int,
        val date: Int,
        val numMAx: Int,
        val numMin: Int,
        val umidity: Int,
        val KMH: Int
    ):HomePageItem()

    data class CurrentCity(
        val city: String,
        val region: String):HomePageItem()

    data class SubTitle(val string: String):HomePageItem()
}

