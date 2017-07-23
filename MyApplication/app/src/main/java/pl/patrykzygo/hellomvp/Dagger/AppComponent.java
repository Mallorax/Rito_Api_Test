package pl.patrykzygo.hellomvp.Dagger;


import javax.inject.Singleton;

import dagger.Component;
import pl.patrykzygo.hellomvp.ui.ChampionsListActivity;
import pl.patrykzygo.hellomvp.ui.ChampionsListImpl;

@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        PresenterModule.class
})

public interface AppComponent {

    void inject(ChampionsListActivity target);
    void inject(ChampionsListImpl target);

}
