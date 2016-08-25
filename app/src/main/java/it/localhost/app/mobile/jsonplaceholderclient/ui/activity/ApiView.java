package it.localhost.app.mobile.jsonplaceholderclient.ui.activity;

import java.util.List;

/**
 * Interfaccia tra Fragment e Presenter.<br />
 * Contiene i metodi che ItemsFragment deve implementare per dialogare con gli elementi della UI
 */
public interface ApiView {

    void setItems(List<?> items);

    void showMessage(String message);

    void showProgress(boolean show);

    void launchNextView();
}