package it.localhost.app.mobile.jsonplaceholderclient.ui.presenter;

import android.os.Bundle;

import java.util.List;

import it.localhost.app.mobile.jsonplaceholderclient.data.interactor.ApiInteractor;
import it.localhost.app.mobile.jsonplaceholderclient.data.interactor.ApiInteractorListener;
import it.localhost.app.mobile.jsonplaceholderclient.data.interactor.CustomSubscriber;
import it.localhost.app.mobile.jsonplaceholderclient.ui.activity.ApiView;

/**
 *
 */
public class ApiPresenterImpl implements ApiPresenter {

    private static final String TAG = ApiPresenterImpl.class.getSimpleName();
    private ApiView mApiView;
    private ApiInteractor mApiInteractor;

    /**
     * @param apiView       ApiView
     * @param apiInteractor ApiInteractor
     */
    public ApiPresenterImpl(ApiView apiView, ApiInteractor apiInteractor) {
        mApiView = apiView;
        mApiInteractor = apiInteractor;
    }

    @Override
    public void requestItems(String arg) {
        switch (arg) {
            case "posts":
                break;
            case "comments":
                break;
            default:
                break;
        }

        mApiInteractor.getApi(new ApiSubscriber(), arg);
    }

    @Override
    public void onSelectedItem(Bundle bundle) {
//        mApiView.launchNextView(bundle);
        // nothing
    }

    @Override
    public void finish() {
        mApiInteractor.unsubscribe();
    }

    // RX SUBSCRIBER/CALLBACK
    /**
     *
     */
    private final class ApiSubscriber extends CustomSubscriber<List<?>> {

        @Override
        public void onCompleted() {
            super.onCompleted();
            mApiView.showProgress(false);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mApiView.showProgress(false);
        }

        @Override
        public void onNext(Object items) {
            super.onNext(items);
            mApiView.setItems((List<?>) items);
        }
    }
}
