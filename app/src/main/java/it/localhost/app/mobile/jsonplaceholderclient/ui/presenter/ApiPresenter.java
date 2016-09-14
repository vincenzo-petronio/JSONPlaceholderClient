package it.localhost.app.mobile.jsonplaceholderclient.ui.presenter;

import android.os.Bundle;

/**
 *
 */
public interface ApiPresenter extends BasePresenter {

    void requestItems(String arg);

    void onSelectedItem(Bundle bundle);
}
