package it.localhost.app.mobile.jsonplaceholderclient.ui.presenter;

import android.content.res.Resources;

import java.util.Arrays;

import it.localhost.app.mobile.jsonplaceholderclient.R;
import it.localhost.app.mobile.jsonplaceholderclient.ui.activity.MainActivity;

/**
 *
 */
public class MainPresenter {

    private MainActivity mMainActivity;
    private Resources mResources;

    /**
     * @param mainActivity MainActivity
     */
    public MainPresenter(MainActivity mainActivity, Resources resources) {
        this.mMainActivity = mainActivity;
        this.mResources = resources;
    }

    /**
     * Recupera i dati e li invia alla View.
     */
    public void loadData() {
        mMainActivity.setData(Arrays.asList(mResources.getStringArray(R.array.main_menu)));
    }
}
