package com.framgia.moviedb_20.data.api;


import com.framgia.moviedb_20.data.model.Cast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetCastAsyncTask extends BaseGetDataAsyncTask<Cast> {

    public GetCastAsyncTask(OnGetDataListener listener) {
        super(listener);
    }

    @Override
    protected List<Cast> convertData(String strData) {
        List<Cast> result = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(strData);
            Cast cast = new Cast(jsonObject);
            result.add(cast);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
}
