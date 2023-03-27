package co.develhope.meteoapp

import android.content.Context
import co.develhope.meteoapp.data.domainmodel.Place
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.threeten.bp.OffsetDateTime

class Prefs(context: Context) {
   val preferencesPlace = context.getSharedPreferences("place",Context.MODE_PRIVATE)

   val preferencesDate = context.getSharedPreferences("date", Context.MODE_PRIVATE)

   private val gson = GsonBuilder().create()


   fun savePreferencePlace(place : Place){
      val placeString : String = Gson().toJson(place)
      preferencesPlace.edit().putString("place",placeString).apply()
   }

   fun getPreferencePlace(): Place {
      val jsonPlace= preferencesPlace.getString("place",null)
      val itemType = object : TypeToken<Place>() {}.type
      val place = gson.fromJson<Place>(jsonPlace,itemType)
      return  place
   }

   fun savePreferenceDate(date: OffsetDateTime){
      val dateString : String = Gson().toJson(date)
      preferencesDate.edit().putString("date",dateString).apply()
   }

   fun getPreferenceDate(): OffsetDateTime{
      val jsonDate = preferencesDate.getString("date",OffsetDateTime.now().toString())
      val itemType = object : TypeToken<OffsetDateTime>() {}.type
      val date = gson.fromJson<OffsetDateTime>(jsonDate,itemType)
      return date
   }
}