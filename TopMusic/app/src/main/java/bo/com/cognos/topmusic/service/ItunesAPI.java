package bo.com.cognos.topmusic.service;

import java.util.List;

import bo.com.cognos.topmusic.domain.Resultado;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class ItunesAPI {

    private static final String url = "https://itunes.apple.com/";

    public static ItunesClient itunesClient = null;

    public static ItunesClient getClient() {
        if (itunesClient == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            itunesClient = retrofit.create(ItunesClient.class);
        }

        return itunesClient;
    }

    public interface ItunesClient {
        @GET("/search")
        Call<Resultado> getCanciones(@Query("term") String artista);
    }

}
