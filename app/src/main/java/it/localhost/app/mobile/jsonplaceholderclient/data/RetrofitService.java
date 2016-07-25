package it.localhost.app.mobile.jsonplaceholderclient.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 */
public class RetrofitService {

    public Retrofit buildApiRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
