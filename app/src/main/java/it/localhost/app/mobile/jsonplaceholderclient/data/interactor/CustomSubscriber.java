package it.localhost.app.mobile.jsonplaceholderclient.data.interactor;

import android.util.Log;

import rx.Subscriber;

/**
 *
 */
public class CustomSubscriber<T> extends Subscriber {

    private static final String TAG = CustomSubscriber.class.getSimpleName();

    @Override
    public void onCompleted() {
        Log.d(TAG, "onCompleted");
    }

    @Override
    public void onError(Throwable e) {
        Log.d(TAG, "onError");
    }

    @Override
    public void onNext(Object o) {
        Log.d(TAG, "onNext");
    }
}
