package com.example.alexey.testGiphy.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Alexey on 15.11.2016.
 */

public class DataGiphyItems {

    @SerializedName("data")
    @Expose
    private List<GiphyItem> data;
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;

    public List<GiphyItem> getGiphyData() {
        return data;
    }

    public void setGiphyData(List<GiphyItem> data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }


    public class Meta {
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("msg")
        @Expose
        private String msg;
    }

    public class Pagination {
        @SerializedName("total_count")
        @Expose
        private int total_count;
        @SerializedName("count")
        @Expose
        private int count;
        @SerializedName("offset")
        @Expose
        private int offset;
    }
}
