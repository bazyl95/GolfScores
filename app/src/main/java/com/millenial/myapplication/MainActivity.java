package com.millenial.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.millenial.myapplication.adapters.ScoreboardAdapter;
import com.millenial.myapplication.model.Hole;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String PREFS_FILE = "com.millenial.myapplication.preferences";
    private static final String KEY_SCORECOUNT = "key_scorecount";
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private RecyclerView mScoreboardList;
    private ScoreboardAdapter mAdapter;
    private List<Hole> mHoles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreboardList = findViewById(R.id.rv_scores);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mScoreboardList.setLayoutManager(layoutManager);
        mScoreboardList.setHasFixedSize(true);
        mScoreboardList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mSharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        mHoles = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            int score = mSharedPreferences.getInt(KEY_SCORECOUNT + i, 0);
            mHoles.add(new Hole(i, score));
        }
        mAdapter = new ScoreboardAdapter(mHoles);
        mScoreboardList.setAdapter(mAdapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        for (int i = 0; i < mHoles.size(); i++) {
            mEditor.putInt(KEY_SCORECOUNT + i, mHoles.get(i).getmScore());
        }
        mEditor.apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.reset_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.resetItem) {
            resetScore();
        }
        return super.onOptionsItemSelected(item);
    }
    private void resetScore() {
        for (Hole hole :
                mHoles) {
            hole.setmScore(0);
        }
        mAdapter.notifyDataSetChanged();
    }
}
