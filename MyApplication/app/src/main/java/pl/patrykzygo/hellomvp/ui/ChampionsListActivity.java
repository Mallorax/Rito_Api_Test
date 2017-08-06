package pl.patrykzygo.hellomvp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.patrykzygo.hellomvp.POJO.ChampionDto;
import pl.patrykzygo.hellomvp.R;
import pl.patrykzygo.hellomvp.app.HelloMVPApplication;

public class ChampionsListActivity extends AppCompatActivity implements ChampionsListView {

    @Inject
    ChampionsListPresenter presenter;

    @BindView(R.id.champions_recycler_view)
    RecyclerView championsRecyclerView;

    @BindView(R.id.activity_champions_progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champions_list);

        ((HelloMVPApplication) getApplication()).getAppComponent().inject(this);

        ButterKnife.bind(this);
        championsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter.setView(this);
        presenter.showChampions();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void attachChampions(List<ChampionDto> champions) {
        championsRecyclerView.setAdapter(new ChampionsListAdapter(champions, this));
        championsRecyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

}
