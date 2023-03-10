package co.develhope.meteoapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.SpecificdayCardBinding
import co.develhope.meteoapp.databinding.SpecificdayHourlyBinding
import co.develhope.meteoapp.databinding.SpecificdayTitleBinding


class SpecificDayAdapter(private val list: List<SpecificDayModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {
            is SpecificDayModel.SpecificDayTitle -> TITLE
            is SpecificDayModel.SpecificDayCard -> CARD
            is SpecificDayModel.SpecificDayHourly -> HOURLY

        }
    }


    class TitleViewHolder(private val title: SpecificdayTitleBinding) :
        RecyclerView.ViewHolder(title.root) {

        fun bind(infoTitle: SpecificDayModel.SpecificDayTitle) {
            title.titleSpecificDay.text = itemView.context.getString(R.string.city_region, infoTitle.place.city, infoTitle.place.region)
            title.infoDateSpecificDay.text = itemView.context.getString(
                R.string.today_details,
                infoTitle.date.dayOfWeek.name,
                infoTitle.date.dayOfMonth.toString(),
                infoTitle.date.month.name
            )
        }
    }

    class CardViewHolder(private val card: SpecificdayCardBinding) :
        RecyclerView.ViewHolder(card.root) {

        fun bind(infoCard: SpecificDayModel.SpecificDayCard) {
            card.spDatoPercepita.text = itemView.context.getString(R.string.DatoPercepita, infoCard.cardSpecificDay.percepita.toString())
            card.spDatoUv.text = itemView.context.getString(R.string.DatoUv, infoCard.cardSpecificDay.uv.toString())
            card.spDatoUmidita.text = itemView.context.getString(R.string.DatoUmidita, infoCard.cardSpecificDay.umidita.toString())
            card.spDatoCopertura.text = itemView.context.getString(R.string.DatoCopertura, infoCard.cardSpecificDay.copertura.toString())
            card.spDatoPioggia.text = itemView.context.getString(R.string.DatoPioggia, infoCard.cardSpecificDay.pioggia.toString())
            card.spDatoVento.text = itemView.context.getString(R.string.DatoVento, infoCard.cardSpecificDay.vento.toString())

        }
    }


    class HourlyViewHolder(private val hourly: SpecificdayHourlyBinding) :
        RecyclerView.ViewHolder(hourly.root) {

        fun bind(infoHourly: SpecificDayModel.SpecificDayHourly) {
            hourly.specificDayTime.text = itemView.context.getString(R.string.time, infoHourly.hourlyForecast.hourlySpecificDay.time.hour.toString())
            hourly.specificdayType.setImageResource(infoHourly.hourlyForecast.hourlySpecificDay.weatherType.setIconWeatherType())
            hourly.specificdayTemp.text = itemView.context.getString(R.string.temp, infoHourly.hourlyForecast.hourlySpecificDay.temp.toString())
            hourly.specificdayUmidity.text = itemView.context.getString(R.string.umidity, infoHourly.hourlyForecast.hourlySpecificDay.umidity.toString())
        }
    }

    companion object {
        const val TITLE = 0
        const val CARD = 1
        const val HOURLY = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TITLE -> {
                TitleViewHolder(
                    SpecificdayTitleBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            CARD -> {
                CardViewHolder(
                    SpecificdayCardBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            HOURLY -> {
                HourlyViewHolder(
                    SpecificdayHourlyBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> throw java.lang.IllegalArgumentException("error")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TitleViewHolder -> holder.bind(list[position] as SpecificDayModel.SpecificDayTitle)
            is CardViewHolder -> holder.bind(list[position] as SpecificDayModel.SpecificDayCard)
            is HourlyViewHolder -> holder.bind(list[position] as SpecificDayModel.SpecificDayHourly)
        }

    }


    override fun getItemCount(): Int {
        return list.size
    }
}







