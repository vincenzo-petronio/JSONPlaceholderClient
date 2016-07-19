package it.localhost.app.mobile.jsonplaceholderclient.data;

import android.content.res.Resources;

import java.util.Arrays;
import java.util.List;

import it.localhost.app.mobile.jsonplaceholderclient.R;

/**
 *
 */
public class MainInteractorImpl implements MainInteractor {

    private Resources mResources;
    private MainInteractorListener mListener;

    //    /**
//     * @param resources Resources
//     * @param listener  MainInteractorListener
//     */
//    public MainInteractorImpl(Resources resources, MainInteractorListener listener) {
//        mResources = resources;
//        mListener = listener;
//    }

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

    public interface MainInteractorListener {
        void onDataSuccess(List<String> items);

        void onDataError(Exception e);
    }
}