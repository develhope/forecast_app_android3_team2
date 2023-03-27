package co.develhope.meteoapp.ui.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.ApplicationMeteo
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.data.domainmodel.WeatherSummary
import co.develhope.meteoapp.network.NetworkProvider
import kotlinx.coroutines.launch
import org.threeten.bp.OffsetDateTime

sealed class HomePageResult(){
    data class Success (val list: List<WeatherSummary>,val place: Place, val date: OffsetDateTime):HomePageResult()

    data class Error( val e :Exception):HomePageResult()

    object GenericError :HomePageResult()
}
class HomePageViewModel :ViewModel() {

    private var _homepageResult = MutableLiveData<HomePageResult>()
    val homepageResult : LiveData<HomePageResult> get() = _homepageResult

     fun getHomeCoroutine() {

        viewModelScope.launch {
            try {
                val place = ApplicationMeteo.preferences?.getPreferencePlace()
                val date = ApplicationMeteo.preferences?.getPreferenceDate()

                if (place != null && date != null){
                    val palermo: List<WeatherSummary> = NetworkProvider().getWeekSummary(
                        place.lat,
                        place.log,
                        date,
                        date

                    )
                    Log.d("palermo", "$palermo")
                    _homepageResult.value = HomePageResult.Success(palermo,place,date)
                } else{
                    _homepageResult.value = HomePageResult.GenericError
                }


            } catch (e: Exception) {
                _homepageResult.value = HomePageResult.Error(e)
                e.printStackTrace()
            }
        }
    }
}