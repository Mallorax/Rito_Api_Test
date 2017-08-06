package pl.patrykzygo.hellomvp.Dagger;

import android.content.Context;

import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PicassoModule {

    @Provides
    @Singleton
    Picasso providesPicasso(Context context){
        return Picasso.with(context);
    }
}
