package co.develhope.meteoapp.SearchPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.R
import co.develhope.meteoapp.SearchPage.Adapter.SearchAdapter
import co.develhope.meteoapp.SearchPage.Adapter.SearchAdapter.Companion.TYPE_RICERCHE_RECENTI
import co.develhope.meteoapp.SearchPage.Adapter.SearchAdapter.Companion.TYPE_SEARCH_CITY
import co.develhope.meteoapp.SearchPage.Data.SearchDataItem.loadSearchData
import co.develhope.meteoapp.databinding.FragmentHomepageBinding
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
       val adapterCitySearch = SearchAdapter(TYPE_SEARCH_CITY,loadSearchData())
        binding.RVSearch.adapter =adapterCitySearch
        binding.RVSearch.layoutManager =LinearLayoutManager(view.context)

        val adapterRicercheRecenti= SearchAdapter(TYPE_RICERCHE_RECENTI, loadSearchData())
        binding.RVSearch.adapter =adapterRicercheRecenti
        binding.RVSearch.layoutManager =LinearLayoutManager(view.context)

    }
}