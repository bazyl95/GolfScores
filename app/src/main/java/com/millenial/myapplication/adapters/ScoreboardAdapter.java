package com.millenial.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.millenial.myapplication.R;
import com.millenial.myapplication.model.Hole;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardAdapter extends RecyclerView.Adapter<ScoreboardAdapter.ScoreboardViewHolder> {
    private int itemsAmount;
    private List<Hole> holes;

    public ScoreboardAdapter(int itemsAmount) {
        this.itemsAmount = itemsAmount;
        holes = new ArrayList<>(itemsAmount);
        for (int i = 0; i < itemsAmount; i++) {
            String holeNumber = String.valueOf(i + 1);
            holes.add(new Hole(holeNumber, i, 0));
        }
    }

    @NonNull
    @Override
    public ScoreboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int itemLayoutId = R.layout.score_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(itemLayoutId, parent, false);
        ScoreboardViewHolder viewHolder = new ScoreboardViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreboardViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return itemsAmount;
    }

    class ScoreboardViewHolder extends RecyclerView.ViewHolder {

        TextView holeTextView;
        TextView scoreTextView;
        Button minusButton;
        Button plusButton;

        public ScoreboardViewHolder(@NonNull View itemView) {
            super(itemView);
            holeTextView = itemView.findViewById(R.id.holeTextView);
            scoreTextView = itemView.findViewById(R.id.scoreTextView);
            minusButton = itemView.findViewById(R.id.minusButton);
            plusButton = itemView.findViewById(R.id.plusButton);
        }

        public void bind(final int position) {
            holeTextView.setText(holes.get(position).getmHoleName());
            scoreTextView.setText(String.valueOf(holes.get(position).getmScore()));

            minusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int score = Integer.parseInt(scoreTextView.getText().toString());
                    if (score > 0) {
                        score--;
                        scoreTextView.setText(String.valueOf(score));

                        Hole hole = holes.get(position);
                        hole.setmScore(score);
                        holes.set(position, hole);
                    }
                }
            });
            plusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int score = Integer.parseInt(scoreTextView.getText().toString());
                    score++;
                    scoreTextView.setText(String.valueOf(score));
                    Hole hole = holes.get(position);
                    hole.setmScore(score);
                    holes.set(position, hole);
                }
            });
        }
    }
}
