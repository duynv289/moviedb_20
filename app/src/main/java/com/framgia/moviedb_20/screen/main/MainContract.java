package com.framgia.moviedb_20.screen.main;


public interface MainContract {
    interface Presenter {
        void handleSearch();

        void handleNavigation();
    }

    interface View {
        void showSearchResult();

        void showDetail();
    }
}
