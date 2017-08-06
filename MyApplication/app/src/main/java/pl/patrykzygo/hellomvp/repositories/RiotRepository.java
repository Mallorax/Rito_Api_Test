package pl.patrykzygo.hellomvp.repositories;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import pl.patrykzygo.hellomvp.POJO.ChampionDto;
import pl.patrykzygo.hellomvp.network.RiotApi;
import rx.Observable;

public class RiotRepository implements RiotDataSource {


    private RiotApi riotApi;

    @Inject
    public RiotRepository(RiotApi riotApi){
        this.riotApi = riotApi;
    }

    @Override
    public Observable<List<ChampionDto>> getChampions() {
        return riotApi.getChampionsList()
                .flatMap(riotResponse -> Observable.just(new ArrayList<>(riotResponse.getData().values())));

    }

    @Override
    public ChampionDto getChampion(int id) {
        //TODO implement
        return null;
    }
}
