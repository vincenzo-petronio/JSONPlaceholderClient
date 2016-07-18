package it.localhost.app.mobile.jsonplaceholderclient.ui.dagger.modules;

import android.content.res.Resources;

import dagger.Module;
import dagger.Provides;
import it.localhost.app.mobile.jsonplaceholderclient.dagger.ActivityScope;
import it.localhost.app.mobile.jsonplaceholderclient.ui.activity.MainActivity;
import it.localhost.app.mobile.jsonplaceholderclient.ui.presenter.MainPresenter;

/**
 *
 */
@Module
public class MainModule {
    private MainActivity mMainActivity;

    /**
     *
     * @param mainActivity
     */
    public MainModule(MainActivity mainActivity) {
        mMainActivity = mainActivity;
    }

    @Provides
    @ActivityScope
    MainActivity provideMainActivity() {
        return mMainActivity;
    }

    @Provides
    @ActivityScope
    MainPresenter provideMainPresenter(Resources resources) {
        return new MainPresenter(mMainActivity, resources);
    }
}
