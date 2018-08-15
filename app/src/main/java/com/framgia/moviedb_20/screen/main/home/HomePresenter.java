package com.framgia.moviedb_20.screen.main.home;

import com.framgia.moviedb_20.data.repository.MovieRepository;

public class HomePresenter implements HomeContract.Presenter {

    private MovieRepository mMovieRepository;
    private HomeContract.View mView;

    private static final int INDEX_ZERO = 0;
    private static final int INDEX_ONE = 1;
    private static final int INDEX_TWO = 2;
    private static final int INDEX_THREE = 3;

    private int mTag;

    public HomePresenter(MovieRepository movieRepository) {
        mMovieRepository = movieRepository;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void setView(HomeContract.View view) {
        mView = view;
    }

    @Override
    public void setAdapter(int tag) {
        switch (tag){
            case INDEX_ZERO:
                mView.showUpComing();
                loadTopRated(INDEX_ONE);
                break;
            case INDEX_ONE:
                mView.showTopRated();
                loadPopular(INDEX_TWO);
                break;
            case INDEX_TWO:
                mView.showPopular();
                loadNowPlaying(INDEX_THREE);
                break;
            case INDEX_THREE:
                mView.showNowPlaying();
                break;
        }
    }

    @Override
    public void loadUpComing(int tag) {
        mView.showProgress();
        mTag = tag;
        mMovieRepository.getCategory().execute(
                "https://api.themoviedb.org/3/movie/upcoming?api_key=3956f50a726a2f785334c24759b97dc6&language=en-US&page=1");
    }

    @Override
    public void loadPopular(int tag) {
        mTag = tag;
        mMovieRepository.getCategory().execute(
                "https://api.themoviedb.org/3/movie/popular?api_key=3956f50a726a2f785334c24759b97dc6&language=en-US&page=1");
    }

    @Override
    public void loadNowPlaying(int tag) {
        mTag = tag;
        mMovieRepository.getCategory().execute(
                "https://api.themoviedb.org/3/movie/now_playing?api_key=3956f50a726a2f785334c24759b97dc6&language=en-US&page=1");
    }

    @Override
    public void loadTopRated(int tag) {
        mTag = tag;
        mMovieRepository.getCategory().execute(
                "https://api.themoviedb.org/3/movie/top_rated?api_key=3956f50a726a2f785334c24759b97dc6&language=en-US&page=1");
    }

    public int getTag() {
        return mTag;
    }
}
