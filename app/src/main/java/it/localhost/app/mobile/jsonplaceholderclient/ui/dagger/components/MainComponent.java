package it.localhost.app.mobile.jsonplaceholderclient.ui.dagger.components;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import it.localhost.app.mobile.jsonplaceholderclient.dagger.ActivityScope;
import it.localhost.app.mobile.jsonplaceholderclient.ui.activity.MainActivity;
import it.localhost.app.mobile.jsonplaceholderclient.ui.dagger.modules.MainModule;

/**
 *
 */
@ActivityScope
@Subcomponent(
        modules = {
                MainModule.class
        }
)
public interface MainComponent extends AndroidInjector<MainActivity> {

//    void inject(MainActivity mainActivity);

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {
    }
}
