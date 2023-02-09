@file:Suppress("UNCHECKED_CAST")

package co.develhope.meteoapp.SearchPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.SearchPage.Adapter.SearchAdapter
import co.develhope.meteoapp.SearchPage.Data.SearchDataItem.loadSearchData
import co.develhope.meteoapp.SearchPage.Model.SearchCity
import co.develhope.meteoapp.SearchPage.Model.SearchItem
import co.develhope.meteoapp.databinding.FragmentSearchBinding


class Search : Fragment() {
private lateinit var binding: FragmentSearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listSearch = createListSearch(loadSearchData())
        val adapterSearch =SearchAdapter(listSearch)
        binding.RVSearch.adapter =adapterSearch
        binding.RVSearch.layoutManager = LinearLayoutManager(view.context)


    }
}

private fun createListSearch(searchCity : List<SearchCity>):List<SearchItem>{
    val listToReturn = mutableListOf<SearchItem>()
    listToReturn.add(SearchItem.RicercheRecenti)
    val listSearchCity: MutableList<SearchItem.SearchCard> = searchCity.map {
        SearchItem.SearchCard(it)
    }.toMutableList()
    listToReturn.addAll(listSearchCity)
    return listToReturn
    }


