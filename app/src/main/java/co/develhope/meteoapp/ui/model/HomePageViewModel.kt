package co.develhope.meteoapp.ui.model

import androidx.lifecycle.*
import co.develhope.meteoapp.data.DataSource
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
                val place = DataSource.getSelectedPlace()
                val date = DataSource.getDate()

                if (place != null && date != null){
                    val palermo: List<WeatherSummary> = NetworkProvider().getWeekSummary(
                        place.lat,
                        place.log,
                        date,
                        date
                    )
                    _homepageResult.value = HomePageResult.Success(palermo,place, date)
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