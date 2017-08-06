package pl.patrykzygo.hellomvp.ui;


import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import pl.patrykzygo.hellomvp.POJO.ChampionDto;
import pl.patrykzygo.hellomvp.R;
import pl.patrykzygo.hellomvp.app.Constants;

public class ChampionsListAdapter extends RecyclerView.Adapter<ChampionsListAdapter.ChampionsViewHolder> {

    private List<ChampionDto> champions;
    private Context context;


    public ChampionsListAdapter(List<ChampionDto> champions, Context context) {
        this.champions = champions;
        this.context = context;
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
        Picasso.with(context)
                .load(Uri.parse("http://ddragon.leagueoflegends.com/cdn/"+ Constants.VERSION+"/img/champion/"+champ.getImage().getFull()))
                .resize(64, 64)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return champions.size();
    }

    public static class ChampionsViewHolder extends RecyclerView.ViewHolder{


        private TextView nameView;
        private TextView titleView;
        private ImageView imageView;

        public ChampionsViewHolder(View itemView) {
            super(itemView);
            nameView = (TextView) itemView.findViewById(R.id.champion_name_text_view);
            titleView = (TextView) itemView.findViewById(R.id.champion_title_text_view);
            imageView = (ImageView) itemView.findViewById(R.id.champion_list_icon);
        }
    }
}
