package co.develhope.meteoapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.data.domainmodel.DayForecast
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.data.domainmodel.WeatherSummary
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.DataSource
import co.develhope.meteoapp.databinding.FragmentHomepageBinding
import co.develhope.meteoapp.network.NetworkProvider
import co.develhope.meteoapp.ui.adapter.HomePageAdapter
import co.develhope.meteoapp.ui.adapter.HomePageItem
import kotlinx.coroutines.launch
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter
import co.develhope.meteoapp.ui.adapter.HomepageAction
import co.develhope.meteoapp.ui.model.HomePageViewModel
import co.develhope.meteoapp.ui.utils.createListToShow

class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomepageBinding
    private lateinit var viewModel : HomePageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomepageBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(HomePageViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.RVhome.layoutManager = LinearLayoutManager(view.context)
    }

    override fun onStart() {
        super.onStart()
        if (DataSource.getSelectedPlace() == null) {
            findNavController().navigate(R.id.searchFragment)
        } else {
            viewModel.getHomeCoroutine()
        }

        viewModel.homepageResult.observe(viewLifecycleOwner){
            val adapterCard =
                HomePageAdapter(createListToShow(it)) {
                    when (it) {
                        HomepageAction.CardClick -> findNavController().navigate(R.id.action_homePageFragment_to_specificDayFragment)
                    }
                }
            binding.RVhome.adapter = adapterCard

        }

    }




    private fun createitemfothompage(item: List<WeatherSummary>): List<DayForecast> {
        val homepageitem = item.mapIndexed { index, weatherSummary ->
            DayForecast(
                place = Place(
                    city = "Palermo",
                    region = "Sicilia",
                    lat = 38.12136,
                    log = 13.35844,
                ), weatherSummary = WeatherSummary(
                    weatherType = weatherSummary.weatherType,
                    humidity = weatherSummary.humidity,
                    wind = weatherSummary.wind,
                    tempMin = weatherSummary.tempMin,
                    tempMax = weatherSummary.tempMax,
                    rain = weatherSummary.rain,
                    date = weatherSummary.date
                )
            )

        }
        return homepageitem
    }



}