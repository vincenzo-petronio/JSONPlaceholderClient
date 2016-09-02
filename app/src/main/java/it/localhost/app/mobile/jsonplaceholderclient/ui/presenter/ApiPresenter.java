package it.localhost.app.mobile.jsonplaceholderclient.ui.presenter;

import android.os.Bundle;

/**
 *
 */
public interface ApiPresenter {

    void requestItems(String arg);

    void onSelectedItem(Bundle bundle);
}
