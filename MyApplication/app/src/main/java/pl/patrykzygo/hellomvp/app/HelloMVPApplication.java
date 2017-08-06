package pl.patrykzygo.hellomvp.app;


import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import pl.patrykzygo.hellomvp.Dagger.AppComponent;
import pl.patrykzygo.hellomvp.Dagger.DaggerAppComponent;


public class HelloMVPApplication extends Application{

    private AppComponent appComponent;

    public AppComponent getAppComponent(){
        return appComponent;
    }

    protected AppComponent initDagger(){
        return DaggerAppComponent.builder()
                .build();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

        appComponent = initDagger();
    }
}
