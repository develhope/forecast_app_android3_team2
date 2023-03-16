package co.develhope.meteoapp.ui.model

import android.util.Log
import androidx.lifecycle.*
import co.develhope.meteoapp.data.DataSource
import co.develhope.meteoapp.data.DataSource.getDate
import co.develhope.meteoapp.data.domainmodel.HourlyForecast
import co.develhope.meteoapp.network.NetworkProvider
import co.develhope.meteoapp.ui.adapter.SpecificDayAdapter
import co.develhope.meteoapp.ui.adapter.SpecificDayModel
import kotlinx.coroutines.launch

class SpecificDayViewModel: ViewModel()  {
    private var _specificDayResult = MutableLiveData<List<HourlyForecast>>()
    val specificDayResult : LiveData<List<HourlyForecast>> get() = _specificDayResult

    fun getHourlyForecast() {
        viewModelScope.launch {
            try {
                val hourlyForecast = NetworkProvider().getDailySummary(
                    DataSource.getSelectedPlace()?.lat ?: 38.116667,
                    DataSource.getSelectedPlace()?.log ?: 13.366667,
                    getDate(),
                    getDate()
                )
                _specificDayResult.value = hourlyForecast

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}