package co.develhope.meteoapp.ui.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.network.NetworkProvider
import kotlinx.coroutines.launch

sealed class SearchResult(){
    data class Success(val list: List<Place>): SearchResult()
    data class Error( val e : Exception): SearchResult()
    object GenericError: SearchResult()
}
class SearchViewModel : ViewModel() {

    private var _searchResult = MutableLiveData<SearchResult>()
    val searchResult : LiveData<SearchResult> get() = _searchResult

     fun searchPlace(searchResult : String, language :String) {

        viewModelScope.launch {
            try {

                val places = NetworkProvider().getPlace(
                    searchResult,
                    language = language
                )
                _searchResult.value = SearchResult.Success(places)


            } catch (e: Exception) {
                _searchResult.value = SearchResult.Error(e)
                e.printStackTrace()

            }
        }
    }
}