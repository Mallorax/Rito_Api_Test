package pl.patrykzygo.hellomvp.Dagger;


import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.patrykzygo.hellomvp.app.Constants;
import pl.patrykzygo.hellomvp.network.RiotApi;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class NetworkModule {

    private static final String NAME_BASE_URL ="NAME_BASE_URL";

    @Provides
    @Named(NAME_BASE_URL)
    String provideBaseURLString(){
        return Constants.BASE_URL;
    }

    @Provides
    @Singleton
    Converter.Factory provideGsonConverter(){
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Converter.Factory converter, @Named(NAME_BASE_URL) String baseUrl){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converter)
                .build();
    }

    @Provides
    @Singleton
    RiotApi provideRiotApi(Retrofit retrofit){
        return retrofit.create(RiotApi.class);
    }

}
