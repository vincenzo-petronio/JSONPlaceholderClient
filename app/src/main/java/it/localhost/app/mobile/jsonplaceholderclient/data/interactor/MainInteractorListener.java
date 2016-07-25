package it.localhost.app.mobile.jsonplaceholderclient.data.interactor;

import java.util.List;

/**
 * Callback tra Interactor e Presenter
 */
public interface MainInteractorListener {
    void onDataSuccess(List<String> items);

    void onDataError(Exception e);
}
