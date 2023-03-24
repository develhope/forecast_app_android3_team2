package co.develhope.meteoapp.ui.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.network.NetworkProvider
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    private var _searchResult = MutableLiveData<List<Place>>()
    val searchResult : LiveData<List<Place>> get() = _searchResult

     fun searchPlace(searchResult : String, language :String) {

        viewModelScope.launch {
            try {
                val places = NetworkProvider().getPlace(
                    searchResult,
                    language = language
                )
                _searchResult.value = places


            } catch (e: Exception) {
                e.printStackTrace()

            }

        }
    }
}