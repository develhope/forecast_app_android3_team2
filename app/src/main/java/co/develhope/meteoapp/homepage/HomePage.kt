package co.develhope.meteoapp.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.databinding.FragmentHomepageBinding
import co.develhope.meteoapp.homepage.Adapter.HomePageAdapter
import co.develhope.meteoapp.homepage.Adapter.HomePageAdapter.Companion.TYPE_CARD
import co.develhope.meteoapp.homepage.Data.DailyForecast
import co.develhope.meteoapp.homepage.Data.DataItem.getDailyForecast
import co.develhope.meteoapp.homepage.Data.DataItem.loadData
import co.develhope.meteoapp.homepage.Model.HomePageItem

class HomePage : Fragment() {
    private lateinit var binding: FragmentHomepageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomepageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //list for the adapter
        val listToshow = createListToshow(getDailyForecast())

        val adapterCard = HomePageAdapter(TYPE_CARD, loadData())
        binding.RVhome.adapter = adapterCard
        binding.RVhome.layoutManager = LinearLayoutManager(view.context)

    }

    private fun createListToshow(dailyForecast: List<DailyForecast>): List<HomePageItem> {
        val listToReturn = mutableListOf<HomePageItem>()

        listToReturn.add(HomePageItem.Title)
        listToReturn.add(HomePageItem.DailyWeather(dailyForecast.first()))
        listToReturn.add(HomePageItem.Sub)
        val otherDays: MutableList<HomePageItem.DailyWeather> = dailyForecast.map { HomePageItem.DailyWeather(it) }.toMutableList()
        listToReturn.addAll(otherDays)

        return listToReturn
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding
    }
}
