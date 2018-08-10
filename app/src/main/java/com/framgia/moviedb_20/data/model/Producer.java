package com.framgia.moviedb_20.data.model;

import org.json.JSONObject;

public class Producer {
    private String mHeadquarter;
    private String mHomepage;
    private int mId;
    private String mLogo_path;
    private String mName;
    private String mOrigin_country;

    public Producer() {
    }

    public Producer(JSONObject jsonObject) {
        mId = jsonObject.optInt(JsonKey.ID);
        mName = jsonObject.optString(JsonKey.NAME);
        mHeadquarter = jsonObject.optString(JsonKey.HEADQUARTERS);
        mHomepage = jsonObject.optString(JsonKey.HOMEPAGE);
        mLogo_path = jsonObject.optString(JsonKey.LOGO_PATH);
        mOrigin_country = jsonObject.optString(JsonKey.ORIGIN_COUNTRY);
    }


    public String getHeadquarter() {
        return mHeadquarter;
    }

    public void setHeadquarter(String headquarter) {
        mHeadquarter = headquarter;
    }

    public String getHomepage() {
        return mHomepage;
    }

    public void setHomepage(String homepage) {
        mHomepage = homepage;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getLogo_path() {
        return mLogo_path;
    }

    public void setLogo_path(String logo_path) {
        mLogo_path = logo_path;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getOrigin_country() {
        return mOrigin_country;
    }

    public void setOrigin_country(String origin_country) {
        mOrigin_country = origin_country;
    }


    @Override
    public String toString() {
        return "Producer{" +
                "mHeadquarter='" + mHeadquarter + '\'' +
                ", mHomepage='" + mHomepage + '\'' +
                ", mId=" + mId +
                ", mLogo_path='" + mLogo_path + '\'' +
                ", mName='" + mName + '\'' +
                ", mOrigin_country='" + mOrigin_country + '\'' +
                '}';
    }

    public static class JsonKey extends BaseJsonKey {
        public static final String HEADQUARTERS = "headquarters";
        public static final String HOMEPAGE = "homepage";
        public static final String LOGO_PATH = "logo_path";
        public static final String ORIGIN_COUNTRY = "origin_country";

    }
}
