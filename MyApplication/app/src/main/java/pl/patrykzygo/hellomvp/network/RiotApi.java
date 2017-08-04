package pl.patrykzygo.hellomvp.network;


import pl.patrykzygo.hellomvp.BuildConfig;
import pl.patrykzygo.hellomvp.POJO.ChampionListDto;
import pl.patrykzygo.hellomvp.app.Constants;
import retrofit2.http.GET;
import rx.Observable;

public interface RiotApi {

    @GET(Constants.CHAMPIONS_REQUEST + "&api_key=" + BuildConfig.RIOT_API_KEY)
    Observable<ChampionListDto> getChampionsList();
}
