package pl.patrykzygo.hellomvp.Dagger;


import dagger.Module;
import dagger.Provides;
import pl.patrykzygo.hellomvp.network.RiotApi;
import pl.patrykzygo.hellomvp.repositories.RiotDataRepository;
import pl.patrykzygo.hellomvp.repositories.RiotRepository;

@Module
public class RepositoryModule {

    @Provides
    RiotRepository providesRiotDataRepository(RiotApi api){
        return new RiotDataRepository(api);
    }
}
