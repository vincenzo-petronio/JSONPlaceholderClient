package it.localhost.app.mobile.jsonplaceholderclient.ui.activity;

import java.util.List;

import it.localhost.app.mobile.jsonplaceholderclient.data.model.Post;

/**
 * Interfaccia tra Fragment e Presenter.<br />
 * Contiene i metodi che ItemsFragment deve implementare per dialogare con gli elementi della UI
 */
public interface ApiView {

    void setItems(List<String> items);

    void showMessage(String message);

    void showProgress(boolean show);

    void launchNextView();
}
