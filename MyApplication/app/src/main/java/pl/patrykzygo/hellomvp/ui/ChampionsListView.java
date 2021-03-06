package pl.patrykzygo.hellomvp.ui;


import java.util.List;

import pl.patrykzygo.hellomvp.POJO.ChampionDto;

public interface ChampionsListView {

    void showLoading();
    void hideLoading();
    void attachChampions(List<ChampionDto> champions);
    void showErrorMessage(String errorMessage);
}
