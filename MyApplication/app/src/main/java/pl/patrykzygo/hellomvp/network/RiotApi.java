package pl.patrykzygo.hellomvp.network;


import pl.patrykzygo.hellomvp.R;
import pl.patrykzygo.hellomvp.app.Constants;
import pl.patrykzygo.hellomvp.model.ChampionListDto;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RiotApi {

    @GET(Constants.CHAMPIONS_REQUEST + "&api_key=" + R.string.RIOT_API_KEY)
    Call<ChampionListDto> getChampionsList();
}
