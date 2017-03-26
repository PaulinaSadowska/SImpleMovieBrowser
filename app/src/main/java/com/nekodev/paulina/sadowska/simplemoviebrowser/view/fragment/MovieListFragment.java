package com.nekodev.paulina.sadowska.simplemoviebrowser.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nekodev.paulina.sadowska.simplemoviebrowser.MovieApplication;
import com.nekodev.paulina.sadowska.simplemoviebrowser.R;
import com.nekodev.paulina.sadowska.simplemoviebrowser.view.adapter.MovieListAdapter;
import com.nekodev.paulina.sadowska.simplemoviebrowser.viewmodel.MovieItemViewModel;
import com.nekodev.paulina.sadowska.simplemoviebrowser.viewmodel.MoviesViewModel;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscription;

/**
 * Created by Paulina Sadowska on 25.03.2017.
 */

public class MovieListFragment extends Fragment {

    MoviesViewModel mMoviesViewModel;

    @BindView(R.id.recycler_movies)
    RecyclerView mMovieList;

    private Subscription subscription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);
        ButterKnife.bind(this, view);
        mMoviesViewModel = MovieApplication.get(getActivity()).getComponent().moviesViewModel();
        setupRecyclerView();
        setupBindings();
        loadMovies();
        return view;
    }

    private void setupRecyclerView() {
        mMovieList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mMovieList.setHasFixedSize(true);
        mMovieList.setAdapter(new MovieListAdapter());
    }

    private void loadMovies() {
        mMoviesViewModel.loadMovies(1);
    }


    private void setupBindings() {
        subscription = mMoviesViewModel.moviesStream.subscribe(movies -> {
            showMovies(movies);
            onLoadingCompleted();
        }, this::showError);
    }

    public void showMovies(List<MovieItemViewModel> movies) {
        MovieListAdapter adapter = (MovieListAdapter) mMovieList.getAdapter();
        adapter.addMovies(movies);
    }

    public void showError(Throwable throwable) {
        throwable.printStackTrace();
        Toast.makeText(getContext(), throwable.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

    private void onLoadingCompleted() {

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        subscription.unsubscribe();
    }
}
