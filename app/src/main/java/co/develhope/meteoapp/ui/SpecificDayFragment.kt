package co.develhope.meteoapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.data.DataSource.getSpecificDay
import co.develhope.meteoapp.data.domainmodel.DaySpecificDay
import co.develhope.meteoapp.ui.adapter.SpecificDayAdapter
import co.develhope.meteoapp.ui.adapter.SpecificDayModel

import co.develhope.meteoapp.databinding.FragmentSpecificDayBinding
import co.develhope.meteoapp.network.NetworkProvider
import kotlinx.coroutines.launch
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter


class SpecificDayFragment : Fragment() {

    private var _binding: FragmentSpecificDayBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSpecificDayBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val listSpecificDay= createListToShow(getSpecificDay())
        val adapter = SpecificDayAdapter(listSpecificDay)
        binding.itemSpecificday.adapter = adapter
        binding.itemSpecificday.layoutManager = LinearLayoutManager(view.context)

    }
    override fun onStart() {
        super.onStart()

        lifecycleScope.launch {
            try {
                val palermo = NetworkProvider().getDailySummary(
                    38.116667,
                    13.366667,
                    OffsetDateTime.now().toLocalDate().toString(),
                    OffsetDateTime.now().toLocalDate().toString()
                )
                Log.d("provadaily", "${palermo}")


            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("provadaily", "errore")
                Log.d("provadaily", "${OffsetDateTime.now().toLocalDate().toString()}")

            }
        }
    }

    private fun createListToShow(list: List<DaySpecificDay>): List<SpecificDayModel> {
        val listToReturn = mutableListOf<SpecificDayModel>()

        listToReturn.add(SpecificDayModel.SpecificDayTitle(list.first().place))
        listToReturn.add(SpecificDayModel.SpecificDayHourly(list.first()))
        listToReturn.add(SpecificDayModel.SpecificDayCard(list.first().cardSpecificDay))

        val otherHours: MutableList<SpecificDayModel.SpecificDayHourly> = list.map {
            SpecificDayModel.SpecificDayHourly(it)
        }.toMutableList()
        listToReturn.addAll(otherHours)

        listToReturn.removeAt(3)
        return listToReturn
    }
}



