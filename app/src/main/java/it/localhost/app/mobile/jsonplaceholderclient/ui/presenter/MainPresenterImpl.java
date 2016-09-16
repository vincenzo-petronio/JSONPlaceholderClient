package it.localhost.app.mobile.jsonplaceholderclient.ui.presenter;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import it.localhost.app.mobile.jsonplaceholderclient.data.interactor.MainInteractor;
import it.localhost.app.mobile.jsonplaceholderclient.ui.activity.ApiActivity;
import it.localhost.app.mobile.jsonplaceholderclient.ui.activity.MainView;
import it.localhost.app.mobile.jsonplaceholderclient.util.Constants;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 *
 */
public class MainPresenterImpl implements MainPresenter, Observer<String> {

    private static final String TAG = MainPresenterImpl.class.getSimpleName();
    private MainView mMainView;
    private MainInteractor mMainInteractor;
    private Subscription mSubscription = Subscriptions.empty();

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
                mSubscription = mMainInteractor.getAvailableApi()
                        .observeOn(AndroidSchedulers.mainThread())
                        .unsubscribeOn(Schedulers.io())
                        .map(toUpperCaseFunc)
                        .subscribe(MainPresenterImpl.this);
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

    @Override
    public void finish() {
        mSubscription.unsubscribe();
    }

    // RX INTERACTOR CALLBACK
    List<String> items = new ArrayList<>();

    @Override
    public void onCompleted() {
        Log.v(TAG, "[RX]onCompleted ");
        mMainView.showProgress(false);
        mMainView.setItems(items);
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "[RX]onError ", e);
        mMainView.showMessage(e.getMessage());
        mMainView.showProgress(false);
    }

    @Override
    public void onNext(String s) {
        Log.v(TAG, "[RX]onNext ");
        items.add(s);
    }

    //

    private Func1<String, String> toUpperCaseFunc = new Func1<String, String>() {
        @Override
        public String call(String s) {
            return s.toUpperCase();
        }
    };
}
