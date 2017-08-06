package pl.patrykzygo.hellomvp.Dagger;


import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.patrykzygo.hellomvp.ui.ChampionsListAdapter;

@Module
public class AdapterModule {

    @Provides
    @Singleton
    ChampionsListAdapter providesChampionsListAdapter(Picasso picasso){
        return new ChampionsListAdapter(picasso);
    }
}
