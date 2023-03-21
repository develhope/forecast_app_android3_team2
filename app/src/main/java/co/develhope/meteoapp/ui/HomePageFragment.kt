package co.develhope.meteoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.DataSource
import co.develhope.meteoapp.databinding.FragmentHomepageBinding
import co.develhope.meteoapp.ui.adapter.HomePageAdapter
import co.develhope.meteoapp.ui.adapter.HomepageAction
import co.develhope.meteoapp.ui.model.HomePageViewModel
import co.develhope.meteoapp.ui.utils.createListToShowHome

class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomepageBinding
    private lateinit var viewModel : HomePageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomepageBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[HomePageViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.RVhome.layoutManager = LinearLayoutManager(view.context)
    }

    override fun onStart() {
        super.onStart()
        if (DataSource.getSelectedPlace() == null) {
            findNavController().navigate(R.id.searchFragment)
        } else {
            viewModel.getHomeCoroutine()
        }

        viewModel.homepageResult.observe(viewLifecycleOwner){ it ->
            val adapterCard =
                HomePageAdapter(createListToShowHome(it)) {
                    when (it) {
                        HomepageAction.CardClick -> findNavController().navigate(R.id.action_homePageFragment_to_specificDayFragment)
                    }
                }
            binding.RVhome.adapter = adapterCard

        }

    }

}