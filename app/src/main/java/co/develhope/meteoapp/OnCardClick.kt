package co.develhope.meteoapp

import co.develhope.meteoapp.ui.adapter.HomePageItem
import java.time.OffsetDateTime

interface OnCardClick {
fun click(cardItem: HomePageItem.CardItem)

}
