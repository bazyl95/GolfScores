package com.millenial.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.millenial.myapplication.adapters.ScoreboardAdapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView scoreboardList;
    private ScoreboardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreboardList = findViewById(R.id.rv_scores);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        scoreboardList.setLayoutManager(layoutManager);
        scoreboardList.setHasFixedSize(true);
        scoreboardList.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        adapter = new ScoreboardAdapter(18);
        scoreboardList.setAdapter(adapter);


    }
}
