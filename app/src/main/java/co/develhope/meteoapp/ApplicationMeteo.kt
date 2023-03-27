package co.develhope.meteoapp

import android.app.Application


class ApplicationMeteo : Application() {

    companion object {
        var preferences: Prefs? = null
        lateinit var instance: ApplicationMeteo
    }


    override fun onCreate() {
        super.onCreate()
        preferences = Prefs(applicationContext)
        instance = this
    }


}
