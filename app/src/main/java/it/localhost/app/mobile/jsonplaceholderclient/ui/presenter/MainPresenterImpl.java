package it.localhost.app.mobile.jsonplaceholderclient.ui.presenter;

import android.os.Bundle;
import android.os.CountDownTimer;

import java.util.List;

import it.localhost.app.mobile.jsonplaceholderclient.data.interactor.MainInteractor;
import it.localhost.app.mobile.jsonplaceholderclient.data.interactor.MainInteractorListener;
import it.localhost.app.mobile.jsonplaceholderclient.ui.activity.ApiActivity;
import it.localhost.app.mobile.jsonplaceholderclient.ui.activity.MainView;
import it.localhost.app.mobile.jsonplaceholderclient.util.Constants;

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
        ApiActivity activity = null;
        Bundle args = new Bundle();
        switch (s) {
            case "posts":
                activity = new ApiActivity();
                args.putString(Constants.BUNDLE_KEY_API, "posts");
                break;
            case "comments":
                activity = new ApiActivity();
                args.putString(Constants.BUNDLE_KEY_API, "comments");
                break;
            case "albums":
                activity = new ApiActivity();
                args.putString(Constants.BUNDLE_KEY_API, "albums");
                break;
            case "photos":
                activity = new ApiActivity();
                args.putString(Constants.BUNDLE_KEY_API, "photos");
                break;
            case "todos":
                activity = new ApiActivity();
                args.putString(Constants.BUNDLE_KEY_API, "todos");
                break;
            case "users":
                activity = new ApiActivity();
                args.putString(Constants.BUNDLE_KEY_API, "users");
                break;
            default:
                break;
        }

        if (activity != null) {
            mMainView.launchNextActivity(activity, args);
        }
    }

    // INTERACTOR CALLBACK

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
