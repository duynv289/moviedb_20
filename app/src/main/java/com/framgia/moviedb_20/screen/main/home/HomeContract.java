package com.framgia.moviedb_20.screen.main.home;

import com.framgia.moviedb_20.data.model.Category;
import com.framgia.moviedb_20.screen.BasePresenter;

import java.util.List;

public interface HomeContract {

    interface View {

        void showMovieSuccess(List<Category> data);

        void showProgress();

        void hideProgress();
    }

    interface Presenter extends BasePresenter<View> {

        void loadMovies(String category, int tag);

    }
}
