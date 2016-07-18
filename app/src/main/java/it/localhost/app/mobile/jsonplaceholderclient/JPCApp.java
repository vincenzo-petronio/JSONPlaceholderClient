package it.localhost.app.mobile.jsonplaceholderclient;

import android.app.Application;

import it.localhost.app.mobile.jsonplaceholderclient.dagger.components.AppComponent;
import it.localhost.app.mobile.jsonplaceholderclient.dagger.components.DaggerAppComponent;
import it.localhost.app.mobile.jsonplaceholderclient.dagger.modules.AppModule;

/**
 *
 */
public class JPCApp extends Application {
    private static AppComponent sAppComponent;
    private static JPCApp appInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;
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
            sAppComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(getAppInstance()))
                    .build();
        }
        return sAppComponent;
    }
}
