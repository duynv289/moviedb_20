package com.framgia.moviedb_20.screen.detail.movie;

import com.framgia.moviedb_20.data.model.Genre;
import com.framgia.moviedb_20.data.model.MovieCast;
import com.framgia.moviedb_20.data.model.Producer;
import com.framgia.moviedb_20.screen.BasePresenter;

import java.util.List;

public interface MovieDetailContract {
    interface View {

        void showBackdrop(String backdropPath);

        void showFilmName(String filmName);

        void showReleaseDate(String releaseDate);

        void showRunTime(int runTime);

        void showVoteAverage(String voteAverage);

        void showOverview(String overview);

        void showGenres(String genre);

        void showCasts(String cast);

        void showProducers(String producers);

    }

    interface Presenter extends BasePresenter<View> {

        void loadGenres(List<Genre> genreList);

        void loadCastName(List<MovieCast> movieCasts);

        void loadMovies(int id);

        void loadProducers(List<Producer> producerList);
    }
}
