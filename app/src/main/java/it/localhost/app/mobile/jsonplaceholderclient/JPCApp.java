package it.localhost.app.mobile.jsonplaceholderclient;

import com.squareup.leakcanary.LeakCanary;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import it.localhost.app.mobile.jsonplaceholderclient.dagger.components.AppComponent;
import it.localhost.app.mobile.jsonplaceholderclient.dagger.components.DaggerAppComponent;
import it.localhost.app.mobile.jsonplaceholderclient.dagger.modules.AppModule;

/**
 *
 */
public class JPCApp extends Application implements HasActivityInjector {

    private static final String TAG = JPCApp.class.getSimpleName();
    //    private static AppComponent sAppComponent;
    private static JPCApp appInstance;

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        Log.v(TAG, "onCreate");
        super.onCreate();
        appInstance = this;

        initDagger();
        initLeakDetection();
    }

    /**
     * @return JPCApp
     */
    public static JPCApp getAppInstance() {
        return appInstance;
    }

//    /**
//     * @return AppComponent
//     */
//    public static AppComponent getAppComponent() {
//        if (sAppComponent == null) {
//            sAppComponent = DaggerAppComponent.builder()
//                    .appModule(new AppModule(getAppInstance()))
//                    .build();
//        }
//        return sAppComponent;
//    }

    private void initDagger() {
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this);
    }

    /**
     * @see <a href="https://github.com/square/leakcanary">LeakCanary</a>
     */
    private void initLeakDetection() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
