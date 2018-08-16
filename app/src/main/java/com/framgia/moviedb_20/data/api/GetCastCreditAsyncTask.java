package com.framgia.moviedb_20.data.api;

import com.framgia.moviedb_20.data.model.CastCredit;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetCastCreditAsyncTask extends BaseGetDataAsyncTask<CastCredit> {

    public GetCastCreditAsyncTask(OnGetDataListener listener) {
        super(listener);
    }

    @Override
    protected List<CastCredit> convertData(String strData) {
        List<CastCredit> result = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(strData);
            CastCredit castCredit = new CastCredit(jsonObject);
            result.add(castCredit);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
}
