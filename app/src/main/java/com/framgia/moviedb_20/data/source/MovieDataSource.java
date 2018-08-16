package com.framgia.moviedb_20.data.source;

import com.framgia.moviedb_20.data.api.GetCastDetailAsyncTask;
import com.framgia.moviedb_20.data.api.GetCategoryAsyncTask;
import com.framgia.moviedb_20.data.api.GetMovieCreditAsyncTask;
import com.framgia.moviedb_20.data.api.GetMovieDetailAsyncTask;
import com.framgia.moviedb_20.data.api.GetProducerAsyncTask;

public interface MovieDataSource {

    interface LocalDataSource {

    }

    interface RemoteDataSource {

        GetMovieCreditAsyncTask getMovieCredit();

        GetMovieDetailAsyncTask getMovieDetail();

        GetCategoryAsyncTask getCategory();

        GetCastDetailAsyncTask getCast();

        GetProducerAsyncTask getProducer();
    }
}
