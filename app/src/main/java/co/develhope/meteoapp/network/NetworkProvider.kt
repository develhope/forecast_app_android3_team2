package co.develhope.meteoapp.network

import co.develhope.meteoapp.data.domainmodel.HourlyForecast
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.data.domainmodel.WeatherSummary
import co.develhope.meteoapp.network.service.GeocodingService
import co.develhope.meteoapp.network.service.WeatherService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.threeten.bp.OffsetDateTime
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkProvider {

    private val BASE_URL = "https://api.open-meteo.com/v1/"
    private val BASE_URL_GEOCODING = "https://geocoding-api.open-meteo.com/v1/"


    private val retrofitWeather = provideWeatherRetrofit(
        client = provideOkHttpClient(provideHttpLoggingInterceptor()),
        gson = provideGson()
    )
    private val retrofitGeocoding = provideGeocodingRetrofit(
        client = provideOkHttpClient(provideHttpLoggingInterceptor()),
        gson = provideGson()
    )


    private fun provideWeatherRetrofit(
        client: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }


    private fun provideGeocodingRetrofit(
        client: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_GEOCODING)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    private fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {

        return OkHttpClient.Builder()
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()
    }


    private fun provideWeatherService(): WeatherService {
        return retrofitWeather.create(WeatherService::class.java)
    }

    private fun provideGeocodingService(): GeocodingService {
        return retrofitGeocoding.create(GeocodingService::class.java)
    }

    private fun provideGson(): Gson = GsonBuilder()
        .registerTypeAdapter(OffsetDateTime::class.java, OffsetDateTimeTypeAdapter())
        .create()

    suspend fun getWeekSummary(
        latitude: Double,
        longitude: Double,
        start_Date: OffsetDateTime,
        end_Date: OffsetDateTime,
    ): List<WeatherSummary> {
        return provideWeatherService().getWeeklySummary(
            latitude = latitude,
            longitude = longitude,
        ).body()?.daily?.toDomain() ?: emptyList()
    }

    suspend fun getDailySummary(
        latitude: Double,
        longitude: Double,
        start_Date: OffsetDateTime,
        end_Date: OffsetDateTime
    ): List<HourlyForecast> {
        return provideWeatherService().getDaySummary(
            latitude = latitude,
            longitude = longitude,
            startDate = start_Date.toLocalDate(),
            endDate = end_Date.toLocalDate()
        ).body()?.hourly?.toDomain() ?: emptyList()
    }

    suspend fun getPlace(place: String): List<Place> {
        return provideGeocodingService().getCityInfo(
            name = place
        ).toDomain()
    }
}
