package com.framgia.moviedb_20.screen.main.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.framgia.moviedb_20.R;
import com.framgia.moviedb_20.data.api.BaseGetDataAsyncTask;
import com.framgia.moviedb_20.data.model.BaseMovie;
import com.framgia.moviedb_20.data.model.Category;
import com.framgia.moviedb_20.data.repository.MovieRepository;
import com.framgia.moviedb_20.data.source.remote.MovieRemoteDataSource;
import com.framgia.moviedb_20.screen.adapter.MovieAdapter;
import com.framgia.moviedb_20.screen.adapter.OnItemClickListener;
import com.framgia.moviedb_20.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements HomeContract.View, OnItemClickListener {

    private static OnMovieSelectedListener sOnMovieSelectedListener;
    private HomePresenter mPresenter;
    private List<Category> mCategories;
    private RecyclerView mRecyclerViewUpComing, mRecyclerViewNowPlaying;
    private RecyclerView mRecyclerViewTopRated, mRecyclerViewPopular;
    private MovieAdapter mMovieAdapter;
    private ProgressBar mProgressBar;

    private static final int TAG_UPCOMING = 0;
    private static final int TAG_TOP_RATED = 1;
    private static final int TAG_POPULAR = 2;
    private static final int TAG_NOW_PLAYING = 3;

    public static HomeFragment getNewInstance(OnMovieSelectedListener onMovieSelectedListener) {
        sOnMovieSelectedListener = onMovieSelectedListener;
        return new HomeFragment();
    }

    @Override
    public void onAttach(Context context) throws ClassCastException {
        super.onAttach(context);
        sOnMovieSelectedListener = (OnMovieSelectedListener) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MovieRemoteDataSource remoteDataSource = new MovieRemoteDataSource();
        MovieRepository repository = new MovieRepository(remoteDataSource);
        mPresenter = new HomePresenter(repository);
        mPresenter.setView(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mRecyclerViewUpComing = view.findViewById(R.id.recycler_category_upcoming);
        mRecyclerViewTopRated = view.findViewById(R.id.recycler_category_top_rated);
        mRecyclerViewPopular = view.findViewById(R.id.recycler_category_popular);
        mRecyclerViewNowPlaying = view.findViewById(R.id.recycler_category_now_playing);
        mProgressBar = view.findViewById(R.id.progress_upcoming);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.loadMovies(Constants.UPCOMING,TAG_UPCOMING);
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
        super.onStop();
    }

    @Override
    public void showMovieSuccess(List<Category> data) {
        List<BaseMovie> baseMovies = new ArrayList<>();
        for (Category category : data) {
            baseMovies.addAll(category.getBaseMovie());
        }

        mMovieAdapter = new MovieAdapter(baseMovies);
        mMovieAdapter.onItemClickListener(this);
        switch (mPresenter.getTag()){
            case  TAG_UPCOMING :
                mRecyclerViewUpComing.setAdapter(mMovieAdapter);
                mPresenter.loadMovies(Constants.TOP_RATED, TAG_TOP_RATED);
                break;
            case TAG_TOP_RATED:
                mRecyclerViewTopRated.setAdapter(mMovieAdapter);
                mPresenter.loadMovies(Constants.POPULAR, TAG_POPULAR);
                break;
            case TAG_POPULAR :
                mRecyclerViewPopular.setAdapter(mMovieAdapter);
                mPresenter.loadMovies(Constants.NOW_PLAYING, TAG_NOW_PLAYING);
                break;
            case TAG_NOW_PLAYING:
                mRecyclerViewNowPlaying.setAdapter(mMovieAdapter);
                break;
        }
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void OnItemClick(int id) {
        sOnMovieSelectedListener.setOnMovieSelected(id);
    }

    public interface OnMovieSelectedListener {
        void setOnMovieSelected(int id);
    }
}
