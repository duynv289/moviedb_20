package com.framgia.moviedb_20.data.api;


import com.framgia.moviedb_20.data.model.Producer;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetProducerAsyncTask extends BaseGetDataAsyncTask<Producer> {


    public GetProducerAsyncTask(OnGetDataListener listener) {
        super(listener);
    }

    @Override
    protected List<Producer> convertData(String strData) {
        List<Producer> result = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(strData);
            Producer producer = new Producer(jsonObject);
            result.add(producer);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
}
