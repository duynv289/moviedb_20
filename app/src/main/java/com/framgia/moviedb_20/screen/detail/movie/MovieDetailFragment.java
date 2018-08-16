package com.framgia.moviedb_20.screen.detail.movie;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.framgia.moviedb_20.R;
import com.framgia.moviedb_20.data.api.BaseGetDataAsyncTask;
import com.framgia.moviedb_20.data.model.MovieCast;
import com.framgia.moviedb_20.data.model.MovieDetail;
import com.framgia.moviedb_20.data.model.Producer;
import com.framgia.moviedb_20.data.repository.MovieRepository;
import com.framgia.moviedb_20.data.source.remote.MovieRemoteDataSource;
import com.framgia.moviedb_20.screen.adapter.CastAdapter;
import com.framgia.moviedb_20.screen.adapter.OnItemClickListener;
import com.framgia.moviedb_20.screen.adapter.ProducerAdapter;
import com.framgia.moviedb_20.utils.Constants;
import com.framgia.moviedb_20.utils.ViewUtils;

import java.util.List;

public class MovieDetailFragment extends Fragment implements View.OnClickListener,MovieDetailContract.View, BaseGetDataAsyncTask.OnGetDataListener, OnItemClickListener {

    private static final String PARAM_M = "m";
    private static int mId;
    private List<MovieCast> mMovieCasts;
    private List<Producer> mProducers;
    private CastAdapter mCastAdapter;
    private ProducerAdapter mProducerAdapter;
    private List<MovieDetail> mMovieDetails;
    private ImageView mImageView;
    private TextView mTextViewFilmName;
    private TextView mTextViewReleaseYear;
    private TextView mTextViewRunTime;
    private TextView mTextViewVoteAverage;
    private ImageButton mButtonAddFavorite;
    private ImageButton mButtonVote;
    private ImageButton mButtonPlay;
    private TextView mTextViewOverview;
    private TextView mTextViewProducers;
    private TextView mTextViewReleaseDate;
    private TextView mTextViewGenres;
    private TextView mTextViewCasts;
    private RecyclerView mRecyclerViewCast;
    private RecyclerView mRecyclerViewProducer;
    private MovieDetailContract.Presenter mPresenter;

    public static MovieDetailFragment getNewInstance(int id) {
        mId = id;
        return new MovieDetailFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MovieRemoteDataSource remoteDataSource = new MovieRemoteDataSource(this);
        MovieRepository repository = new MovieRepository(remoteDataSource);
        mPresenter = new MovieDetailPresenter(repository);
        mPresenter.setView(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mImageView = view.findViewById(R.id.image_film_backdrop);
        mTextViewFilmName = view.findViewById(R.id.text_film_name);
        mTextViewReleaseYear = view.findViewById(R.id.text_release_year);
        mTextViewRunTime = view.findViewById(R.id.text_run_time);
        mTextViewVoteAverage = view.findViewById(R.id.text_vote_average);
        mButtonAddFavorite = view.findViewById(R.id.button_add_favorite);
        mButtonVote = view.findViewById(R.id.button_vote);
        mButtonPlay = view.findViewById(R.id.button_play);
        mTextViewOverview = view.findViewById(R.id.text_overview);
        mTextViewProducers = view.findViewById(R.id.text_producers);
        mTextViewReleaseDate = view.findViewById(R.id.text_release_date);
        mTextViewGenres = view.findViewById(R.id.text_genres);
        mTextViewCasts = view.findViewById(R.id.text_casts);
        mRecyclerViewCast = view.findViewById(R.id.recycler_cast);
        mRecyclerViewProducer = view.findViewById(R.id.recycler_producer);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.loadMovies(mId);
    }

    @Override
    public void onGetDataSuccess(List data) {
        if (data.get(0) instanceof MovieDetail) {
            setMovieDetail(data);
            mPresenter.loadMovies(mId);
        } else if (data.get(0) instanceof MovieCast) {
            mMovieCasts = data;
            mPresenter.loadCastName(data);
            mCastAdapter = new CastAdapter(mMovieCasts);
            mRecyclerViewCast.setAdapter(mCastAdapter);
            mCastAdapter.onItemClickListener(this);
        }
    }

    @Override
    public void onGetDataFailure(Exception e) {

    }


    @Override
    public void showBackdrop(String backdropPath) {
        ViewUtils.loadImageByUrl(mImageView, Constants.DOMAIN_POSTER_IMAGE + backdropPath);
    }

    @Override
    public void showFilmName(String filmName) {
        mTextViewFilmName.setText(filmName);
    }

    @Override
    public void showReleaseDate(String releaseDate) {
        mTextViewReleaseYear.setText(releaseDate);
        mTextViewReleaseDate.setText(Constants.STRING_COLON + releaseDate);
    }

    @Override
    public void showRunTime(int runTime) {
        mTextViewRunTime.setText(runTime + PARAM_M);
    }

    @Override
    public void showVoteAverage(String voteAverage) {
        mTextViewVoteAverage.setText(voteAverage);
    }

    @Override
    public void showOverview(String overview) {
        mTextViewOverview.setText(overview);
    }

    @Override
    public void showGenres(String genre) {
        mTextViewGenres.setText(genre);
    }

    @Override
    public void showCasts(String cast) {
        mTextViewCasts.setText(cast);
        mTextViewCasts.setOnClickListener(this);
    }

    @Override
    public void showProducers(String producers) {
        mTextViewProducers.setText(producers);
    }

    private void setMovieDetail(List data) {
        mMovieDetails = data;
        MovieDetail movieDetail = mMovieDetails.get(0);
        mProducers = movieDetail.getProducers();
        showOverview(movieDetail.getOverview());
        showBackdrop(movieDetail.getBackdropPath());
        showFilmName(movieDetail.getTitle());
        showReleaseDate(movieDetail.getReleaseDate());
        showRunTime(movieDetail.getRunTime());
        showVoteAverage(String.valueOf(movieDetail.getVoteAverage()));
        mPresenter.loadGenres(movieDetail.getGenres());
        mPresenter.loadProducers(mProducers);
        mProducerAdapter = new ProducerAdapter(mProducers);
        mRecyclerViewProducer.setAdapter(mProducerAdapter);
        mProducerAdapter.onItemClickListener(this);
    }

    @Override
    public void OnItemClick(int id) {

    }

    @Override
    public void onClick(View view) {
        mTextViewCasts.setMaxLines(Constants.MAX_LINES);
    }
}
