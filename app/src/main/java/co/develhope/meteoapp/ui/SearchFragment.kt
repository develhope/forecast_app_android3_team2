package co.develhope.meteoapp.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.DataSource
import co.develhope.meteoapp.data.domainmodel.DaySpecificDay
import co.develhope.meteoapp.databinding.FragmentSearchBinding
import co.develhope.meteoapp.network.NetworkProvider
import co.develhope.meteoapp.ui.adapter.SearchAction
import co.develhope.meteoapp.ui.adapter.SearchAdapter
import co.develhope.meteoapp.ui.utils.createListSearch
import kotlinx.coroutines.launch
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter

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
                searchPlace(s.toString())
            }

        })
    }
        private fun searchPlace(place : String) {
            lifecycleScope.launch {
                try {
                    val places = NetworkProvider().getPlace(
                        place
                    )
                    binding.RVSearch.adapter = SearchAdapter(
                        createListSearch(places)
                    ){action, place ->
                        DataSource.saveSelectedPlace(place)
                        Log.d("prova di salvataggio", "${DataSource.getSelectedPlace()}")
                        when(action){
                            SearchAction.CardClick -> findNavController().navigate(R.id.action_searchFragment_to_homePageFragment)
                        }
                    }

                    Log.d("provaPlace","$places")

                } catch (e: Exception) {
                    e.printStackTrace()
                    Log.d("prova", "errore")

                }
            }
        }
}

