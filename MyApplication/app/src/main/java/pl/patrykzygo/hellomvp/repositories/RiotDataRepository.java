package pl.patrykzygo.hellomvp.repositories;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import pl.patrykzygo.hellomvp.POJO.ChampionDto;
import pl.patrykzygo.hellomvp.POJO.ChampionListDto;
import pl.patrykzygo.hellomvp.network.RiotApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RiotDataRepository implements RiotRepository {

    @Inject
    RiotApi riotApi;

    private List<ChampionDto> champions;

    @Override
    public List<ChampionDto> getChampions() {

        riotApi.getChampionsList().enqueue(new Callback<ChampionListDto>() {

            @Override
            public void onResponse(Call<ChampionListDto> call, Response<ChampionListDto> response) {
                ChampionListDto listDto = response.body();
                Map<String, ChampionDto> championsMap = listDto.getData();
                champions = new ArrayList<>(championsMap.values());
                Collections.sort(champions, new Comparator<ChampionDto>() {
                    @Override
                    public int compare(ChampionDto o1, ChampionDto o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
            }

            @Override
            public void onFailure(Call<ChampionListDto> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return champions;
    }

    @Override
    public ChampionDto getChampion(int id) {
        //TODO implement
        return null;
    }
}
