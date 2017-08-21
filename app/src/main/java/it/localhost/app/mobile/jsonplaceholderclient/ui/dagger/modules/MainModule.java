package it.localhost.app.mobile.jsonplaceholderclient.ui.dagger.modules;

import android.content.res.Resources;

import dagger.Module;
import dagger.Provides;
import it.localhost.app.mobile.jsonplaceholderclient.dagger.ActivityScope;
import it.localhost.app.mobile.jsonplaceholderclient.data.interactor.MainInteractor;
import it.localhost.app.mobile.jsonplaceholderclient.data.interactor.MainInteractorImpl;
import it.localhost.app.mobile.jsonplaceholderclient.ui.activity.MainActivity;
import it.localhost.app.mobile.jsonplaceholderclient.ui.activity.MainView;
import it.localhost.app.mobile.jsonplaceholderclient.ui.presenter.MainPresenter;
import it.localhost.app.mobile.jsonplaceholderclient.ui.presenter.MainPresenterImpl;

/**
 *
 */
@Module
public class MainModule {
//    private MainView mMainView;

//    /**
//     * @param mainView MainView
//     */
//    public MainModule(MainView mainView) {
//        mMainView = mainView;
//    }

    @Provides
    @ActivityScope
    MainView provideMainView(MainActivity mainActivity) {
        return mainActivity;
    }

    @Provides
    @ActivityScope
    MainPresenter provideMainPresenter(MainView mainView, MainInteractor interactor) {
        return new MainPresenterImpl(mainView, interactor);
    }

    @Provides
    @ActivityScope
    MainInteractor provideMainInteractor(Resources resources) {
        return new MainInteractorImpl(resources);
    }

}
