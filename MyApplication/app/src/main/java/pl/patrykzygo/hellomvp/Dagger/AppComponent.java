package pl.patrykzygo.hellomvp.Dagger;


import javax.inject.Singleton;

import dagger.Component;
import pl.patrykzygo.hellomvp.ui.ChampionsListActivity;
import pl.patrykzygo.hellomvp.ui.ChampionsListAdapter;

@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        PresenterModule.class,
        RepositoryModule.class,
        AdapterModule.class,
        PicassoModule.class
})

public interface AppComponent {

    void inject(ChampionsListActivity target);
    void inject(ChampionsListAdapter target);

}
