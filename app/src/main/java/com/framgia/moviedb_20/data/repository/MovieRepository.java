package com.framgia.moviedb_20.data.repository;

import com.framgia.moviedb_20.data.api.BaseGetDataAsyncTask;
import com.framgia.moviedb_20.data.model.Category;
import com.framgia.moviedb_20.data.source.MovieDataSource;
import com.framgia.moviedb_20.data.source.remote.MovieRemoteDataSource;

import java.util.List;

public class MovieRepository implements MovieDataSource.RemoteDataSource, MovieDataSource.LocalDataSource, BaseGetDataAsyncTask.OnGetDataListener<Category> {

    private MovieRemoteDataSource mMovieRemoteDataSource;

    public MovieRepository(MovieRemoteDataSource movieRemoteDataSource) {
        mMovieRemoteDataSource = movieRemoteDataSource;
    }

    @Override
    public void getMovies(String category, BaseGetDataAsyncTask.OnGetDataListener<Category> listener) {
        mMovieRemoteDataSource.getMovies(category,this);
    }

    @Override
    public void getMovieDetail(int id, BaseGetDataAsyncTask.OnGetDataListener<Category> listener) {
        mMovieRemoteDataSource.getMovieDetail(id,this);
    }

    @Override
    public void getMovieCast(int id, BaseGetDataAsyncTask.OnGetDataListener<Category> listener) {
        mMovieRemoteDataSource.getMovieDetail(id,this);
    }

    @Override
    public void onGetDataSuccess(List<Category> data) {
        // TODO: 22/08/2018  
    }

    @Override
    public void onGetDataFailure(Exception e) {
        // TODO: 22/08/2018  
    }
}
