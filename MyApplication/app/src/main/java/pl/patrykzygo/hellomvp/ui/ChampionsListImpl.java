package pl.patrykzygo.hellomvp.ui;


import javax.inject.Inject;

import pl.patrykzygo.hellomvp.repositories.RiotDataSource;
import pl.patrykzygo.hellomvp.repositories.RiotRepository;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

public class ChampionsListImpl implements ChampionsListPresenter {


    private ChampionsListView view;
    private RiotDataSource riotRepository;
    private CompositeSubscription subscriptions;

    @Inject
    public ChampionsListImpl(RiotRepository riotRepository) {
        this.riotRepository = riotRepository;
        this.subscriptions = new CompositeSubscription();
    }

    @Override
    public void setView(ChampionsListView view) {
        this.view = view;
    }

    @Override
    public void showChampions() {
        view.showLoading();
        loadChampions();
        view.hideLoading();
    }

    private void loadChampions(){
        subscriptions.add(riotRepository.getChampions()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe((championsList) ->{
            view.attachChampions(championsList);
        }, throwable -> {
            throwable.printStackTrace();
            view.showErrorMessage("Failed to load the champions");
        }));
    }
}


