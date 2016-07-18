package it.localhost.app.mobile.jsonplaceholderclient.ui.activity;

import java.util.List;

/**
 *
 */
public interface MainView {

    void setItems(List<String> items);

    void showMessage(String message);

    void showProgress(boolean show);
}
