package it.localhost.app.mobile.jsonplaceholderclient.ui.dagger.components;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import it.localhost.app.mobile.jsonplaceholderclient.dagger.ActivityScope;
import it.localhost.app.mobile.jsonplaceholderclient.data.dagger.modules.ServiceModule;
import it.localhost.app.mobile.jsonplaceholderclient.ui.activity.ApiActivity;
import it.localhost.app.mobile.jsonplaceholderclient.ui.dagger.modules.ApiModule;

/**
 *
 */
@ActivityScope
@Subcomponent(
        modules = {
                ApiModule.class,
                ServiceModule.class
        }
)
public interface ApiComponent extends AndroidInjector<ApiActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ApiActivity> {
    }
}
