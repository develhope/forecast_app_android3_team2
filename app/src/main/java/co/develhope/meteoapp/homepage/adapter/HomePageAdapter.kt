package co.develhope.meteoapp.homepage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.CurrentCityTemplateBinding
import co.develhope.meteoapp.databinding.SubtitleTemplateBinding
import co.develhope.meteoapp.databinding.TemplateCardBinding
import co.develhope.meteoapp.homepage.model.HomePageItem

class HomePageAdapter(
    private val context: Int,
    private val dataset: List<HomePageItem>
): RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            TYPE_CARD -> CardViewHolder(TemplateCardBinding.inflate(
                LayoutInflater.from(parent.context),parent,false))

            TYPE_CURRENTCITY -> CurrentCityViewHolder(CurrentCityTemplateBinding.inflate(
                LayoutInflater.from(parent.context),parent,false))

            TYPE_PROX5DAY -> Prox5dayViewHoled(SubtitleTemplateBinding.inflate(
                LayoutInflater.from(parent.context),parent,false))

            else -> throw java.lang.IllegalArgumentException("error")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is CardViewHolder -> holder.bind(dataset[position] as HomePageItem.CardItem)

            is CurrentCityViewHolder -> holder.bind(dataset[position] as HomePageItem.CurrentCity)

            is Prox5dayViewHoled -> holder.bind(dataset[position] as HomePageItem.SubTitle)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }


    override fun getItemViewType(position: Int): Int {
        return when(dataset[position]){
            is HomePageItem.CardItem -> TYPE_CARD
            is HomePageItem.CurrentCity -> TYPE_CURRENTCITY
            is HomePageItem.SubTitle -> TYPE_PROX5DAY
        }
    }

    class CardViewHolder(val binding: TemplateCardBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(cardItem: HomePageItem.CardItem){
            binding.oggi.text =binding.root.context.getString(R.string.oggi,cardItem.oggi)
            binding.data.text =binding.root.context.getString(R.string.data,cardItem.date)
            binding.tempmin.text =binding.root.context.getString(R.string.tempmin,cardItem.numMin)
            binding.tempmax.text =binding.root.context.getString(R.string.tempmax,cardItem.numMAx)
            binding.kmh.text =binding.root.context.getString(R.string.kmh,cardItem.KMH)
            binding.numperecip.text =binding.root.context.getString(R.string.numpercip,cardItem.umidity)
            binding.imageView.setImageResource(R.drawable.sun)
        }
    }

    class CurrentCityViewHolder(val binding: CurrentCityTemplateBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(currentcity:HomePageItem.CurrentCity){
            binding.currentCityTextview.text=binding.root.context.getString(R.string.title_homepage,currentcity.city)
        }
    }

    class Prox5dayViewHoled(val binding: SubtitleTemplateBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(prox5day: HomePageItem.SubTitle){
            binding.textView.text=binding.root.context.getString(R.string.prox5day,prox5day.string)
        }
    }

    companion object{
        val TYPE_CARD=0
        val TYPE_CURRENTCITY=1
        val TYPE_PROX5DAY=2
    }
}