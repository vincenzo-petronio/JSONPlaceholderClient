package it.localhost.app.mobile.jsonplaceholderclient.ui.dagger.components;

import dagger.Subcomponent;
import it.localhost.app.mobile.jsonplaceholderclient.dagger.ActivityScope;
import it.localhost.app.mobile.jsonplaceholderclient.ui.dagger.modules.ApiModule;
import it.localhost.app.mobile.jsonplaceholderclient.ui.fragment.ItemsFragment;

/**
 *
 */
@ActivityScope
@Subcomponent(
        modules = {
                ApiModule.class
        }
)
public interface ApiComponent {
    void inject(ItemsFragment itemsFragment);
}
