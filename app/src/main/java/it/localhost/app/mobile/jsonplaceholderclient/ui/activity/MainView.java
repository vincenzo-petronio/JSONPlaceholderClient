package it.localhost.app.mobile.jsonplaceholderclient.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import java.util.List;

/**
 * Interfaccia tra Activity e Presenter.<br />
 * Contiene i metodi che la MainActivity deve implementare per dialogare con gli elementi della UI
 */
public interface MainView {

    void setItems(List<String> items);

    void showMessage(String message);

    void showProgress(boolean show);

    void launchNextActivity(Activity activity, Bundle bundle);
}
