package co.develhope.meteoapp.homepage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.databinding.FragmentHomepageBinding
import co.develhope.meteoapp.homepage.Adapter.HomePageAdapter
import co.develhope.meteoapp.homepage.Adapter.HomePageAdapter.Companion.TYPE_CARD
import co.develhope.meteoapp.homepage.Adapter.HomePageAdapter.Companion.TYPE_CURRENTCITY
import co.develhope.meteoapp.homepage.Adapter.HomePageAdapter.Companion.TYPE_PROX5DAY
import co.develhope.meteoapp.homepage.Data.DataItem.loadData

class HomePage : Fragment() {
    private lateinit var binding: FragmentHomepageBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomepageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapterCard = HomePageAdapter (TYPE_CARD,loadData())
        binding.RVhome.adapter =adapterCard
        binding.RVhome.layoutManager = LinearLayoutManager(view.context)

        val adapterCurrentCity = HomePageAdapter (TYPE_CURRENTCITY,loadData())
        binding.RVhome.adapter =adapterCurrentCity
        binding.RVhome.layoutManager = LinearLayoutManager(view.context)

        val adapterSubTitle = HomePageAdapter (TYPE_PROX5DAY,loadData())
        binding.RVhome.adapter =adapterSubTitle
        binding.RVhome.layoutManager = LinearLayoutManager(view.context)
        }

    override fun onDestroyView() {
        super.onDestroyView()
        binding
    }
}
