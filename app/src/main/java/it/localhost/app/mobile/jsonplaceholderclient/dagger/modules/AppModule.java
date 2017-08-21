package it.localhost.app.mobile.jsonplaceholderclient.dagger.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import it.localhost.app.mobile.jsonplaceholderclient.JPCApp;
import it.localhost.app.mobile.jsonplaceholderclient.ui.dagger.components.MainComponent;
import it.localhost.app.mobile.jsonplaceholderclient.util.NetworkStateManager;

/**
 * Dagger Module
 */
@Module(subcomponents = {
        MainComponent.class
})
public class AppModule {
//    private final JPCApp mApp;
//
//    public AppModule(JPCApp app) {
//        this.mApp = app;
//    }

//    /**
//     * @return Context
//     */
//    @Singleton
//    @Provides
//    public Context provideContext() {
//        return mApp;
//    }

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
