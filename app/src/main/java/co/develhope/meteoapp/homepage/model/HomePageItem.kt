package co.develhope.meteoapp.homepage.model

sealed class HomePageItem {
    data class CardItem(
        val day: String,
        val data: String,
        val type: co.develhope.meteoapp.homepage.model.WheatherType,
        val tempMin: String,
        val tempMax: String,
        val umidity: String,
        val kmh: String
        ):HomePageItem()

    data class CurrentCity(
        val city: String,
        val region: String
        ):HomePageItem()

    data class SubTitle(val string: String):HomePageItem()

    data class WheatherType (val type: Int):HomePageItem()
}

