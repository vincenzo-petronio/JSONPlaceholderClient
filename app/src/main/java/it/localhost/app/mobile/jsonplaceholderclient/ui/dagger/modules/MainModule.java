package it.localhost.app.mobile.jsonplaceholderclient.ui.dagger.modules;

import android.content.res.Resources;

import dagger.Module;
import dagger.Provides;
import it.localhost.app.mobile.jsonplaceholderclient.dagger.ActivityScope;
import it.localhost.app.mobile.jsonplaceholderclient.data.MainInteractor;
import it.localhost.app.mobile.jsonplaceholderclient.data.MainInteractorImpl;
import it.localhost.app.mobile.jsonplaceholderclient.ui.activity.MainView;
import it.localhost.app.mobile.jsonplaceholderclient.ui.presenter.MainPresenter;
import it.localhost.app.mobile.jsonplaceholderclient.ui.presenter.MainPresenterImpl;

/**
 *
 */
@Module
public class MainModule {
    private MainView mMainView;

    /**
     * @param mainView MainView
     */
    public MainModule(MainView mainView) {
        mMainView = mainView;
    }

    @Provides
    @ActivityScope
    MainView provideMainView() {
        return mMainView;
    }

    @Provides
    @ActivityScope
    MainPresenter provideMainPresenter(MainInteractor interactor) {
        return new MainPresenterImpl(mMainView, interactor);
    }

    @Provides
    @ActivityScope
    MainInteractor provideMainInteractor(Resources resources) {
        return new MainInteractorImpl(resources);
    }

}
