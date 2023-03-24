package co.develhope.meteoapp.ui.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.data.DataSource
import co.develhope.meteoapp.data.DataSource.getDate
import co.develhope.meteoapp.data.domainmodel.HourlyForecast
import co.develhope.meteoapp.network.NetworkProvider
import kotlinx.coroutines.launch


sealed class SpecificDayResult(){
    data class Success(val list: List<HourlyForecast>): SpecificDayResult()
    data class Error(val e : Exception):SpecificDayResult()
}

class SpecificDayViewModel: ViewModel()  {
    private var _specificDayResult = MutableLiveData<SpecificDayResult>()
    val specificDayResult : LiveData<SpecificDayResult> get() = _specificDayResult

    fun getHourlyForecast() {
        viewModelScope.launch {
            try {
                val hourlyForecast = NetworkProvider().getDailySummary(
                    DataSource.getSelectedPlace()?.lat ?: 38.116667,
                    DataSource.getSelectedPlace()?.log ?: 13.366667,
                    getDate(),
                    getDate()
                )
                _specificDayResult.value = SpecificDayResult.Success(hourlyForecast)

            } catch (e: Exception) {
                _specificDayResult.value = SpecificDayResult.Error(e)
                e.printStackTrace()
            }
        }
    }
}