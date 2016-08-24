package it.localhost.app.mobile.jsonplaceholderclient.data;

import it.localhost.app.mobile.jsonplaceholderclient.util.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 */
public class RetrofitService {

    public Retrofit buildApiRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Constants.API_URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
