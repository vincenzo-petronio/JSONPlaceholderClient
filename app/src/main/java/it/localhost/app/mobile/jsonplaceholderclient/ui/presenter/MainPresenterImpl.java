package it.localhost.app.mobile.jsonplaceholderclient.ui.presenter;

import android.os.CountDownTimer;

import java.util.List;

import it.localhost.app.mobile.jsonplaceholderclient.data.MainInteractor;
import it.localhost.app.mobile.jsonplaceholderclient.data.MainInteractorImpl;
import it.localhost.app.mobile.jsonplaceholderclient.ui.activity.MainView;

/**
 *
 */
public class MainPresenterImpl implements MainPresenter, MainInteractorImpl.MainInteractorListener {

    private MainView mMainView;
    private MainInteractor mMainInteractor;

    public MainPresenterImpl(MainView mainView, MainInteractor interactor) {
        mMainView = mainView;
        mMainInteractor = interactor;
    }

//    /**
//     * @param mainView  MainView
//     * @param resources Resources
//     */
//    public MainPresenterImpl(MainView mainView, Resources resources) {
//        this.mMainView = mainView;
//        this.mResources = resources;
//    }

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
    public void onDataSuccess(List<String> items) {
        // TODO i dati devono arrivare dalla callback. spostare l'arrays in getAvailableApi
        mMainView.setItems(items);
        mMainView.showProgress(false);
    }

    @Override
    public void onDataError(Exception e) {
        mMainView.showMessage(e.getMessage());
        mMainView.showProgress(false);
    }
}
