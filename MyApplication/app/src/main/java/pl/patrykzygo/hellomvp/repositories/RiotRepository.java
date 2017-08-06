package pl.patrykzygo.hellomvp.repositories;


import java.util.List;

import javax.inject.Inject;

import pl.patrykzygo.hellomvp.POJO.ChampionDto;
import rx.Observable;

public class RiotRepository {

    private RiotDataSource remoteDataSource;


    @Inject
    public RiotRepository (RiotDataSource remoteDataSource){
        this.remoteDataSource = remoteDataSource;
    }

    public Observable<List<ChampionDto>> getChampionsWithImages(){
       return remoteDataSource.getChampions();
    }
}
