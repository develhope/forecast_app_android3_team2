package co.develhope.meteoapp

import android.content.Context
import android.util.Log
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.ui.adapter.SearchItem
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.threeten.bp.OffsetDateTime

class Prefs(context: Context) {
   val preferencesPlace = context.getSharedPreferences("place",Context.MODE_PRIVATE)

   val preferencesRecentSearch = context.getSharedPreferences("recentSearch", Context.MODE_PRIVATE)

   private val gson = GsonBuilder().create()


   fun savePreferencePlace(place : Place){
      val placeString : String = Gson().toJson(place)
      preferencesPlace.edit().putString("place",placeString).apply()
   }

   fun getPreferencePlace(): Place? {
      val jsonPlace= preferencesPlace.getString("place", null)
      val itemType = object : TypeToken<Place>() {}.type
      val place = gson.fromJson<Place>(jsonPlace,itemType)
      return  jsonPlace?.let { place }
   }




   fun saveRecentSearches(place : List<Place>){
      val recentSearchString : String =Gson().toJson(place)
      preferencesRecentSearch.edit().putString("recentSearch",recentSearchString).apply()

   }
   fun getRecentSearch(): List<Place>?{
      val jsonRecentSearch = preferencesRecentSearch.getString("recentSearch", null)
      val itemType = object : TypeToken<List<Place>>() {}.type
      val recentSearch = gson.fromJson<List<Place>>(jsonRecentSearch,itemType)
      return jsonRecentSearch.let { recentSearch }
   }


}