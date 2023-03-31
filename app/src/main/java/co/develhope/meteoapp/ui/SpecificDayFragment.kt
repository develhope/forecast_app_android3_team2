package co.develhope.meteoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.ApplicationMeteo
import co.develhope.meteoapp.data.domainmodel.HourlyForecast
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.databinding.FragmentSpecificDayBinding
import co.develhope.meteoapp.ui.adapter.SpecificDayAdapter
import co.develhope.meteoapp.ui.adapter.SpecificDayModel
import co.develhope.meteoapp.ui.model.SpecificDayResult
import co.develhope.meteoapp.ui.model.SpecificDayViewModel
import co.develhope.meteoapp.ui.utils.createListToShowSpecificDay
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
        viewModel= ViewModelProvider(this)[SpecificDayViewModel::class.java]

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.itemSpecificday.layoutManager = LinearLayoutManager(view.context)

    }

    override fun onStart() {
        super.onStart()
        viewModel.getHourlyForecast()

        setupObserver()
    }

    private fun setupObserver() {
        viewModel.specificDayResult.observe(viewLifecycleOwner) {
            when(it){
                is SpecificDayResult.Error -> TODO()
                is SpecificDayResult.Success -> {

                     val filteredList : List<HourlyForecast> =   if(ApplicationMeteo.preferences?.getPreferenceDate()!!.dayOfYear == OffsetDateTime.now().dayOfYear){
                        it.list.filter {hourlyForecast ->
                            hourlyForecast.hourlySpecificDay.time.isAfter(OffsetDateTime.now())
                        }
                    }else{
                        it.list
                    }
                    val specificDayItems= createListToShowSpecificDay(filteredList, it.place,it.date)
                    val adapter = SpecificDayAdapter(specificDayItems)
                    binding.itemSpecificday.adapter = adapter
                }
                SpecificDayResult.GenericError -> TODO()
            }

        }

    }

    private fun createListHour (list: List<HourlyForecast>, place: Place, date: OffsetDateTime): List<SpecificDayModel>{
        val listToReturn = mutableListOf<SpecificDayModel>()

        listToReturn.add(SpecificDayModel.SpecificDayTitle(place,date))


        val otherHours: MutableList<SpecificDayModel.SpecificDayHourly> = list.map {
            SpecificDayModel.SpecificDayHourly(it)
        }.toMutableList()
        listToReturn.addAll(otherHours)

        return listToReturn

    }
}



