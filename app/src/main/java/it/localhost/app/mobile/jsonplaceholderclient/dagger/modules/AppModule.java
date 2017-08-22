package it.localhost.app.mobile.jsonplaceholderclient.dagger.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import it.localhost.app.mobile.jsonplaceholderclient.JPCApp;
import it.localhost.app.mobile.jsonplaceholderclient.ui.dagger.components.ApiComponent;
import it.localhost.app.mobile.jsonplaceholderclient.ui.dagger.components.MainComponent;
import it.localhost.app.mobile.jsonplaceholderclient.util.NetworkStateManager;

/**
 * Dagger Module
 */
@Module(subcomponents = {
        MainComponent.class,
        ApiComponent.class
})
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(JPCApp application) {
        return application.getApplicationContext();
    }

    /**
     * @return SharedPreferences
     */
    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    /**
     * @return ConnectivityManager
     */
    @Provides
    @Singleton
    ConnectivityManager provideConnectivityManager(Context ctx) {
        return (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    /**
     * @param connectivityManager ConnectivityManager
     * @return NetworkStateManager
     */
    @Provides
    @Singleton
    NetworkStateManager provideNetworkStateManager(ConnectivityManager connectivityManager) {
        return new NetworkStateManager(connectivityManager);
    }

    /**
     * @return Resources
     */
    @Provides
    @Singleton
    Resources provideResources(Context ctx) {
        return ctx.getResources();
    }

}
