package com.framgia.moviedb_20.data.repository;

import com.framgia.moviedb_20.data.api.GetCastDetailAsyncTask;
import com.framgia.moviedb_20.data.api.GetCategoryAsyncTask;
import com.framgia.moviedb_20.data.api.GetMovieCreditAsyncTask;
import com.framgia.moviedb_20.data.api.GetMovieDetailAsyncTask;
import com.framgia.moviedb_20.data.api.GetProducerAsyncTask;
import com.framgia.moviedb_20.data.source.MovieDataSource;
import com.framgia.moviedb_20.data.source.remote.MovieRemoteDataSource;

public class MovieRepository implements MovieDataSource.RemoteDataSource, MovieDataSource.LocalDataSource {

    private MovieRemoteDataSource mMovieRemoteDataSource;

    public MovieRepository(MovieRemoteDataSource movieRemoteDataSource) {
        mMovieRemoteDataSource = movieRemoteDataSource;
    }

    @Override
    public GetMovieCreditAsyncTask getMovieCredit() {
        return mMovieRemoteDataSource.getMovieCredit();
    }

    @Override
    public GetMovieDetailAsyncTask getMovieDetail() {
        return mMovieRemoteDataSource.getMovieDetail();
    }

    @Override
    public GetCategoryAsyncTask getCategory() {
        return mMovieRemoteDataSource.getCategory();
    }

    @Override
    public GetCastDetailAsyncTask getCast() {
        return mMovieRemoteDataSource.getCast();
    }


    @Override
    public GetProducerAsyncTask getProducer() {
        return mMovieRemoteDataSource.getProducer();
    }
}
