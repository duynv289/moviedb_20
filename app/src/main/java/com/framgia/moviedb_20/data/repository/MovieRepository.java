package com.framgia.moviedb_20.data.repository;

import com.framgia.moviedb_20.data.source.MovieDataSource;
import com.framgia.moviedb_20.data.source.remote.MovieRemoteDataSource;

public class MovieRepository implements MovieDataSource.RemoteDataSource, MovieDataSource.LocalDataSource {

    private MovieRemoteDataSource mMovieRemoteDataSource;

    public MovieRepository(MovieRemoteDataSource movieRemoteDataSource) {
        mMovieRemoteDataSource = movieRemoteDataSource;
    }

    @Override
    public void getMovies(String category) {
        mMovieRemoteDataSource.getMovies(category);
    }

    @Override
    public void getMovieDetail(int id) {
        mMovieRemoteDataSource.getMovieDetail(id);
    }

    @Override
    public void getMovieCast(int id) {
        mMovieRemoteDataSource.getMovieCast(id);
    }
}
