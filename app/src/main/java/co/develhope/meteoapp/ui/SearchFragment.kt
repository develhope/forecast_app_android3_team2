package co.develhope.meteoapp.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.data.DataSource
import co.develhope.meteoapp.databinding.FragmentSearchBinding
import co.develhope.meteoapp.ui.adapter.SearchAdapter
import co.develhope.meteoapp.ui.utils.createListSearch

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listSearch = createListSearch(DataSource.loadSearchData())
        val adapterSearch = SearchAdapter(listSearch)
        binding.RVSearch.adapter = adapterSearch
        binding.RVSearch.layoutManager = LinearLayoutManager(view.context)
        searchCity()
    }

    private fun searchCity() {
        binding.searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                val filterSearch = DataSource.loadSearchData().filter {
                    it.cityName.contains(s.toString(), true)
                }
                Log.d("searchBar", "$filterSearch")
                binding.RVSearch.adapter = SearchAdapter(
                    createListSearch(filterSearch)
                )
            }

        })
    }

}

