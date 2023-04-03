package co.develhope.meteoapp.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.ApplicationMeteo
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.databinding.FragmentSearchBinding
import co.develhope.meteoapp.ui.adapter.SearchAction
import co.develhope.meteoapp.ui.adapter.SearchAdapter
import co.develhope.meteoapp.ui.model.SearchResult
import co.develhope.meteoapp.ui.model.SearchViewModel
import co.develhope.meteoapp.ui.utils.createListSearch
class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var viewModel: SearchViewModel

    // Aggiungi questa variabile per tenere traccia della visibilità delle ricerche recenti
    private var isRecentSearchVisible = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[SearchViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.RVSearch.layoutManager = LinearLayoutManager(view.context)
        searchCity()
        recentSearch(ApplicationMeteo.preferences?.getPreferencePlace()!!)
    }

    private fun searchCity() {
        binding.searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.toString().length > 2) {

                    viewModel.searchPlace(
                        s.toString(),
                        requireContext().getString(R.string.language)
                    )
                }
            }
        })
    }

    override fun onStart() {
        super.onStart()
        setupViewModel()

    }

    private fun setupViewModel() {
        viewModel.searchResult.observe(viewLifecycleOwner) {
            when (it) {
                is SearchResult.Success -> {
                    binding.RVSearch.adapter = SearchAdapter(
                        createListSearch(it.list)
                    ) { action, place ->
                        val recentSearches =
                            ApplicationMeteo.preferences?.getRecentSearch()?.toMutableList()
                                ?: mutableListOf()
                        recentSearches.add(place)
                        ApplicationMeteo.preferences?.saveRecentSearches(recentSearches)

                        ApplicationMeteo.preferences?.savePreferencePlace(place)
                        Log.d("place", "${ApplicationMeteo.preferences?.getPreferencePlace()}")
                        when (action) {
                            SearchAction.CardClick -> findNavController().navigate(R.id.action_searchFragment_to_homePageFragment)
                        }
                    }
                }
                is SearchResult.Error -> {
                    Log.e("vediamo", "${it.e.message}")
                    println(it.e.message)
                    Toast.makeText(
                        requireContext(),
                        "${it.e.message}",
                        Toast.LENGTH_LONG
                    ).show()

                }
                is SearchResult.GenericError -> TODO()
            }
        }
    }
    private fun recentSearch(place: Place){
        val list = ApplicationMeteo.preferences?.getRecentSearch() ?: emptyList()
        val loadList = list.toMutableList()
        loadList.add(place)
        if(loadList.size >6){
            loadList.removeFirst()
            ApplicationMeteo.preferences?.saveRecentSearches(loadList)
            return
        }
        ApplicationMeteo.preferences?.saveRecentSearches(loadList)
    }

}

