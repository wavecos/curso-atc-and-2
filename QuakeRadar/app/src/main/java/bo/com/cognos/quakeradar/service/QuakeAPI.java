package bo.com.cognos.quakeradar.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import bo.com.cognos.quakeradar.domain.Quake;
import bo.com.cognos.quakeradar.domain.QuakeDeserializer;
import bo.com.cognos.quakeradar.domain.Result;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class QuakeAPI {

    private static final String url = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/";

    public static QuakeService quakeService = null;

    public static QuakeService getQuakeService() {
        if (quakeService == null) {

            Gson gson = new GsonBuilder().registerTypeAdapter(Quake.class, new QuakeDeserializer()).create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            quakeService = retrofit.create(QuakeService.class);

        }
        return quakeService;

    }

    public interface QuakeService {
        @GET("all_hour.geojson")
        Call<Result> getAllQuakesLastHour();

        @GET("all_day.geojson")
        Call<Result> getAllQuakesLastDay();

        @GET("all_week.geojson")
        Call<Result> getAllQuakesLastWeek();

        @GET("all_month.geojson")
        Call<Result> getAllQuakesLastMonth();

    }

}
