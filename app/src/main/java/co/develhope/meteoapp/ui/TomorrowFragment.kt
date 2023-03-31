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
import co.develhope.meteoapp.databinding.FragmentSpecificDayBinding
import co.develhope.meteoapp.ui.adapter.SpecificDayAdapter
import co.develhope.meteoapp.ui.model.TodayResult
import co.develhope.meteoapp.ui.model.TomorrowResult
import co.develhope.meteoapp.ui.model.TomorrowViewModel
import co.develhope.meteoapp.ui.utils.createListToShowSpecificDay
import org.threeten.bp.OffsetDateTime


class TomorrowFragment : Fragment() {

    private var _binding: FragmentSpecificDayBinding? = null
    private lateinit var viewModel: TomorrowViewModel
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSpecificDayBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[TomorrowViewModel::class.java]
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.itemSpecificday.layoutManager = LinearLayoutManager(view.context)

    }
    override fun onStart() {
        super.onStart()
        viewModel.getTomorrowHourlyForecast()

        setupTomorrowObserver()
    }

    private fun setupTomorrowObserver() {
        viewModel.tomorrowResult.observe(viewLifecycleOwner) {
            when (it) {
                is TomorrowResult.Error -> TODO()
                is TomorrowResult.Success -> {

                    val filteredList: List<HourlyForecast> =
                        if (ApplicationMeteo.preferences?.getPreferenceDate()!!.dayOfYear == OffsetDateTime.now().dayOfYear) {
                            it.list.filter { hourlyForecast ->
                                hourlyForecast.hourlySpecificDay.time.isAfter(OffsetDateTime.now())
                            }
                        } else {
                            it.list
                        }
                    val specificDayItems =
                        createListToShowSpecificDay(filteredList, it.place, it.date)
                    val adapter = SpecificDayAdapter(specificDayItems)
                    binding.itemSpecificday.adapter = adapter
                }
                TomorrowResult.GenericError -> TODO()
            }

        }

    }
}