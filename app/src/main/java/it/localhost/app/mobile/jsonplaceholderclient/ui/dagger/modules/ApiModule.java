package it.localhost.app.mobile.jsonplaceholderclient.ui.dagger.modules;

import android.content.res.Resources;

import dagger.Module;
import dagger.Provides;
import it.localhost.app.mobile.jsonplaceholderclient.dagger.ActivityScope;
import it.localhost.app.mobile.jsonplaceholderclient.data.interactor.ApiInteractor;
import it.localhost.app.mobile.jsonplaceholderclient.data.interactor.ApiInteractorImpl;
import it.localhost.app.mobile.jsonplaceholderclient.ui.activity.ApiView;
import it.localhost.app.mobile.jsonplaceholderclient.ui.presenter.ApiPresenter;
import it.localhost.app.mobile.jsonplaceholderclient.ui.presenter.ApiPresenterImpl;

/**
 *
 */
@Module
public class ApiModule {
    private ApiView mApiView;

    public ApiModule(ApiView apiView) {
        mApiView = apiView;
    }

    @Provides
    @ActivityScope
    ApiView provideApiView() {
        return mApiView;
    }

    @Provides
    @ActivityScope
    ApiPresenter provideApiPresenter(ApiInteractor apiInteractor) {
        return new ApiPresenterImpl(mApiView, apiInteractor);
    }

    @Provides
    @ActivityScope
    ApiInteractor provideApiInteractor(Resources resources) { // TODO cambiare resources con retrofit
        return new ApiInteractorImpl(resources);
    }
}
