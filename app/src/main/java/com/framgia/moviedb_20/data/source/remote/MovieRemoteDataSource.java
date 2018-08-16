package com.framgia.moviedb_20.data.source.remote;

import com.framgia.moviedb_20.BuildConfig;
import com.framgia.moviedb_20.data.api.BaseGetDataAsyncTask;
import com.framgia.moviedb_20.data.api.GetCastDetailAsyncTask;
import com.framgia.moviedb_20.data.api.GetCategoryAsyncTask;
import com.framgia.moviedb_20.data.api.GetMovieCreditAsyncTask;
import com.framgia.moviedb_20.data.api.GetMovieDetailAsyncTask;
import com.framgia.moviedb_20.data.api.GetProducerAsyncTask;
import com.framgia.moviedb_20.data.source.MovieDataSource;
import com.framgia.moviedb_20.utils.Constants;

public class MovieRemoteDataSource implements MovieDataSource.RemoteDataSource {

    private BaseGetDataAsyncTask.OnGetDataListener mListener;

    public MovieRemoteDataSource(BaseGetDataAsyncTask.OnGetDataListener listener) {
        mListener = listener;
    }

    @Override
    public void getMovies(String category) {
        StringBuilder url = new StringBuilder(Constants.BLANK_STRING);
        url.append(Constants.DOMAIN);
        url.append(Constants.MOVIE_DETAIL);
        url.append(category);
        url.append(Constants.QUESTION_MARK);
        url.append(Constants.PARAM_KEY_API_KEY);
        url.append(BuildConfig.API_KEY);
        url.append(Constants.AND);
        url.append(Constants.LANGUAGE);
        url.append(Constants.VALUE_LANGUAGE);
        url.append(Constants.AND);
        url.append(Constants.PAGE);
        url.append(Constants.PAGE_NUMBER);
        new GetCategoryAsyncTask(mListener).execute(url.toString());
    }

    @Override
    public void getMovieDetail(int id) {
        StringBuilder url_detail = new StringBuilder(Constants.BLANK_STRING);
        url_detail.append(Constants.DOMAIN);
        url_detail.append(Constants.MOVIE_DETAIL);
        url_detail.append(id);
        url_detail.append(Constants.QUESTION_MARK);
        url_detail.append(Constants.PARAM_KEY_API_KEY);
        url_detail.append(BuildConfig.API_KEY);
        url_detail.append(Constants.AND);
        url_detail.append(Constants.LANGUAGE);
        url_detail.append(Constants.VALUE_LANGUAGE);
        new GetMovieDetailAsyncTask(mListener).execute(url_detail.toString());
    }

    @Override
    public void getMovieCast(int id) {
        StringBuilder url_credit = new StringBuilder(Constants.BLANK_STRING);
        url_credit.append(Constants.DOMAIN);
        url_credit.append(Constants.MOVIE_DETAIL);
        url_credit.append(id);
        url_credit.append(Constants.CREDITS);
        url_credit.append(Constants.QUESTION_MARK);
        url_credit.append(Constants.PARAM_KEY_API_KEY);
        url_credit.append(BuildConfig.API_KEY);
        new GetMovieCreditAsyncTask(mListener).execute(url_credit.toString());
    }

}
