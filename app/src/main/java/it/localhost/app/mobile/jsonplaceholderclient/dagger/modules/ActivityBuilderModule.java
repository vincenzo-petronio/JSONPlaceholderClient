package it.localhost.app.mobile.jsonplaceholderclient.dagger.modules;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import it.localhost.app.mobile.jsonplaceholderclient.ui.activity.MainActivity;
import it.localhost.app.mobile.jsonplaceholderclient.ui.dagger.components.MainComponent;

/**
 * Builder dove mappare tutte le Activity
 */
@Module
public abstract class ActivityBuilderModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivity(MainComponent.Builder builder);

}
