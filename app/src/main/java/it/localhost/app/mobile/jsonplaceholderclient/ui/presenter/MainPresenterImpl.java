package it.localhost.app.mobile.jsonplaceholderclient.ui.presenter;

import android.app.Activity;
import android.os.CountDownTimer;

import java.util.List;

import it.localhost.app.mobile.jsonplaceholderclient.data.interactor.MainInteractor;
import it.localhost.app.mobile.jsonplaceholderclient.data.interactor.MainInteractorListener;
import it.localhost.app.mobile.jsonplaceholderclient.ui.activity.MainView;

/**
 *
 */
public class MainPresenterImpl implements MainPresenter, MainInteractorListener {

    private MainView mMainView;
    private MainInteractor mMainInteractor;

    public MainPresenterImpl(MainView mainView, MainInteractor interactor) {
        mMainView = mainView;
        mMainInteractor = interactor;
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
                mMainInteractor.getAvailableApi(MainPresenterImpl.this);
            }
        }.start();
    }

    @Override
    public void onSelectedItem(String s) {
        switch (s) {
            case "posts":
                break;
            case "comments":
                break;
            case "albums":
                break;
            case "photos":
                break;
            case "todos":
                break;
            case "users":
                break;
            default:
                break;
        }

        mMainView.launchNextActivity(new Activity());
    }

    @Override
    public void onDataSuccess(List<String> items) {
        mMainView.setItems(items);
        mMainView.showProgress(false);
    }

    @Override
    public void onDataError(Exception e) {
        mMainView.showMessage(e.getMessage());
        mMainView.showProgress(false);
    }
}
