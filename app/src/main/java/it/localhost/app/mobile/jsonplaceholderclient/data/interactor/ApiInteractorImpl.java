package it.localhost.app.mobile.jsonplaceholderclient.data.interactor;

import java.util.List;

import javax.inject.Inject;

import it.localhost.app.mobile.jsonplaceholderclient.data.ApiService;
import it.localhost.app.mobile.jsonplaceholderclient.data.model.Comment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 *
 */
public class ApiInteractorImpl implements ApiInteractor {

    @Inject
    ApiService mApiService;
    private ApiInteractorListener mListener;
    private Subscription mSubscription = Subscriptions.empty();
    private Subscriber mSubscriber;

    /**
     * Costruttore
     *
     * @param resources ApiService
     */
    public ApiInteractorImpl(ApiService resources) {
        mApiService = resources;
    }

    @Override
    public void getApi(ApiInteractorListener listener, String api, Subscriber subscriber) {
        mListener = listener;
        mSubscriber = subscriber;

        // GUARD-CLAUSE
        if (mApiService == null) {
            return;
            // TODO thrown exception
        }

        switch (api) {
            case "posts":
                getPosts();
                break;
            case "comments":
                getComments();
                break;
            default:
                break;
        }

    }

    @Override
    public void unsubscribe() {
        if (!mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }

    private void getPosts() {
        mSubscription = mApiService.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mSubscriber);
    }

    private void getComments() {
        mApiService.getComments().enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                mListener.onDataSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                mListener.onDataError(new Exception("Resources NULL!"));
            }
        });
    }
}
