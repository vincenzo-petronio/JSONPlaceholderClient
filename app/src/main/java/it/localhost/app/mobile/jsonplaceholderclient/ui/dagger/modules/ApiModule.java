package it.localhost.app.mobile.jsonplaceholderclient.ui.dagger.modules;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import it.localhost.app.mobile.jsonplaceholderclient.dagger.ActivityScope;
import it.localhost.app.mobile.jsonplaceholderclient.dagger.FragmentScope;
import it.localhost.app.mobile.jsonplaceholderclient.data.ApiService;
import it.localhost.app.mobile.jsonplaceholderclient.data.interactor.ApiInteractor;
import it.localhost.app.mobile.jsonplaceholderclient.data.interactor.ApiInteractorImpl;
import it.localhost.app.mobile.jsonplaceholderclient.ui.activity.ApiActivity;
import it.localhost.app.mobile.jsonplaceholderclient.ui.activity.ApiView;
import it.localhost.app.mobile.jsonplaceholderclient.ui.fragment.ItemsFragment;
import it.localhost.app.mobile.jsonplaceholderclient.ui.presenter.ApiPresenter;
import it.localhost.app.mobile.jsonplaceholderclient.ui.presenter.ApiPresenterImpl;

/**
 *
 */
@Module
public class ApiModule {
    private ApiView mApiView;
//
//    public ApiModule(ApiView apiView) {
//        mApiView = apiView;
//    }

    @Provides
    @ActivityScope
    ApiView provideApiView() {
        return mApiView;
    }

    @FragmentScope
    @ContributesAndroidInjector
    ItemsFragment provideItemsFragment() {
        return new ItemsFragment();
    }

    @Provides
    @ActivityScope
    ApiPresenter provideApiPresenter(ApiView apiView, ApiInteractor apiInteractor) {
        return new ApiPresenterImpl(apiView, apiInteractor);
    }

    @Provides
    @ActivityScope
    ApiInteractor provideApiInteractor(ApiService resources) {
        return new ApiInteractorImpl(resources);
    }
}
