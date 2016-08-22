package it.localhost.app.mobile.jsonplaceholderclient.dagger.components;

import javax.inject.Singleton;

import dagger.Component;
import it.localhost.app.mobile.jsonplaceholderclient.dagger.modules.AppModule;
import it.localhost.app.mobile.jsonplaceholderclient.ui.dagger.components.ApiComponent;
import it.localhost.app.mobile.jsonplaceholderclient.ui.dagger.components.MainComponent;
import it.localhost.app.mobile.jsonplaceholderclient.ui.dagger.modules.ApiModule;
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

    // Un @Subcomponent non può vivere autonomamente, per questo deve essere definito come metodo
    // in una interfaccia annotata come @Component, e tale metodo deve restituire proprio il tipo
    // di interfaccia annotata come @Subcomponent.
    // Tale operazione va ripetuta per ogni Activity annotata come @Subcomponent.
    MainComponent plus(MainModule mainModule);

    ApiComponent plus(ApiModule apiModule);
}
