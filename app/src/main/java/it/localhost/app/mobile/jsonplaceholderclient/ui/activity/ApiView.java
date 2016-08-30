package it.localhost.app.mobile.jsonplaceholderclient.ui.activity;

import android.os.Bundle;

import java.util.List;

/**
 * Interfaccia tra Fragment e Presenter.<br />
 * Contiene i metodi che il Fragment deve implementare per dialogare con gli elementi della UI
 */
public interface ApiView {

    void setItems(List<?> items);

    void setItem(Object item);

    void showMessage(String message);

    void showProgress(boolean show);

    void launchNextView(Bundle bundle);
}
