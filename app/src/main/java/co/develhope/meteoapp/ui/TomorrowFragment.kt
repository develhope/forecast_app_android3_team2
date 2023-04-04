package co.develhope.meteoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.ApplicationMeteo
import co.develhope.meteoapp.data.DataSource.getDate
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
    private val args : TomorrowFragmentArgs by navArgs()

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
                    val specificDayItems =
                        createListToShowSpecificDay(it.list,it.place, selectDate())
                    val adapter = SpecificDayAdapter(specificDayItems)
                    binding.itemSpecificday.adapter = adapter
                }
                TomorrowResult.GenericError -> TODO()
            }

        }

    }
    fun selectDate() : OffsetDateTime {
        if (args.date.equals("tomorrow")) {
            return OffsetDateTime.now().plusDays(1)
        } else {
            return OffsetDateTime.parse(args.date)
        }
    }
    }

