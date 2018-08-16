package com.framgia.moviedb_20.data.source;

import com.framgia.moviedb_20.data.api.BaseGetDataAsyncTask;
import com.framgia.moviedb_20.data.model.Category;

public interface MovieDataSource {

    interface LocalDataSource {

    }

    interface RemoteDataSource {
        void getMovies(String category, BaseGetDataAsyncTask.OnGetDataListener<Category> listener);

        void getMovieDetail(int id, BaseGetDataAsyncTask.OnGetDataListener<Category> listener);

        void getMovieCast(int id, BaseGetDataAsyncTask.OnGetDataListener<Category> listener);
    }
}
