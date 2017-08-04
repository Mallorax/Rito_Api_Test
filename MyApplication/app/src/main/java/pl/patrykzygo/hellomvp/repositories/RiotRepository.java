package pl.patrykzygo.hellomvp.repositories;

import java.util.List;

import pl.patrykzygo.hellomvp.POJO.ChampionDto;
import rx.Observable;

public interface RiotRepository {

    Observable<List<ChampionDto>> getChampions();

    ChampionDto getChampion(int id);

}
