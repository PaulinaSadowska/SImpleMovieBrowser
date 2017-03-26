package com.nekodev.paulina.sadowska.simplemoviebrowser.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.nekodev.paulina.sadowska.simplemoviebrowser.R;
import com.nekodev.paulina.sadowska.simplemoviebrowser.viewmodel.MovieItemViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paulina Sadowska on 25.03.2017.
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<MovieItemViewModel> movies = new ArrayList<>();

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.movie_list_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        MovieItemViewModel movie = movies.get(position);
        Context context = holder.title.getContext();
        holder.title.setText(movie.getTitle());
        Glide.with(context)
                .load(movie.getImagePath())
                .fitCenter()
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void addMovies(List<MovieItemViewModel> movies) {
        this.movies.addAll(movies);
        notifyDataSetChanged();
    }
}
