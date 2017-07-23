package pl.patrykzygo.hellomvp.Dagger;


import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.patrykzygo.hellomvp.ui.ChampionsListImpl;
import pl.patrykzygo.hellomvp.ui.ChampionsListPresenter;

@Module
public class PresenterModule {

    @Provides
    @Singleton
    ChampionsListPresenter provideChampionsListPresenter(Context context){
        return new ChampionsListImpl(context);
    }
}
