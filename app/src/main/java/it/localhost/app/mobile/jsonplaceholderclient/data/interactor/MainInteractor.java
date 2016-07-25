package it.localhost.app.mobile.jsonplaceholderclient.data.interactor;

/**
 * Consente di passare i dati tra il Model e il Presenter.
 */
public interface MainInteractor {

    void getAvailableApi(MainInteractorListener listener);
}
