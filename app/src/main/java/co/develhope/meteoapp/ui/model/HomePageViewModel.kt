package co.develhope.meteoapp.ui.model

import androidx.lifecycle.*
import co.develhope.meteoapp.data.DataSource
import co.develhope.meteoapp.data.domainmodel.WeatherSummary
import co.develhope.meteoapp.network.NetworkProvider

import kotlinx.coroutines.launch

class HomePageViewModel :ViewModel() {

    private var _homepageResult = MutableLiveData<List<WeatherSummary>>()
    val homepageResult : LiveData<List<WeatherSummary>> get() = _homepageResult

     fun getHomeCoroutine() {

        viewModelScope.launch {
            try {
                val palermo: List<WeatherSummary> = NetworkProvider().getWeekSummary(
                    DataSource.getSelectedPlace()?.lat ?: 38.116667,
                    DataSource.getSelectedPlace()?.log ?: 13.366667,
                    DataSource.getDate(),
                    DataSource.getDate()
                )
                _homepageResult.value = palermo

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


}