package co.develhope.meteoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.DataSource
import co.develhope.meteoapp.databinding.FragmentHomepageBinding
import co.develhope.meteoapp.ui.adapter.CardClick
import co.develhope.meteoapp.ui.adapter.HomePageAdapter
import co.develhope.meteoapp.ui.adapter.HomePageItem
import co.develhope.meteoapp.ui.utils.createListToShow

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

        val listHome = createListToShow(DataSource.getDayForecast())
        val adapterCard = HomePageAdapter(listHome,object: CardClick {
            override fun onClickListener(cardItem: HomePageItem.CardItem, position: Int) {
                    findNavController().navigate(R.id.action_homePageFragment_to_specificDayFragment)
            }
        })
        binding.RVhome.adapter = adapterCard
        binding.RVhome.layoutManager = LinearLayoutManager(view.context)

    }

}