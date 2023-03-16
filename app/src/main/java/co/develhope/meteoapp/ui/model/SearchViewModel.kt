package co.develhope.meteoapp.ui.model

import android.util.Log
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

     fun searchPlace(searchResult : String) {

        viewModelScope.launch {
            try {
                val places = NetworkProvider().getPlace(
                    searchResult
                )
                _searchResult.value = places

                Log.d("provaPlace","$places")

            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("prova", "errore")

            }

        }
    }
}