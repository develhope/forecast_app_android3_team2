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
import co.develhope.meteoapp.data.domainmodel.CardSpecificDay
import co.develhope.meteoapp.data.domainmodel.DaySpecificDay
import co.develhope.meteoapp.data.domainmodel.HourlySpecificDay
import co.develhope.meteoapp.data.domainmodel.Place
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

        val listSpecificDay = createListToShow(getSpecificDay())

        binding.itemSpecificday.layoutManager = LinearLayoutManager(view.context)

    }

    override fun onStart() {
        super.onStart()

        lifecycleScope.launch {
            try {


                val palermocard = NetworkProvider().getDailySummary(
                    38.116667,
                    13.366667,
                    OffsetDateTime.now().toLocalDateTime().toString(),
                    OffsetDateTime.now().plusDays(1).toString()
                )
                NetworkProvider().getHourly(
                    38.116667,
                    13.366667,
                    OffsetDateTime.now().toLocalDate().toString(),
                    OffsetDateTime.now().toLocalDate().toString()
                )
                Log.d("prova card specific day", "${palermocard}")
                //Log.d("prova hourly specific day", "${palermohourly}")
                val adapter = SpecificDayAdapter(getSpecificDay(converteItem(palermocard)))
                binding.itemSpecificday.adapter = adapter

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

    private fun converteItem(item : List<DaySpecificDay>):List<SpecificDayModel> {
        val hourlySpecificDay = item.mapIndexed { index, DaySpecificDay ->
            DaySpecificDay(
                place = Place(
                    city = "Palermo",
                    region = "Sicilia",
                    lat = 38.12136,
                    log = 13.35844,
                    date =OffsetDateTime.now()
                ), cardSpecificDay = CardSpecificDay(
                    percepita = DaySpecificDay.cardSpecificDay.percepita,
                    umidita = DaySpecificDay.cardSpecificDay.umidita,
                    copertura = DaySpecificDay.cardSpecificDay.copertura,
                    uv = DaySpecificDay.cardSpecificDay.uv,
                    vento = DaySpecificDay.cardSpecificDay.vento,
                    pioggia = DaySpecificDay.cardSpecificDay.pioggia
                ), hourlySpecificDay = HourlySpecificDay(
                    time =DaySpecificDay.hourlySpecificDay.time,
                    weatherType =DaySpecificDay.hourlySpecificDay.weatherType,
                    temp = DaySpecificDay.hourlySpecificDay.temp,
                    umidity = DaySpecificDay.hourlySpecificDay.umidity
                )

            )
        }
        }

}



