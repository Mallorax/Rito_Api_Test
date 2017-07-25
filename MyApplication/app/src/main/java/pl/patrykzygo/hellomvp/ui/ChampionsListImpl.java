package pl.patrykzygo.hellomvp.ui;


import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import pl.patrykzygo.hellomvp.app.HelloMVPApplication;
import pl.patrykzygo.hellomvp.model.ChampionDto;
import pl.patrykzygo.hellomvp.model.ChampionListDto;
import pl.patrykzygo.hellomvp.network.RiotApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChampionsListImpl implements ChampionsListPresenter {

    @Inject
    RiotApi riotApi;

    private ChampionsListView view;

    public ChampionsListImpl(Context context) {
        ((HelloMVPApplication) context).getAppComponent().inject(this);
    }

    @Override
    public void setView(ChampionsListView view) {
        this.view = view;
    }

    @Override
    public void getChampions() {
        view.showLoading();
        riotApi.getChampionsList().enqueue(new Callback<ChampionListDto>() {
            @Override
            public void onResponse(Call<ChampionListDto> call, Response<ChampionListDto> response) {
                if (response.code() != 200) {
                    view.hideLoading();
                    view.showErrorMessage("Error: " + Integer.toString(response.code()));
                } else {
                    ChampionListDto listDto = response.body();
                    Map<String, ChampionDto> championsMap = listDto.getData();
                    List<ChampionDto> champions = new ArrayList<>(championsMap.values());
                    Collections.sort(champions, new Comparator<ChampionDto>() {
                        @Override
                        public int compare(ChampionDto o1, ChampionDto o2) {
                            return o1.getName().compareTo(o2.getName());

                        }
                    });
                    view.hideLoading();
                    view.showChampions(champions);
                }
            }

            @Override
            public void onFailure(Call<ChampionListDto> call, Throwable t) {
                view.hideLoading();
                view.showErrorMessage("Unable to retrieve champions list.");
                t.printStackTrace();
            }
        });
    }
}


