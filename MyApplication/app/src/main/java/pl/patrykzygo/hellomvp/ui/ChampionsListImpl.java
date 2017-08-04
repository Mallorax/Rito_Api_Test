package pl.patrykzygo.hellomvp.ui;


import java.util.Collections;

import javax.inject.Inject;

import pl.patrykzygo.hellomvp.repositories.RiotRepository;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

public class ChampionsListImpl implements ChampionsListPresenter {


    private ChampionsListView view;
    private RiotRepository riotRepository;
    private CompositeSubscription subscriptions;

    @Inject
    public ChampionsListImpl(RiotRepository repository) {
        this.riotRepository = repository;
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
                .subscribe(champions -> {
                    Collections.sort(champions, (p1, p2) -> p1.getName().compareTo(p2.getName()));
                    view.attachChampions(champions);
                }, throwable -> {
                    throwable.printStackTrace();
                    view.showErrorMessage("Failed to get Champions List");
                }));
    }
}


