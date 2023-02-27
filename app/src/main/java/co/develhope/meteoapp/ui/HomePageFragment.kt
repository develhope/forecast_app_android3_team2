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
import co.develhope.meteoapp.ui.adapter.HomePageAdapter
import co.develhope.meteoapp.ui.adapter.HomepageAction
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
        val adapterCard = HomePageAdapter(listHome){
            when(it){
                HomepageAction.CardClick ->findNavController().navigate(R.id.specificDayFragment)
            }
        }
        binding.RVhome.adapter = adapterCard
        binding.RVhome.layoutManager = LinearLayoutManager(view.context)

    }

}