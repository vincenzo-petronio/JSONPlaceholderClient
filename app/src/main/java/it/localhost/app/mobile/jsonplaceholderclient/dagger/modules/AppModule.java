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
import it.localhost.app.mobile.jsonplaceholderclient.util.NetworkStateManager;

/**
 * Dagger Module
 */
@Module
public class AppModule {
    private final JPCApp mApp;

    public AppModule(JPCApp app) {
        this.mApp = app;
    }

    /**
     * @return Context
     */
    @Singleton
    @Provides
    public Context provideContext() {
        return mApp;
    }

    /**
     * @return SharedPreferences
     */
    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(mApp);
    }

    /**
     * @return ConnectivityManager
     */
    @Provides
    @Singleton
    ConnectivityManager provideConnectivityManager() {
        return (ConnectivityManager) mApp.getSystemService(mApp.CONNECTIVITY_SERVICE);
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
    Resources provideResources() {
        return mApp.getResources();
    }

}
