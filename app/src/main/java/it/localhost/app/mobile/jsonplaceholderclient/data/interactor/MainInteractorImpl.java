package it.localhost.app.mobile.jsonplaceholderclient.data.interactor;

import android.content.res.Resources;

import it.localhost.app.mobile.jsonplaceholderclient.R;
import rx.Observable;

/**
 *
 */
public class MainInteractorImpl implements MainInteractor {

    private Resources mResources;

    public MainInteractorImpl(Resources resources) {
        mResources = resources;
    }

    @Override
    public Observable<String> getAvailableApi() {
        if (mResources == null) {
            return Observable.error(new NullPointerException("mResources NULL!!!"));
        }
        return Observable.from(mResources.getStringArray(R.array.main_menu));
    }

    @Override
    public void unsubscribe() {

    }
}
