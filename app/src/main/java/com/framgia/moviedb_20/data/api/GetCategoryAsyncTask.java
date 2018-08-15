package com.framgia.moviedb_20.data.api;

import android.util.Log;

import com.framgia.moviedb_20.data.model.Category;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetCategoryAsyncTask extends BaseGetDataAsyncTask<Category> {
    public GetCategoryAsyncTask(OnGetDataListener listener) {
        super(listener);
    }

    @Override
    protected List<Category> convertData(String strData) {
        List<Category> result = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(strData);
            Category category = new Category(jsonObject);
            result.add(category);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
}
