package co.develhope.meteoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.adapter.SpecificDayAdapter
import co.develhope.meteoapp.data.DataSource
import co.develhope.meteoapp.databinding.FragmentSpecificDayBinding



class SpecificDay : Fragment() {

    private var _binding: FragmentSpecificDayBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSpecificDayBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val adapter1 = SpecificDayAdapter(SpecificDayAdapter.TITLE, DataSource.loadData())
        binding.itemSpecificday.adapter = adapter1
        binding.itemSpecificday.layoutManager = LinearLayoutManager(view.context)

        val adapter2 = SpecificDayAdapter(SpecificDayAdapter.CARD, DataSource.loadData())
        binding.itemSpecificday.adapter = adapter2
        binding.itemSpecificday.layoutManager = LinearLayoutManager(view.context)

        val adapter3 = SpecificDayAdapter(SpecificDayAdapter.HOURLY, DataSource.loadData())
        binding.itemSpecificday.adapter = adapter3
        binding.itemSpecificday.layoutManager = LinearLayoutManager(view.context)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

