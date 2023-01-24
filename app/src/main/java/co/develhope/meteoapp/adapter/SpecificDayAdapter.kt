package co.develhope.meteoapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.SpecificdayCardBinding
import co.develhope.meteoapp.databinding.SpecificdayHourlyBinding
import co.develhope.meteoapp.databinding.SpecificdayTitleBinding
import co.develhope.meteoapp.model.SpecificDayModel




class SpecificDayAdapter ( private val context: Int, private val list: List<SpecificDayModel>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {
            is SpecificDayModel.SpecificDayTitle -> SpecificDayAdapter.TITLE
            is SpecificDayModel.SpecificDayCard -> SpecificDayAdapter.CARD
            is SpecificDayModel.SpecificDayHourly -> SpecificDayAdapter.HOURLY

        }
    }


    class TitleViewHolder(private val title: SpecificdayTitleBinding) :
        RecyclerView.ViewHolder(title.root) {

        fun bind(infoTitle: SpecificDayModel.SpecificDayTitle) {
            title.titleSp.text = title.root.context.getString(R.string.city_region, infoTitle.city, infoTitle.region)
            title.infoDateSp.text = title.root.context.getString(R.string.today_details, infoTitle.day, infoTitle.date)
        }
    }


    class CardViewHolder(private val card: SpecificdayCardBinding) :
        RecyclerView.ViewHolder(card.root) {

        fun bind(infoCard: SpecificDayModel.SpecificDayCard) {
            card.spGradi.text = card.root.context.getString(R.string.DatoPercepita, infoCard.percepita)
            card.spUVdato.text = card.root.context.getString(R.string.DatoUv, infoCard.uv)
            card.spPercUmidita.text = card.root.context.getString(R.string.DatoUmidita, infoCard.umidita)
            card.spPercCopertura.text = card.root.context.getString(R.string.DatoCopertura, infoCard.copertura)
            card.spPioggiaCm.text = card.root.context.getString(R.string.DatoPioggia, infoCard.pioggia)
            card.spVelocitaVento.text = card.root.context.getString(R.string.DatoVento, infoCard.vento)

        }
    }

    class HourlyViewHolder(private val hourly: SpecificdayHourlyBinding) :
        RecyclerView.ViewHolder(hourly.root) {

        fun bind(infoHourly: SpecificDayModel.SpecificDayHourly) {
            hourly.specificDayTime.text = hourly.root.context.getString(R.string.time, infoHourly.time)
            hourly.specificdayType.setImageResource(infoHourly.type)
            hourly.specificdayTemp.text = hourly.root.context.getString(R.string.temp, infoHourly.temp)
            hourly.specificdayUmidity.text = hourly.root.context.getString(R.string.umidity, infoHourly.umidity)

        }


    }

    companion object {
        const val TITLE = 0
        const val CARD = 1
        const val HOURLY = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TITLE -> { TitleViewHolder(
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
        when (holder){
            is TitleViewHolder -> holder.bind(list[position] as SpecificDayModel.SpecificDayTitle)
            is CardViewHolder -> holder.bind(list[position] as SpecificDayModel.SpecificDayCard)
            is HourlyViewHolder -> holder.bind( list [position] as SpecificDayModel.SpecificDayHourly)
        }

    }


    override fun getItemCount(): Int {
        return list.size
    }
}







