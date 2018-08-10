package com.framgia.moviedb_20.data.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MovieDetail extends BaseMovie{

    public MovieDetail(JSONObject jsonObject) throws JSONException {
        super(jsonObject);
        List<Genre> genreList = new ArrayList<>();

        JSONArray genres = jsonObject.optJSONArray(JsonKey.GENRE);
        for(int i=0;i<genres.length();i++){
            JSONObject genreObject = genres.optJSONObject(i);
            genreList.add(new Genre(genreObject));
        }
        JSONArray producers = jsonObject.optJSONArray(JsonKey.PRODUCER);
        List<Producer> producerList = new ArrayList<>();
        for (int j = 0; j < producers.length(); j++) {
            JSONObject producerObject = producers.optJSONObject(j);
            producerList.add(new Producer(producerObject));
        }
    }

    public static class JsonKey extends BaseJsonKey {
        public static final String GENRE = "genres";
        public static final String GENRE_ID = "genre_ids";
        public static final String PRODUCER = "production_companies";
    }
}
