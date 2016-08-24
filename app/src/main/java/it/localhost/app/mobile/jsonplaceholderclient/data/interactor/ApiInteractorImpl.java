package it.localhost.app.mobile.jsonplaceholderclient.data.interactor;

import android.content.res.Resources;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import it.localhost.app.mobile.jsonplaceholderclient.R;
import it.localhost.app.mobile.jsonplaceholderclient.data.ApiService;
import it.localhost.app.mobile.jsonplaceholderclient.data.RetrofitService;
import it.localhost.app.mobile.jsonplaceholderclient.data.model.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 */
public class ApiInteractorImpl implements ApiInteractor {

    //private Resources mResources; // TODO sostituire con Retrofit/DataManager/Service
    @Inject
    ApiService mApiService;
    private ApiInteractorListener mListener;

//    public ApiInteractorImpl(Resources resources) {
//        mResources = resources;
//    }
//
//    @Override
//    public void getApi(ApiInteractorListener listener) {
//        mListener = listener;
//        if (mResources != null) {
//            mListener.onDataSuccess(Arrays.asList(mResources.getStringArray(R.array.api_items)));
//        } else {
//            mListener.onDataError(new Exception("Resources NULL!"));
//        }
//    }

    public ApiInteractorImpl(ApiService resources) {
        mApiService = resources;
    }

    @Override
    public void getApi(ApiInteractorListener listener) {
        mListener = listener;
        if (mApiService != null) {
            mApiService.getPosts().enqueue(new Callback<List<Post>>() {
                @Override
                public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                    List<String> items = new ArrayList<String>();
                    for(Post p : response.body()){
                        Log.i("ApiInteractorImpl", p.getTitle());
                        items.add(p.getTitle());
                    }

                    mListener.onDataSuccess(items);
                }

                @Override
                public void onFailure(Call<List<Post>> call, Throwable t) {
                    mListener.onDataError(new Exception("Resources NULL!"));
                }
            });
            //mListener.onDataSuccess(Arrays.asList(mApiService.getStringArray(R.array.api_items)));
        } else {
            //mListener.onDataError(new Exception("Resources NULL!"));
        }
    }


}
