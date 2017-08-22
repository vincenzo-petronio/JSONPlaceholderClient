package it.localhost.app.mobile.jsonplaceholderclient.dagger.components;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;
import it.localhost.app.mobile.jsonplaceholderclient.JPCApp;
import it.localhost.app.mobile.jsonplaceholderclient.dagger.modules.ActivityBuilderModule;
import it.localhost.app.mobile.jsonplaceholderclient.dagger.modules.AppModule;

/**
 * Dagger component
 */
@Component(
        modules = {
                /* Use AndroidInjectionModule.class if you're not using support library */
                AndroidSupportInjectionModule.class,
                AppModule.class,
                ActivityBuilderModule.class
        }
)
@Singleton
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    /**
     * @deprecated valido per dagger < 2.10
     */
    // Un @Subcomponent non può vivere autonomamente, per questo deve essere definito come metodo
    // in una interfaccia annotata come @Component, e tale metodo deve restituire proprio il tipo
    // di interfaccia annotata come @Subcomponent.
    // Tale operazione va ripetuta per ogni Activity annotata come @Subcomponent.
//    MainComponent plus(MainModule mainModule);
//
//    ApiComponent plus(ApiModule apiModule, ServiceModule serviceModule);

    /**
     * @since dagger 2.10
     */
    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(JPCApp app);

    @Override
    void inject(DaggerApplication instance);
}
