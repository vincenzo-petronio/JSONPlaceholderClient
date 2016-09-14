package it.localhost.app.mobile.jsonplaceholderclient.data.interactor;

import rx.Subscriber;

/**
 *
 */
public interface ApiInteractor {

    void getApi(ApiInteractorListener listener, String api, Subscriber subscriber);

    void unsubscribe();
}
