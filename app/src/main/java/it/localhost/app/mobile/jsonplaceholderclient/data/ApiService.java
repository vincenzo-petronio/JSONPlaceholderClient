package it.localhost.app.mobile.jsonplaceholderclient.data;

import java.util.List;

import it.localhost.app.mobile.jsonplaceholderclient.data.model.Post;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 *
 */
public interface ApiService {

    @GET("/posts")
    Call<List<Post>> getPosts();
}
