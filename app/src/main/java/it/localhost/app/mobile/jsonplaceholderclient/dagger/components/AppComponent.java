package it.localhost.app.mobile.jsonplaceholderclient.dagger.components;

import javax.inject.Singleton;

import dagger.Component;
import it.localhost.app.mobile.jsonplaceholderclient.dagger.modules.AppModule;
import it.localhost.app.mobile.jsonplaceholderclient.ui.dagger.components.MainComponent;
import it.localhost.app.mobile.jsonplaceholderclient.ui.dagger.modules.MainModule;

/**
 * Dagger component
 */
@Component(
        modules = {
                AppModule.class
        }
)
@Singleton
public interface AppComponent {

    MainComponent plus(MainModule mainModule);
}
