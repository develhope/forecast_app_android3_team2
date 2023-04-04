package co.develhope.meteoapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.rotationMatrix
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.SpecificdayCardBinding
import co.develhope.meteoapp.databinding.SpecificdayHourlyBinding
import co.develhope.meteoapp.databinding.SpecificdayTitleBinding
import co.develhope.meteoapp.ui.utils.getLocalizedDay
import co.develhope.meteoapp.ui.utils.getLocalizedMonth


class SpecificDayAdapter(private val list: List<SpecificDayModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {
            is SpecificDayModel.SpecificDayTitle -> TITLE

            is SpecificDayModel.SpecificDayHourly -> HOURLY

        }
    }


    class TitleViewHolder(private val title: SpecificdayTitleBinding) :
        RecyclerView.ViewHolder(title.root) {

        fun bind(infoTitle: SpecificDayModel.SpecificDayTitle) {
            title.titleSpecificDay.text = itemView.context.getString(
                R.string.city_region,
                infoTitle.place.city,
                infoTitle.place.region
            )
            title.infoDateSpecificDay.text = itemView.context.getString(
                R.string.today_details, getLocalizedDay(
                    infoTitle.date.dayOfWeek.name
                ),
                infoTitle.date.dayOfMonth.toString(),
                getLocalizedMonth(infoTitle.date.month.name)
            )

        }
    }

    class HourlyViewHolder(private val hourly: SpecificdayHourlyBinding) :
        RecyclerView.ViewHolder(hourly.root) {

        fun bind(infoHourly: SpecificDayModel.SpecificDayHourly) {
            hourly.specificDayTime.text = itemView.context.getString(
                R.string.time,
                infoHourly.hourlyForecast.hourlySpecificDay.time.hour.toString()
            )
            hourly.specificdayType.setImageResource( infoHourly.hourlyForecast.hourlySpecificDay.weatherType.setIconWeatherType())
            hourly.specificdayTemp.text = itemView.context.getString(
                R.string.temp,
                infoHourly.hourlyForecast.hourlySpecificDay.temp.toString()
            )
            hourly.specificdayUmidity.text = itemView.context.getString(
                R.string.umidity,
                infoHourly.hourlyForecast.hourlySpecificDay.umidity.toString()
            )
            hourly.spDatoPercepita.text = itemView.context.getString(
                R.string.DatoPercepita,
                infoHourly.hourlyForecast.cardSpecificDay.percepita.toString()
            )
            hourly.spDatoUv.text =
                itemView.context.getString(R.string.DatoUv, infoHourly.hourlyForecast.cardSpecificDay.uv.toString())
            hourly.spDatoUmidita.text = itemView.context.getString(
                R.string.DatoUmidita,
                infoHourly.hourlyForecast.cardSpecificDay.umidita.toString()
            )
            hourly.spDatoCopertura.text = itemView.context.getString(
                R.string.DatoCopertura,
                infoHourly.hourlyForecast.cardSpecificDay.copertura.toString()
            )
            hourly.spDatoPioggia.text = itemView.context.getString(
                R.string.DatoPioggia,
                infoHourly.hourlyForecast.cardSpecificDay.pioggia.toString()
            )
            hourly.spDatoVento.text = itemView.context.getString(
                R.string.DatoVento,
                infoHourly.hourlyForecast.cardSpecificDay.vento.toString()
            )
            hourly.freccia.setOnClickListener{

                hourly.cardItem.visibility=

                if (hourly.cardItem.visibility== View.GONE){
                    hourly.freccia.rotation = 180.0F
                    View.VISIBLE

                }
                else{
                    hourly.freccia.rotation = 0.0F
                    View.GONE

            } }

        }
        }

    companion object {
        const val TITLE = 0
        const val HOURLY = 1
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
            is HourlyViewHolder -> holder.bind(list[position] as SpecificDayModel.SpecificDayHourly)
        }

    }


    override fun getItemCount(): Int {
        return list.size
    }
}



