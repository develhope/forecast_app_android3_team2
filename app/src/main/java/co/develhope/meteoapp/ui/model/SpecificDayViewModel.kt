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


sealed class SpecificDayResult(){
    data class Success(val list: List<HourlyForecast>,val place: Place, val  date: OffsetDateTime): SpecificDayResult()
    data class Error(val e : Exception):SpecificDayResult()
    object GenericError :SpecificDayResult()
}

class SpecificDayViewModel: ViewModel()  {
    private var _specificDayResult = MutableLiveData<SpecificDayResult>()
    val specificDayResult : LiveData<SpecificDayResult> get() = _specificDayResult

    fun getHourlyForecast() {
        viewModelScope.launch {
            try {

                val place = ApplicationMeteo.preferences?.getPreferencePlace()
                val date = ApplicationMeteo.preferences?.getPreferenceDate()
                if (place != null && date != null){
                    val hourlyForecast = NetworkProvider().getDailySummary(
                        place.lat,
                        place.log,
                        date,
                        date
                    )
                    _specificDayResult.value = SpecificDayResult.Success(hourlyForecast,place,date)

                }else{
                    _specificDayResult.value = SpecificDayResult.GenericError
                }


            } catch (e: Exception) {
                _specificDayResult.value = SpecificDayResult.Error(e)
                e.printStackTrace()
            }
        }
    }
}