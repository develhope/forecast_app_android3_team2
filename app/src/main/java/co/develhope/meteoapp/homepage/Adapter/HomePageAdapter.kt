package co.develhope.meteoapp.homepage.Adapter

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
): RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            TYPE_CARD -> CardViewHolder(
                TemplateCardBinding.inflate(
                LayoutInflater.from(parent.context),parent,false))

            TYPE_CURRENTCITY -> CurrentCityViewHolder(
                CurrentCityTemplateBinding.inflate(
                LayoutInflater.from(parent.context),parent,false))

            TYPE_PROX5DAY -> SubTitleViewHolder(
                SubtitleTemplateBinding.inflate(
                LayoutInflater.from(parent.context),parent,false))

            else -> throw java.lang.IllegalArgumentException("error")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is CardViewHolder -> holder.bind(dataset[position] as HomePageItem.CardItem)

            is CurrentCityViewHolder -> holder.bind(dataset[position] as HomePageItem.Title)

            is SubTitleViewHolder -> holder.bind(dataset[position] as HomePageItem.Sub)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }


    override fun getItemViewType(position: Int): Int {
        return when(dataset[position]){
            is HomePageItem.CardItem -> TYPE_CARD
            is HomePageItem.Title -> TYPE_CURRENTCITY
            is HomePageItem.Sub -> TYPE_PROX5DAY
        }
    }

    class CardViewHolder(val binding: TemplateCardBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(cardItem: HomePageItem.CardItem){
            binding.day.text =cardItem.info.day
            binding.data.text =cardItem.info.data
            binding.tempmin.text =cardItem.info.tempMin.toString()
            binding.tempmax.text =cardItem.info.tempMax.toString()
            binding.kmh.text = cardItem.info.kmh.toString()
            binding.numperecip.text =cardItem.info.umidity.toString()
            binding.imageWheather.setImageResource(cardItem.info.type.setIconWeatherType(WeatherType.rain))

        }
    }

    class CurrentCityViewHolder(val binding: CurrentCityTemplateBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(currentcity:HomePageItem.Title){
            binding.currentCityTextview.text=binding.root.context.getString(R.string.title_homepage, currentcity.city,currentcity.region)
        }
    }

    class SubTitleViewHolder(val binding: SubtitleTemplateBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(prox5day: HomePageItem.Sub){
            binding.textView.text=prox5day.info
        }
    }

    companion object{
        val TYPE_CARD = 0
        val TYPE_CURRENTCITY = 1
        val TYPE_PROX5DAY = 2
    }
}