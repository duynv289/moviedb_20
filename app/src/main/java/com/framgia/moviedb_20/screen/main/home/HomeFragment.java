package com.framgia.moviedb_20.screen.main.home;

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
import com.framgia.moviedb_20.data.model.Category;
import com.framgia.moviedb_20.data.repository.MovieRepository;
import com.framgia.moviedb_20.data.source.remote.MovieRemoteDataSource;
import com.framgia.moviedb_20.screen.detail.movie.MovieDetailFragment;
import com.framgia.moviedb_20.screen.main.MainActivity;
import com.framgia.moviedb_20.screen.adapter.MovieAdapter;
import com.framgia.moviedb_20.screen.adapter.OnItemClickListener;

import java.util.List;

public class HomeFragment extends Fragment implements HomeContract.View, BaseGetDataAsyncTask.OnGetDataListener<Category>, OnItemClickListener {

    private HomePresenter mPresenter;
    private List<Category> mCategories;
    private RecyclerView mRecyclerViewUpComing, mRecyclerViewNowPlaying, mRecyclerViewTopRated, mRecyclerViewPopular;
    private MovieAdapter mMovieAdapter;
    private ProgressBar mProgressBar;

    public static HomeFragment getNewInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MovieRemoteDataSource remoteDataSource = new MovieRemoteDataSource(this);
        MovieRepository repository = new MovieRepository(remoteDataSource);
        mPresenter = new HomePresenter(repository);
        mPresenter.setView(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
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
        mPresenter.loadUpComing(0);
    }

    @Override
    public void onGetDataSuccess(List<Category> data) {
        mCategories = data;
        mPresenter.setAdapter(mPresenter.getTag());
        hideProgress();
    }

    @Override
    public void onGetDataFailure(Exception e) {
        // TODO: 13/08/2018
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
    public void showUpComing() {
        mMovieAdapter = new MovieAdapter(mCategories.get(0).getBaseMovie());
        mRecyclerViewUpComing.setAdapter(mMovieAdapter);
        mMovieAdapter.onItemClickListener(this);
    }

    @Override
    public void showPopular() {
        mMovieAdapter = new MovieAdapter(mCategories.get(0).getBaseMovie());
        mRecyclerViewPopular.setAdapter(mMovieAdapter);
        mMovieAdapter.onItemClickListener(this);
    }

    @Override
    public void showNowPlaying() {
        mMovieAdapter = new MovieAdapter(mCategories.get(0).getBaseMovie());
        mRecyclerViewNowPlaying.setAdapter(mMovieAdapter);
        mMovieAdapter.onItemClickListener(this);
    }

    @Override
    public void showTopRated() {
        mMovieAdapter = new MovieAdapter(mCategories.get(0).getBaseMovie());
        mRecyclerViewTopRated.setAdapter(mMovieAdapter);
        mMovieAdapter.onItemClickListener(this);
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
        if (getActivity() != null) {
            ((MainActivity) getActivity()).replaceFragment(MovieDetailFragment.getNewInstance(id));
        }
    }


}
