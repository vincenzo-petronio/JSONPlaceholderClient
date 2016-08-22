package it.localhost.app.mobile.jsonplaceholderclient.ui.fragment;

/**
 * Callback tra Fragment e Activity
 */
public interface ItemsFragmentCallback {
    void loadDetailsFragment();

    void showProgress(boolean show);
}
