package com.framgia.moviedb_20.data.api;


import com.framgia.moviedb_20.data.model.MovieDetail;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetMovieDetailAsyncTask extends BaseGetDataAsyncTask<MovieDetail> {

    public GetMovieDetailAsyncTask(OnGetDataListener listener) {
        super(listener);
    }

    @Override
    protected List<MovieDetail> convertData(String strData){
        List<MovieDetail> result = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(strData);
            MovieDetail movie = new MovieDetail(jsonObject);
            result.add(movie);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }


}
