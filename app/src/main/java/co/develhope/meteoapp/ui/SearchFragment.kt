package co.develhope.meteoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.ui.adapter.SearchAdapter
import co.develhope.meteoapp.SearchPage.Data.SearchDataItem
import co.develhope.meteoapp.SearchPage.createListSearch
import co.develhope.meteoapp.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
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

        val listSearch = createListSearch(SearchDataItem.loadSearchData())
        val adapterSearch = SearchAdapter(listSearch)
        binding.RVSearch.adapter =adapterSearch
        binding.RVSearch.layoutManager = LinearLayoutManager(view.context)


    }
}