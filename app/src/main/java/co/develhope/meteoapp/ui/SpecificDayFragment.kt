package co.develhope.meteoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.data.DataSource
import co.develhope.meteoapp.data.domainmodel.HourlyForecast
import co.develhope.meteoapp.databinding.FragmentSpecificDayBinding
import co.develhope.meteoapp.ui.adapter.SpecificDayAdapter
import co.develhope.meteoapp.ui.adapter.SpecificDayModel
import co.develhope.meteoapp.ui.model.SpecificDayResult
import co.develhope.meteoapp.ui.model.SpecificDayViewModel
import co.develhope.meteoapp.ui.utils.createListToShowSpecificDay


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
                    val specificDayItems: List<SpecificDayModel> = createListToShowSpecificDay(it.list)
                    val adapter = SpecificDayAdapter(specificDayItems)
                    binding.itemSpecificday.adapter = adapter
                }

            }

        }
    }
}



