package it.localhost.app.mobile.jsonplaceholderclient.data.interactor;

import javax.inject.Inject;

import it.localhost.app.mobile.jsonplaceholderclient.data.ApiService;
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
    public void getApi(Subscriber subscriber, String api) {
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
        mSubscription = mApiService.getComments()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mSubscriber);
    }
}
