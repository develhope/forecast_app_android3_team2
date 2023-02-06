package co.develhope.meteoapp.homepage.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.CurrentCityTemplateBinding
import co.develhope.meteoapp.databinding.SubtitleTemplateBinding
import co.develhope.meteoapp.databinding.TemplateCardBinding
import co.develhope.meteoapp.homepage.Model.HomePageItem
import co.develhope.meteoapp.homepage.Model.WeatherType

class HomePageAdapter(
    private val dataset: List<HomePageItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_CARD -> CardViewHolder(
                TemplateCardBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            TYPE_CURRENTCITY -> CurrentCityViewHolder(
                CurrentCityTemplateBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            TYPE_PROX5DAY -> SubTitleViewHolder(
                SubtitleTemplateBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            else -> throw java.lang.IllegalArgumentException("error")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CardViewHolder -> holder.bind(dataset[position] as HomePageItem.CardItem)

            is CurrentCityViewHolder -> holder.bind(dataset[position] as HomePageItem.Title)

            is SubTitleViewHolder -> holder.bind(dataset[position] as HomePageItem.Subtitle)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }


    override fun getItemViewType(position: Int): Int {
        return when (dataset[position]) {
            is HomePageItem.CardItem -> TYPE_CARD
            is HomePageItem.Title -> TYPE_CURRENTCITY
            is HomePageItem.Subtitle -> TYPE_PROX5DAY
        }
    }

    class CardViewHolder(private val binding: TemplateCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cardItem: HomePageItem.CardItem) {

            binding.day.text = "Lunedì"
            binding.data.text = "01/10"
            binding.tempmin.text = itemView.context.getString(R.string.tempmin,cardItem.dailyForecast.weatherSummary.tempMin.toString())
            binding.tempmax.text = itemView.context.getString(R.string.tempmax,cardItem.dailyForecast.weatherSummary.tempMax.toString())
            binding.kmh.text = itemView.context.getString(R.string.kmh,cardItem.dailyForecast.weatherSummary.wind.toString())
            binding.umidity.text = itemView.context.getString(R.string.rain,cardItem.dailyForecast.weatherSummary.rain.toString())
            binding.imagetype.setImageResource(cardItem.dailyForecast.weatherSummary.weatherType.setIconWeatherType())

        }
    }

    class CurrentCityViewHolder(private val binding: CurrentCityTemplateBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(currentcity: HomePageItem.Title) {
            binding.currentCityTextview.text = itemView.context.getString(R.string.title_homepage, currentcity.place.city, currentcity.place.region)
        }
    }

    class SubTitleViewHolder(private val binding: SubtitleTemplateBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(Sub: HomePageItem.Subtitle) {
            binding.textView.text = binding.root.context.getString(R.string.next_days)
        }
    }

    companion object {
        const val TYPE_CARD = 0
        const val TYPE_CURRENTCITY = 1
        const val TYPE_PROX5DAY = 2
    }
}