package com.nekodev.paulina.sadowska.simplemoviebrowser.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nekodev.paulina.sadowska.simplemoviebrowser.R;
import com.nekodev.paulina.sadowska.simplemoviebrowser.view.fragment.MovieListFragment;

public class MovieListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        if ((findViewById(R.id.content_frame) != null && savedInstanceState == null)
                || findViewById(R.id.content_frame) == null) {
            addMovieListFragment();
        }
    }

    private void addMovieListFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, new MovieListFragment())
                .commit();

    }
}
