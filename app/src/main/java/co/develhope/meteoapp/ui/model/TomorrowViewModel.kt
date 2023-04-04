package co.develhope.meteoapp.ui.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.ApplicationMeteo
import co.develhope.meteoapp.data.DataSource
import co.develhope.meteoapp.data.domainmodel.HourlyForecast
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.network.NetworkProvider
import kotlinx.coroutines.launch
import org.threeten.bp.OffsetDateTime

sealed class TomorrowResult() {

    data class Success(val list: List<HourlyForecast>, val place: Place, val date: OffsetDateTime) :
        TomorrowResult()

    data class Error(val e: Exception) : TomorrowResult()

    object GenericError : TomorrowResult()
}

class TomorrowViewModel : ViewModel() {
    private var _tomorrowResult = MutableLiveData<TomorrowResult>()
    val tomorrowResult: LiveData<TomorrowResult> get() = _tomorrowResult

    fun getTomorrowHourlyForecast() {
        viewModelScope.launch {
            try {

                val place = ApplicationMeteo.preferences?.getPreferencePlace()
                val date = OffsetDateTime.now().plusDays(1)
                if (place != null && date != null) {
                    val tomorrowHourlyForecast = NetworkProvider().getDailySummary(
                        place.lat,
                        place.log,
                        date,
                        date
                    )
                    _tomorrowResult.value = TomorrowResult.Success(tomorrowHourlyForecast,place, date)

                } else {
                    _tomorrowResult.value = TomorrowResult.GenericError
                }


            } catch (e: Exception) {
                _tomorrowResult.value = TomorrowResult.Error(e)
                e.printStackTrace()
            }
        }
    }
}