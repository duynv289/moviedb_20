package com.framgia.moviedb_20.data.model;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Cast{
    private int mPage;
    private String mBirthday;
    private String mKnowForDepartment;
    private int mId;
    private String mName;
    private String mBiography;
    private String mPlaceOfBirth;
    private String mProfilePath;
    private BaseMovie mBaseMovie;
    public Cast() {
    }

    public Cast(JSONObject jsonObject) throws JSONException {
        mPage = jsonObject.optInt(JsonKey.PAGE);
        JSONArray resultsArray = jsonObject.optJSONArray(JsonKey.RESULTS);
        for (int i = 0; i < resultsArray.length(); i++) {
            JSONObject result = resultsArray.optJSONObject(i);
            mId = result.optInt(JsonKey.ID);
            mName = result.optString(JsonKey.NAME);
            mBirthday = result.optString(JsonKey.BIRTHDAY);
            mKnowForDepartment = result.optString(JsonKey.KNOW_FOR_DEPARTMENT);
            mBiography = result.optString(JsonKey.BIOGRAPHY);
            mPlaceOfBirth = result.optString(JsonKey.PLACE_OF_BIRTH);
            mProfilePath = result.optString(JsonKey.PROFILE_PATH);
            JSONArray movies = result.optJSONArray(JsonKey.KNOWN_FOR);
            for (int j = 0; j < movies.length(); j++) {
                JSONObject movieObject = movies.optJSONObject(j);
                mBaseMovie = new BaseMovie(movieObject);
                JSONArray IdArray = movieObject.optJSONArray(MovieDetail.JsonKey.GENRE_ID);
                for(int k=0;k<IdArray.length();k++){
                    List<Integer> listId = new ArrayList<>();
                    listId.add(IdArray.getInt(k));
                }
            }
        }
    }

    public String getBirthday() {
        return mBirthday;
    }

    public void setBirthday(String birthday) {
        mBirthday = birthday;
    }

    public String getKnowForDepartment() {
        return mKnowForDepartment;
    }

    public void setKnowForDepartment(String knowForDepartment) {
        mKnowForDepartment = knowForDepartment;
    }


    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getBiography() {
        return mBiography;
    }

    public void setBiography(String biography) {
        mBiography = biography;
    }

    public String getPlaceOfBirth() {
        return mPlaceOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        mPlaceOfBirth = placeOfBirth;
    }

    public String getProfilePath() {
        return mProfilePath;
    }

    public void setProfilePath(String profilePath) {
        mProfilePath = profilePath;
    }

    public int getPage() {
        return mPage;
    }

    public void setPage(int page) {
        mPage = page;
    }


    @Override
    public String toString() {
        return "Cast{" +
                "mPage=" + mPage +
                ", mBirthday='" + mBirthday + '\'' +
                ", mKnowForDepartment='" + mKnowForDepartment + '\'' +
                ", mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mBiography='" + mBiography + '\'' +
                ", mPlaceOfBirth='" + mPlaceOfBirth + '\'' +
                ", mProfilePath='" + mProfilePath + '\'' +
                '}';
    }




    public static class JsonKey extends BaseJsonKey {
        public static final String PAGE = "page";
        public static final String RESULTS = "results";
        public static final String BIRTHDAY = "birthday";
        public static final String KNOW_FOR_DEPARTMENT = "known_for_department";
        public static final String BIOGRAPHY = "biography";
        public static final String PLACE_OF_BIRTH = "place_of_birth";
        public static final String PROFILE_PATH = "profile_path";
        public static final String KNOWN_FOR = "known_for";
    }
}
