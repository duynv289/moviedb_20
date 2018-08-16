package com.framgia.moviedb_20.data.source;

public interface MovieDataSource {

    interface LocalDataSource {

    }

    interface RemoteDataSource {
        void getMovies(String category);

        void getMovieDetail(int id);

        void getMovieCast(int id);
    }
}
