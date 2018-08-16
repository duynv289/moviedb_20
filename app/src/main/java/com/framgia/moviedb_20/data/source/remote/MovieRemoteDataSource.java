package com.framgia.moviedb_20.data.source.remote;

import com.framgia.moviedb_20.BuildConfig;
import com.framgia.moviedb_20.data.api.BaseGetDataAsyncTask;
import com.framgia.moviedb_20.data.api.GetCategoryAsyncTask;
import com.framgia.moviedb_20.data.api.GetMovieCreditAsyncTask;
import com.framgia.moviedb_20.data.api.GetMovieDetailAsyncTask;
import com.framgia.moviedb_20.data.model.Category;
import com.framgia.moviedb_20.data.source.MovieDataSource;
import com.framgia.moviedb_20.utils.Constants;

public class MovieRemoteDataSource implements MovieDataSource.RemoteDataSource {


    @Override
    public void getMovies(String category, BaseGetDataAsyncTask.OnGetDataListener<Category> listener) {
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
        new GetCategoryAsyncTask(listener).execute(url.toString());
    }

    @Override
    public void getMovieDetail(int id,BaseGetDataAsyncTask.OnGetDataListener<Category> listener) {
        StringBuilder urlDetail = new StringBuilder(Constants.BLANK_STRING);
        urlDetail.append(Constants.DOMAIN);
        urlDetail.append(Constants.MOVIE_DETAIL);
        urlDetail.append(id);
        urlDetail.append(Constants.QUESTION_MARK);
        urlDetail.append(Constants.PARAM_KEY_API_KEY);
        urlDetail.append(BuildConfig.API_KEY);
        urlDetail.append(Constants.AND);
        urlDetail.append(Constants.LANGUAGE);
        urlDetail.append(Constants.VALUE_LANGUAGE);
        new GetMovieDetailAsyncTask(listener).execute(urlDetail.toString());
    }

    @Override
    public void getMovieCast(int id,BaseGetDataAsyncTask.OnGetDataListener<Category> listener) {
        StringBuilder urlCast = new StringBuilder(Constants.BLANK_STRING);
        urlCast.append(Constants.DOMAIN);
        urlCast.append(Constants.MOVIE_DETAIL);
        urlCast.append(id);
        urlCast.append(Constants.CREDITS);
        urlCast.append(Constants.QUESTION_MARK);
        urlCast.append(Constants.PARAM_KEY_API_KEY);
        urlCast.append(BuildConfig.API_KEY);
        new GetMovieCreditAsyncTask(listener).execute(urlCast.toString());
    }
}
