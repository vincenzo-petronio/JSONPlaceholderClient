package it.localhost.app.mobile.jsonplaceholderclient.data.interactor;

import java.util.List;

import javax.inject.Inject;

import it.localhost.app.mobile.jsonplaceholderclient.data.ApiService;
import it.localhost.app.mobile.jsonplaceholderclient.data.model.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 */
public class ApiInteractorImpl implements ApiInteractor {

    @Inject
    ApiService mApiService;
    private ApiInteractorListener mListener;

    /**
     * Costruttore
     *
     * @param resources ApiService
     */
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
                    mListener.onDataSuccess(response.body());
                }

                @Override
                public void onFailure(Call<List<Post>> call, Throwable t) {
                    mListener.onDataError(new Exception("Resources NULL!"));
                }
            });
        }
    }


}
