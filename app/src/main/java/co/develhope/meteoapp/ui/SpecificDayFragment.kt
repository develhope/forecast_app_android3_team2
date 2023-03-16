package co.develhope.meteoapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.data.DataSource
import co.develhope.meteoapp.data.domainmodel.HourlyForecast
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.databinding.FragmentSpecificDayBinding
import co.develhope.meteoapp.network.NetworkProvider
import co.develhope.meteoapp.ui.adapter.SpecificDayAdapter
import co.develhope.meteoapp.ui.adapter.SpecificDayModel
import co.develhope.meteoapp.ui.model.SpecificDayViewModel
import kotlinx.coroutines.launch
import org.threeten.bp.OffsetDateTime


class SpecificDayFragment : Fragment() {

    private var _binding: FragmentSpecificDayBinding? = null
private lateinit var viewModel: SpecificDayViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSpecificDayBinding.inflate(inflater, container, false)
        viewModel= ViewModelProvider(this).get(SpecificDayViewModel::class.java)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.itemSpecificday.layoutManager = LinearLayoutManager(view.context)

    }

    override fun onStart() {
        super.onStart()
        viewModel.getHourlyForecast()

        viewModel.specificDayResult.observe(viewLifecycleOwner){
            val specificDayItems: List<SpecificDayModel> = createListToShow(it)

            val adapter = SpecificDayAdapter(specificDayItems)
            binding.itemSpecificday.adapter = adapter
        }
    }




    private fun createListToShow(list: List<HourlyForecast>): List<SpecificDayModel> {
        val listToReturn = mutableListOf<SpecificDayModel>()
        val filteredList =
            list.filter { hourlyForecast -> hourlyForecast.hourlySpecificDay.time.isAfter(DataSource.getDate()) }


        listToReturn.add(SpecificDayModel.SpecificDayTitle(DataSource.getSelectedPlace()!!, date = DataSource.getDate()))
        listToReturn.add(SpecificDayModel.SpecificDayHourly(filteredList.first()))
        listToReturn.add(SpecificDayModel.SpecificDayCard(filteredList.first().cardSpecificDay))

        val otherHours: MutableList<SpecificDayModel.SpecificDayHourly> = filteredList.map {
            SpecificDayModel.SpecificDayHourly(it)
        }.toMutableList()
        listToReturn.addAll(otherHours)

        listToReturn.removeAt(3)
        return listToReturn
    }
}



