package co.develhope.meteoapp.homepage.model

sealed class HomePageItem {
    data class CardItem(
        val day: String,
        val data: String,
        val type: WheatherType,
        val tempMin: Int,
        val tempMax: Int,
        val umidity: Int,
        val kmh: Int
        ):HomePageItem()

    data class CurrentCity(
        val city: String,
        val region: String
        ):HomePageItem()

    data class SubTitle(val string: String):HomePageItem()
}

