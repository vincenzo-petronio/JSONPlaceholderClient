package it.localhost.app.mobile.jsonplaceholderclient.ui.presenter;

/**
 * Interfaccia tra Interactor e Presenter.<br />
 * Consente di accedere ai dati forniti dall' interactor e aggiornare la View.
 */
public interface MainPresenter {

    void requestItems();

    void onSelectedItem(String s);
}
