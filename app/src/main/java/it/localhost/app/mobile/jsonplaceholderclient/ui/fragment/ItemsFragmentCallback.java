package it.localhost.app.mobile.jsonplaceholderclient.ui.fragment;

import android.os.Bundle;

/**
 * Callback tra Fragment e Activity
 */
public interface ItemsFragmentCallback {
    void loadDetailsFragment(Bundle bundle);

    void showProgress(boolean show);
}
