package co.develhope.meteoapp.data

import co.develhope.meteoapp.R
import co.develhope.meteoapp.model.SpecificDayModel


object DataSource {


    private val specificDayList= mutableListOf<SpecificDayModel>(
        SpecificDayModel.SpecificDayTitle(
            "Palermo",
            "Sicilia",
            "Oggi",
            "10 Settembre"),
        SpecificDayModel.SpecificDayHourly(
            "11:00",
            R.drawable.sun,
            "31°",
            "0%"),

        SpecificDayModel.SpecificDayCard(
            "45°",
            "60%",
            "24%",
            "5/10",
            "SSE 17 Km/h",
            "0cm"),

        SpecificDayModel.SpecificDayHourly(
            "12:00",
            R.drawable.sun_cloud,
            "29°",
            "0%"),
        SpecificDayModel.SpecificDayHourly(
            "13:00",
            R.drawable.sun,
            "30°",
            "0%"),
        SpecificDayModel.SpecificDayHourly(
            "14:00",
            R.drawable.rain,
            "32°",
            "69%"),
        SpecificDayModel.SpecificDayHourly(
            "15:00",
            R.drawable.rain,
            "28°",
            "70%"),
        SpecificDayModel.SpecificDayHourly(
            "16:00",
            R.drawable.sun_cloud,
            "25°",
            "20%"
        ),
        SpecificDayModel.SpecificDayHourly(
            "17:00",
            R.drawable.sun,
            "22°",
            "0%"
        ),
        SpecificDayModel.SpecificDayHourly(
            "18:00",
            R.drawable.sun,
            "20°",
            "0%"
        ),
        SpecificDayModel.SpecificDayHourly(
            "19:00",
            R.drawable.sun_cloud,
            "18°",
            "0%"
        ),
        SpecificDayModel.SpecificDayHourly(
            "20:00",
            R.drawable.sun_cloud,
            "16°",
            "0%"
        ),
        SpecificDayModel.SpecificDayHourly(
            "21:00",
            R.drawable.sun_cloud,
            "11°",
            "0%"
        ),
        SpecificDayModel.SpecificDayHourly(
            "22:00",
            R.drawable.sun_cloud,
            "10°",
            "0%"
        ),
        SpecificDayModel.SpecificDayHourly(
            "23:00",
            R.drawable.moon,
            "10°",
            "0%"
        ),

        )

    fun loadData():List<SpecificDayModel>{
        return specificDayList
    }
}
