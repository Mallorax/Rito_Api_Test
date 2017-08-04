package pl.patrykzygo.hellomvp.Dagger;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.patrykzygo.hellomvp.repositories.RiotRepository;
import pl.patrykzygo.hellomvp.ui.ChampionsListImpl;
import pl.patrykzygo.hellomvp.ui.ChampionsListPresenter;

@Module
public class PresenterModule {

    @Provides
    @Singleton
    ChampionsListPresenter provideChampionsListPresenter(RiotRepository repository){
        return new ChampionsListImpl(repository);
    }
}
