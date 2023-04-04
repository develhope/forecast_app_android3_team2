package co.develhope.meteoapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.ApplicationMeteo
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.databinding.FragmentHomepageBinding
import co.develhope.meteoapp.ui.adapter.HomePageAdapter
import co.develhope.meteoapp.ui.adapter.HomepageAction
import co.develhope.meteoapp.ui.adapter.SearchAction
import co.develhope.meteoapp.ui.model.HomePageResult
import co.develhope.meteoapp.ui.model.HomePageViewModel
import co.develhope.meteoapp.ui.utils.createListToShowHome
import org.threeten.bp.OffsetDateTime

class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomepageBinding
    private lateinit var viewModel: HomePageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomepageBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[HomePageViewModel::class.java]
        gestioneplacenullo()



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.RVhome.layoutManager = LinearLayoutManager(view.context)
    }

    override fun onStart() {
        super.onStart()


    }

    private fun gestioneplacenullo() {
        if (ApplicationMeteo.preferences?.getPreferencePlace() == null) {
            findNavController().navigate(R.id.searchFragment)
        } else {
            ApplicationMeteo.preferences?.savePreferenceDate(OffsetDateTime.now())
            setupObserverHome()
            viewModel.getHomeCoroutine()
        }
    }

    private fun setupObserverHome() {
        viewModel.homepageResult.observe(viewLifecycleOwner) {
            when (it) {
                is HomePageResult.Error -> Toast.makeText(requireContext(),"prosciutto e provola",Toast.LENGTH_SHORT).show()
                is HomePageResult.GenericError -> Toast.makeText(
                    requireContext(),
                    "loading",
                    Toast.LENGTH_SHORT
                ).show()

                is HomePageResult.Success -> {
                    val adapterCard =
                        HomePageAdapter(createListToShowHome(it.list, it.place, it.date)) { page ->
                            when (page) {
                                is HomepageAction.CardClick -> {
                                    ApplicationMeteo.preferences?.savePreferenceDate(it.date)
                                    Log.d("dataSalvata","${it.date}")
                                    findNavController().navigate(R.id.action_homePageFragment_to_tomorrowFragment)
                                }

                            }
                        }
                    binding.RVhome.adapter = adapterCard

                }
            }
        }
    }
}