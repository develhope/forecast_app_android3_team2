package co.develhope.meteoapp.ui.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.ApplicationMeteo
import co.develhope.meteoapp.data.domainmodel.HourlyForecast
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.network.NetworkProvider
import kotlinx.coroutines.launch
import org.threeten.bp.OffsetDateTime


sealed class TodayResult() {
    data class Success(val list: List<HourlyForecast>, val place: Place, val date: OffsetDateTime) :
        TodayResult()

    data class Error(val e: Exception) : TodayResult()
    object GenericError : TodayResult()
}

class TodayViewModel : ViewModel() {
    private var _todayResult = MutableLiveData<TodayResult>()
    val todayResult: LiveData<TodayResult> get() = _todayResult

    fun getTodayHourlyForecast() {
        viewModelScope.launch {
            try {

                val place = ApplicationMeteo.preferences?.getPreferencePlace()
                val date = OffsetDateTime.now()
                if (place != null && date != null) {
                    val todayHourlyForecast = NetworkProvider().getDailySummary(
                        place.lat,
                        place.log,
                        date,
                        date
                    )
                    _todayResult.value = TodayResult.Success(todayHourlyForecast, place, date)

                } else {
                    _todayResult.value = TodayResult.GenericError
                }


            } catch (e: Exception) {
                _todayResult.value = TodayResult.Error(e)
                e.printStackTrace()
            }
        }
    }
}