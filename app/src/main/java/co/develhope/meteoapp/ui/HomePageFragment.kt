package co.develhope.meteoapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.data.domainmodel.DayForecast
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.data.domainmodel.WeatherSummary
import co.develhope.meteoapp.databinding.FragmentHomepageBinding
import co.develhope.meteoapp.network.NetworkProvider
import co.develhope.meteoapp.ui.adapter.HomePageAdapter
import co.develhope.meteoapp.ui.adapter.HomePageItem
import kotlinx.coroutines.launch
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter

class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomepageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomepageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        binding.RVhome.layoutManager = LinearLayoutManager(view.context)

    }

    override fun onStart() {
        super.onStart()

        lifecycleScope.launch {
            try {
                val palermo : List<WeatherSummary> = NetworkProvider().getWeekSummary(
                    38.116667,
                    13.366667,
                    OffsetDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE).toString(),
                    OffsetDateTime.now().plusDays(6).format(DateTimeFormatter.ISO_LOCAL_DATE)
                        .toString()
                )
                val adapterCard = HomePageAdapter(createListToShow(palermo))
                binding.RVhome.adapter = adapterCard
                Log.d("prova", "${palermo.get(0)}")
                Log.d("prova", "${palermo.get(1)}")
                Log.d("prova", "${palermo.get(2)}")
                Log.d("prova", "${palermo.get(3)}")
                Log.d("prova", "${palermo.get(4)}")
                Log.d("prova", "${palermo.get(5)}")
                Log.d("prova", "${palermo.get(6)}")

            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("prova", "errore")
                Log.d("prova", "${OffsetDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE)}")

            }
        }
    }

    private fun getPlace() : Place = Place(
        city = "Palermo",
        region = "Sicilia",
        lat = 38.116667,
        log = 13.366667
    ) //DataSource.getPlace()

    private fun createitemfothompage(item: List<WeatherSummary>): List<DayForecast> {
        val homepageitem = item.mapIndexed { index, weatherSummary ->
            DayForecast(
                place = Place(
                    city = "Palermo",
                    region = "Sicilia",
                    lat = 38.12136,
                    log = 13.35844,
                ),  weatherSummary = WeatherSummary(
                    weatherType = weatherSummary.weatherType,
                    humidity = weatherSummary.humidity,
                    wind = weatherSummary.wind,
                    tempMin = weatherSummary.tempMin,
                    tempMax = weatherSummary.tempMax,
                    rain = weatherSummary.rain,
                    date= weatherSummary.date
                )
            )

        }
        return homepageitem
    }

    private fun createListToShow(dayForecastList: List<WeatherSummary>): List<HomePageItem> {
        val listToReturn = mutableListOf<HomePageItem>()

        listToReturn.add(HomePageItem.Title(getPlace()))
        listToReturn.add(HomePageItem.CardItem(dayForecastList.first()))
        listToReturn.add(HomePageItem.Subtitle)

        val filteredList = dayForecastList.drop(1)
        val othersDays: MutableList<HomePageItem.CardItem> = filteredList.map {
            HomePageItem.CardItem(it)
        }.toMutableList()

        listToReturn.addAll(othersDays)
        return listToReturn
    }

}