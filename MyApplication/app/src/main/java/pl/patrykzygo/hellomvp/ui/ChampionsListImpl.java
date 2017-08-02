package pl.patrykzygo.hellomvp.ui;


import android.content.Context;

import javax.inject.Inject;

import pl.patrykzygo.hellomvp.app.HelloMVPApplication;
import pl.patrykzygo.hellomvp.network.RiotApi;
import pl.patrykzygo.hellomvp.repositories.RiotDataRepository;
import pl.patrykzygo.hellomvp.repositories.RiotRepository;

public class ChampionsListImpl implements ChampionsListPresenter {

    @Inject
    RiotApi riotApi;

    private ChampionsListView view;
    private RiotRepository riotRepository;

    public ChampionsListImpl(Context context) {
        ((HelloMVPApplication) context).getAppComponent().inject(this);
        riotRepository = new RiotDataRepository();
    }

    @Override
    public void setView(ChampionsListView view) {
        this.view = view;
    }

    @Override
    public void getChampions() {
        view.showLoading();
        view.showChampions(riotRepository.getChampions());
        view.hideLoading();
    }
}


