package it.localhost.app.mobile.jsonplaceholderclient;

import com.squareup.leakcanary.LeakCanary;

import android.util.Log;

import dagger.android.AndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.DaggerApplication;
import it.localhost.app.mobile.jsonplaceholderclient.dagger.components.AppComponent;
import it.localhost.app.mobile.jsonplaceholderclient.dagger.components.DaggerAppComponent;

/**
 *
 */
public class JPCApp extends DaggerApplication implements HasActivityInjector {

    private static final String TAG = JPCApp.class.getSimpleName();
    //    private static AppComponent sAppComponent;
    private static JPCApp appInstance;

//    @Inject
//    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        Log.v(TAG, "onCreate");
        super.onCreate();
        appInstance = this;

//        initDagger();
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

    private AppComponent initDagger() {
        return DaggerAppComponent
                .builder()
                .application(this)
                .build();
//                .inject(this);
    }

    /**
     * @see <a href="https://github.com/square/leakcanary">LeakCanary</a>
     */
    private void initLeakDetection() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }

//    @Override
//    public AndroidInjector<Activity> activityInjector() {
//        return dispatchingAndroidInjector;
//    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = initDagger();
        appComponent.inject(this);
        return appComponent;
    }
}
