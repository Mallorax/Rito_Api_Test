package pl.patrykzygo.hellomvp.Dagger;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.patrykzygo.hellomvp.network.RiotApi;
import pl.patrykzygo.hellomvp.repositories.RiotDataSource;
import pl.patrykzygo.hellomvp.repositories.RiotRemoteDataSource;
import pl.patrykzygo.hellomvp.repositories.RiotRepository;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    RiotDataSource providesRiotDataSource(RiotApi api){
        return new RiotRemoteDataSource(api);
    }

    @Provides
    @Singleton
    RiotRepository providesRiotRepository(RiotDataSource remoteDataSource){
        return new RiotRepository(remoteDataSource);
    }
}
