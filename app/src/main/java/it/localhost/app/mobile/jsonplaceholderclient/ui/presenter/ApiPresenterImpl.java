package it.localhost.app.mobile.jsonplaceholderclient.ui.presenter;

import android.os.Bundle;

import java.util.List;

import it.localhost.app.mobile.jsonplaceholderclient.data.interactor.ApiInteractor;
import it.localhost.app.mobile.jsonplaceholderclient.data.interactor.ApiInteractorListener;
import it.localhost.app.mobile.jsonplaceholderclient.ui.activity.ApiView;

/**
 *
 */
public class ApiPresenterImpl implements ApiPresenter, ApiInteractorListener {

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
    public void requestItems() {
        mApiInteractor.getApi(ApiPresenterImpl.this);
    }

    @Override
    public void onSelectedItem(Bundle bundle) {
//        mApiView.launchNextView(bundle);
        // nothing
    }

    // INTERACTOR CALLBACK
    @Override
    public void onDataSuccess(List<?> items) {
        mApiView.showProgress(false);
        mApiView.setItems(items);
    }

    @Override
    public void onDataError(Exception e) {
        mApiView.showProgress(false);
    }
}
