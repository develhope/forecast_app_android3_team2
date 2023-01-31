package co.develhope.meteoapp.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.databinding.FragmentHomepageBinding
import co.develhope.meteoapp.homepage.Adapter.HomePageAdapter
import co.develhope.meteoapp.homepage.Data.HomePageObject.getHourlyList
import co.develhope.meteoapp.homepage.Model.HomePageItem
import co.develhope.meteoapp.homepage.Model.HourlyForecast

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

        val listhome =createListToshow(getHourlyList())
        val adapterCard = HomePageAdapter (listhome)
        binding.RVhome.adapter =adapterCard
        binding.RVhome.layoutManager = LinearLayoutManager(view.context)

    }

}

    private fun createListToshow (hourlyForecast: List<HourlyForecast>):List<HomePageItem>{
        val listToreturn = mutableListOf<HomePageItem>()
        listToreturn.add(HomePageItem.Title)
        listToreturn.add(HomePageItem.CardItem(hourlyForecast.first()))
        listToreturn.add(HomePageItem.Sub)
        val othersDays :MutableList<HomePageItem.CardItem> = hourlyForecast.map {
            HomePageItem.CardItem(it) }.toMutableList()
        listToreturn.addAll(othersDays)
        return listToreturn
    }



