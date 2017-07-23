package pl.patrykzygo.hellomvp.app;


import android.app.Application;

import pl.patrykzygo.hellomvp.Dagger.AppComponent;
import pl.patrykzygo.hellomvp.Dagger.AppModule;
import pl.patrykzygo.hellomvp.Dagger.DaggerAppComponent;

public class HelloMVPApplication extends Application{

    private AppComponent appComponent;

    public AppComponent getAppComponent(){
        return appComponent;
    }

    protected AppComponent initDagger(HelloMVPApplication application){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = initDagger(this);
    }
}
