package it.localhost.app.mobile.jsonplaceholderclient.data.interactor;

import android.content.res.Resources;

import java.util.Arrays;

import it.localhost.app.mobile.jsonplaceholderclient.R;

/**
 *
 */
public class MainInteractorImpl implements MainInteractor {
    private Resources mResources;
    private MainInteractorListener mListener;

    public MainInteractorImpl(Resources resources) {
        mResources = resources;
    }

    @Override
    public void getAvailableApi(MainInteractorListener listener) {
        mListener = listener;
        if (mResources != null) {
            mListener.onDataSuccess(Arrays.asList(mResources.getStringArray(R.array.main_menu)));
        } else {
            mListener.onDataError(new Exception("Resources NULL!"));
        }
    }
}
