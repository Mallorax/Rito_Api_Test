package pl.patrykzygo.hellomvp.ui;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pl.patrykzygo.hellomvp.R;
import pl.patrykzygo.hellomvp.POJO.ChampionDto;

public class ChampionsListAdapter extends RecyclerView.Adapter<ChampionsListAdapter.ChampionsViewHolder> {

    private List<ChampionDto> champions;

    public ChampionsListAdapter(List<ChampionDto> champions) {
        this.champions = champions;
    }

    @Override
    public ChampionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View championView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.champions_list_item, parent, false);
        return new ChampionsViewHolder(championView);
    }

    @Override
    public void onBindViewHolder(ChampionsViewHolder holder, int position) {
        ChampionDto champ = champions.get(position);
        holder.nameView.setText(champ.getName());
        holder.titleView.setText(champ.getTitle());
    }

    @Override
    public int getItemCount() {
        return champions.size();
    }

    public static class ChampionsViewHolder extends RecyclerView.ViewHolder{

        private TextView nameView;
        private TextView titleView;

        public ChampionsViewHolder(View itemView) {
            super(itemView);
            this.nameView = (TextView) itemView.findViewById(R.id.champion_name_text_view);
            this.titleView = (TextView) itemView.findViewById(R.id.champion_title_text_view);
        }
    }
}
