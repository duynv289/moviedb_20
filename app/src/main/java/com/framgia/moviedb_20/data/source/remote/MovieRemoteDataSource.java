package com.framgia.moviedb_20.data.source.remote;

import com.framgia.moviedb_20.data.api.BaseGetDataAsyncTask;
import com.framgia.moviedb_20.data.api.GetCastDetailAsyncTask;
import com.framgia.moviedb_20.data.api.GetCategoryAsyncTask;
import com.framgia.moviedb_20.data.api.GetMovieCreditAsyncTask;
import com.framgia.moviedb_20.data.api.GetMovieDetailAsyncTask;
import com.framgia.moviedb_20.data.api.GetProducerAsyncTask;
import com.framgia.moviedb_20.data.source.MovieDataSource;

public class MovieRemoteDataSource implements MovieDataSource.RemoteDataSource {

    private BaseGetDataAsyncTask.OnGetDataListener mListener;

    public MovieRemoteDataSource(BaseGetDataAsyncTask.OnGetDataListener listener) {
        mListener = listener;
    }

    @Override
    public GetMovieCreditAsyncTask getMovieCredit() {
        return new GetMovieCreditAsyncTask(mListener);
    }

    @Override
    public GetMovieDetailAsyncTask getMovieDetail() {
        return new GetMovieDetailAsyncTask(mListener);
    }

    @Override
    public GetCategoryAsyncTask getCategory() {
        return new GetCategoryAsyncTask(mListener);
    }

    @Override
    public GetCastDetailAsyncTask getCast() {
        return new GetCastDetailAsyncTask(mListener);
    }


    @Override
    public GetProducerAsyncTask getProducer() {
        return new GetProducerAsyncTask(mListener);
    }
}
