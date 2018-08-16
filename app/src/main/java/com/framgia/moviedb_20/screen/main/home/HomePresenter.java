package com.framgia.moviedb_20.screen.main.home;

import com.framgia.moviedb_20.data.api.BaseGetDataAsyncTask;
import com.framgia.moviedb_20.data.model.Category;
import com.framgia.moviedb_20.data.repository.MovieRepository;

import java.util.List;

public class HomePresenter implements HomeContract.Presenter, BaseGetDataAsyncTask.OnGetDataListener<Category> {

    private MovieRepository mMovieRepository;
    private HomeContract.View mView;

    private int mTag;

    public HomePresenter(MovieRepository movieRepository) {
        mMovieRepository = movieRepository;
    }

    @Override
    public void onStart() {
        // TODO: 22/08/2018  
    }

    @Override
    public void onStop() {
        // TODO: 22/08/2018  
    }

    @Override
    public void setView(HomeContract.View view) {
        mView = view;
    }

    public int getTag() {
        return mTag;
    }

    @Override
    public void loadMovies(String category, int tag) {
        mView.showProgress();
        mTag = tag;
        mMovieRepository.getMovies(category,this);
    }

    @Override
    public void onGetDataSuccess(List<Category> data) {
        mView.hideProgress();
        mView.showMovieSuccess(data);
    }

    @Override
    public void onGetDataFailure(Exception e) {
        // TODO: 22/08/2018
    }
}
