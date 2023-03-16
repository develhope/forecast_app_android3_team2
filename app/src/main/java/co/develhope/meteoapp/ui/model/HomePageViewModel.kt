package co.develhope.meteoapp.ui.model

import android.util.Log
import androidx.lifecycle.*
import co.develhope.meteoapp.data.DataSource
import co.develhope.meteoapp.data.DataSource.getDate
import co.develhope.meteoapp.data.domainmodel.DayForecast
import co.develhope.meteoapp.data.domainmodel.WeatherSummary
import co.develhope.meteoapp.network.NetworkProvider
import co.develhope.meteoapp.ui.adapter.HomePageItem

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
                    getDate(),
                    getDate()
                )
                _homepageResult.value = palermo



            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("prova", "errore")
            }
        }
    }


}