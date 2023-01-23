package co.develhope.meteoapp.model


sealed class SpecificDayModel {
    data class SpecificDayTitle( val citta: String,
                                 val regione: String,
                                 val giorno: String,
                                 val data: String): SpecificDayModel()

    data class SpecificDayCard(val percepita: String,
                               val umidita: String,
                               val copertura: String,
                               val uv: String,
                               val vento: String,
                               val pioggia: String ): SpecificDayModel()


    data class SpecificDayHourly(val time: String,
                                 val type: Int,
                                 val temp: String,
                                 val umidity: String): SpecificDayModel()
}
