package pl.patrykzygo.hellomvp.repositories;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;


import pl.patrykzygo.hellomvp.POJO.ChampionDto;
import pl.patrykzygo.hellomvp.network.RiotApi;
import rx.Observable;
import rx.schedulers.Schedulers;

public class RiotRepository implements RiotDataSource {


    private RiotApi riotApi;

    @Inject
    public RiotRepository(RiotApi riotApi){
        this.riotApi = riotApi;
    }

    @Override
    public Observable<List<ChampionDto>> getChampions() {
        return riotApi.getChampionsList()
                .subscribeOn(Schedulers.io())
                .flatMap(riotResponse -> Observable.just(new ArrayList<>(riotResponse.getData().values())))
                .flatMap((list) -> {
                    Collections.sort(list, (p1, p2) -> p1.getName().compareTo(p2.getName()));
                    return Observable.just(list);
                });
    }

    @Override
    public ChampionDto getChampion(int id) {
        //TODO implement
        return null;
    }
}
