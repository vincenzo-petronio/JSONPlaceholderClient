package it.localhost.app.mobile.jsonplaceholderclient.data.interactor;

import rx.Subscriber;

/**
 *
 */
public interface ApiInteractor {

    void getApi(Subscriber subscriber, String api);

    void unsubscribe();
}
