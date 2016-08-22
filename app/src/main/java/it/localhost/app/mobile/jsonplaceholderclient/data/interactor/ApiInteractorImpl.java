package it.localhost.app.mobile.jsonplaceholderclient.data.interactor;

import android.content.res.Resources;

import java.util.Arrays;

import it.localhost.app.mobile.jsonplaceholderclient.R;

/**
 *
 */
public class ApiInteractorImpl implements ApiInteractor {

    private Resources mResources; // TODO sostituire con Retrofit/DataManager/Service
    private ApiInteractorListener mListener;

    public ApiInteractorImpl(Resources resources) {
        mResources = resources;
    }

    @Override
    public void getApi(ApiInteractorListener listener) {
        mListener = listener;
        if (mResources != null) {
            mListener.onDataSuccess(Arrays.asList(mResources.getStringArray(R.array.api_items)));
        } else {
            mListener.onDataError(new Exception("Resources NULL!"));
        }
    }


}
