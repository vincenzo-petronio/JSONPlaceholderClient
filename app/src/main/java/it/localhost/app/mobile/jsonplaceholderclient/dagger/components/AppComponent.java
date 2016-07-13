package it.localhost.app.mobile.jsonplaceholderclient.dagger.components;

import javax.inject.Singleton;

import dagger.Component;
import it.localhost.app.mobile.jsonplaceholderclient.dagger.modules.AppModule;

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

}
