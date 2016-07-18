package it.localhost.app.mobile.jsonplaceholderclient.ui.presenter;

import android.content.res.Resources;

import java.util.Arrays;

import it.localhost.app.mobile.jsonplaceholderclient.R;
import it.localhost.app.mobile.jsonplaceholderclient.ui.activity.MainView;

/**
 *
 */
public class MainPresenter {

    private MainView mMainView;
    private Resources mResources;

    /**
     * @param mainView  MainView
     * @param resources Resources
     */
    public MainPresenter(MainView mainView, Resources resources) {
        this.mMainView = mainView;
        this.mResources = resources;
    }

    /**
     * Recupera i dati e li invia alla View.
     */
    public void loadData() {
        mMainView.setItems(Arrays.asList(mResources.getStringArray(R.array.main_menu)));
    }
}
