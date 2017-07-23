package pl.patrykzygo.hellomvp.ui;


import java.util.List;

import pl.patrykzygo.hellomvp.model.ChampionDto;

public interface ChampionsListView {

    void showLoading();
    void hideLoading();
    void showChampions(List<ChampionDto> champions);
    void showErrorMessage(int errorMessage);
    void showErrorMessage();
}
