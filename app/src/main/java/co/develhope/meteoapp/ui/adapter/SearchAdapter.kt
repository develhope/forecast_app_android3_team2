package co.develhope.meteoapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.databinding.CardSearchTemplateBinding
import co.develhope.meteoapp.databinding.TemplateRicercheRecentiBinding

sealed class SearchAction(){
    object CardClick : SearchAction()
}
class SearchAdapter(

    private val dataset: List<SearchItem>,
    private val action: (SearchAction, Place) -> Unit

): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            TYPE_SEARCH_CITY -> CitySearchViewHolder(
                CardSearchTemplateBinding.inflate(
                    LayoutInflater.from(parent.context),parent,false))

            TYPE_RICERCHE_RECENTI -> RicercheRecentiViewHolder(
                TemplateRicercheRecentiBinding.inflate(
                    LayoutInflater.from(parent.context),parent,false))

            else -> throw  java.lang.IllegalArgumentException("error")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is CitySearchViewHolder -> holder.bind(dataset[position] as SearchItem.SearchCard, action , position )

            is RicercheRecentiViewHolder -> holder.bind(dataset[position] as SearchItem.RicercheRecenti)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun getItemViewType(position: Int): Int {
        return when(dataset[position]){
            is SearchItem.SearchCard -> TYPE_SEARCH_CITY
            is SearchItem.RicercheRecenti -> TYPE_RICERCHE_RECENTI
        }
    }

    class RicercheRecentiViewHolder(val binding: TemplateRicercheRecentiBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind (searchItem: SearchItem.RicercheRecenti){
            binding.ricercheRecenti.text = binding.root.context.getString(R.string.ricerche_recenti)
        }
    }

    class CitySearchViewHolder(val binding : CardSearchTemplateBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(city: SearchItem.SearchCard, action: (SearchAction, Place) -> Unit, position: Int){
            binding.city.text = binding.root.context.getString(R.string.city_search,city.info.city)
            binding.templateSearchCard.setOnClickListener {
                action(SearchAction.CardClick, city.info)
            }
        }
    }

    companion object{
        val TYPE_RICERCHE_RECENTI = 0
        val TYPE_SEARCH_CITY = 1
    }

}
