package it.localhost.app.mobile.jsonplaceholderclient.data;

import java.util.List;

import it.localhost.app.mobile.jsonplaceholderclient.data.model.Comment;
import it.localhost.app.mobile.jsonplaceholderclient.data.model.Post;
import retrofit2.http.GET;
import rx.Observable;

/**
 *
 */
public interface ApiService {

    @GET("/posts")
    Observable<List<Post>> getPosts();

    @GET("/comments")
    Observable<List<Comment>> getComments();
}
