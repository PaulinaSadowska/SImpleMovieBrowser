package com.nekodev.paulina.sadowska.simplemoviebrowser.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nekodev.paulina.sadowska.simplemoviebrowser.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by palka on 25.03.2017.
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<String> movies = new ArrayList<>();

    public MovieListAdapter(List<String> movies) {
        this.movies = movies;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.movie_list_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        String title = movies.get(position);
        holder.title.setText(title);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
