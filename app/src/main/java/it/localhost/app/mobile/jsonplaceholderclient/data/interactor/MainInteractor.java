package it.localhost.app.mobile.jsonplaceholderclient.data.interactor;

import rx.Observable;

/**
 * Consente di passare i dati tra il Model e il Presenter.
 */
public interface MainInteractor {

    //    void getAvailableApi(MainInteractorListener listener);
    Observable<String> getAvailableApi();
}
