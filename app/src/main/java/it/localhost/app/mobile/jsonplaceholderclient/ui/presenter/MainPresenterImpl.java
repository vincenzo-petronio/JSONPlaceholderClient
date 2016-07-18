package it.localhost.app.mobile.jsonplaceholderclient.ui.presenter;

import android.content.res.Resources;
import android.os.CountDownTimer;

import java.util.Arrays;

import it.localhost.app.mobile.jsonplaceholderclient.R;
import it.localhost.app.mobile.jsonplaceholderclient.ui.activity.MainView;

/**
 *
 */
public class MainPresenterImpl implements MainPresenter {

    private MainView mMainView;
    private Resources mResources;

    /**
     * @param mainView  MainView
     * @param resources Resources
     */
    public MainPresenterImpl(MainView mainView, Resources resources) {
        this.mMainView = mainView;
        this.mResources = resources;
    }

    /**
     * Recupera i dati e li invia alla View.
     */
    @Override
    public void requestItems() {
        // fake latency
        new CountDownTimer(2000, 1000) {

            @Override
            public void onTick(long l) {
                // nothing
            }

            @Override
            public void onFinish() {
                mMainView.setItems(Arrays.asList(mResources.getStringArray(R.array.main_menu)));
                mMainView.showProgress(false);
            }
        }.start();
    }
}
