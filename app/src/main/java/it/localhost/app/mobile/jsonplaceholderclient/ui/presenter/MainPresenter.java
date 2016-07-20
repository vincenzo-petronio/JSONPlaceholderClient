package it.localhost.app.mobile.jsonplaceholderclient.ui.presenter;

/**
 * Consente di accedere ai dati forniti dall' interactor e aggiorna la View.
 */
public interface MainPresenter {

    void requestItems();

    void onSelectedItem(String s);
}
