package it.localhost.app.mobile.jsonplaceholderclient;

import android.app.Application;

import it.localhost.app.mobile.jsonplaceholderclient.dagger.components.AppComponent;
import it.localhost.app.mobile.jsonplaceholderclient.dagger.components.DaggerAppComponent;

/**
 *
 */
public class JPCApp extends Application {
    private static AppComponent sAppComponent;
    private static JPCApp appInstance = new JPCApp();

    @Override
    public void onCreate() {
        super.onCreate();
        getAppComponent();
    }

    /**
     * @return JPCApp
     */
    public static JPCApp getAppInstance() {
        return appInstance;
    }

    /**
     * @return AppComponent
     */
    public static AppComponent getAppComponent() {
        if (sAppComponent == null) {
            sAppComponent = DaggerAppComponent.builder().build();
        }
        return sAppComponent;
    }
}
