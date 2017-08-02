package pl.patrykzygo.hellomvp.repositories;

import java.util.List;

import pl.patrykzygo.hellomvp.POJO.ChampionDto;

public interface RiotRepository {

    List<ChampionDto> getChampions();

    ChampionDto getChampion(int id);

}
