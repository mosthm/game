package com.example.alifatemeh.game;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UserSpeedAdapter extends RecyclerView.Adapter<UserSpeedAdapter.ViewHolder>{
    private List<UserSpeed> items;

    //view ra chejori besazam
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //add template
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.template_user_row, viewGroup,false);
        return new ViewHolder(view);
    }
    //new view visable
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //add value
        viewHolder.name.setText(items.get(i).getName());
        viewHolder.score.setText(String.valueOf(items.get(i).getScore()));
        viewHolder.rank.setText(String.valueOf(i+1));
    }
    //chan ta item dare recyclerview
    @Override
    public int getItemCount() {
        return items.size();
    }

    public UserSpeedAdapter(List<UserSpeed> items) {
        this.items = items;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView score;
        public TextView name;
        public TextView rank;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            score=itemView.findViewById(R.id.player_score);
            name=itemView.findViewById(R.id.player_name);
            rank=itemView.findViewById(R.id.rank_player);
        }
    }
}
