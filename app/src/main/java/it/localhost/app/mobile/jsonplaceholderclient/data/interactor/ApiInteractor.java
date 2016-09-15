package it.localhost.app.mobile.jsonplaceholderclient.data.interactor;

import rx.Subscriber;

/**
 * Consente di passare i dati tra il Model e il Presenter.
 */
public interface ApiInteractor {

    void getApi(Subscriber subscriber, String api);

    void unsubscribe();
}
