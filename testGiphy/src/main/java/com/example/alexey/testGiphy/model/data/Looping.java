package com.example.alexey.testGiphy.model.data;

/**
 * Created by Alexey on 15.11.2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Looping {

    @SerializedName("mp4")
    @Expose
    private String mp4;

    /**
     *
     * @return
     * The mp4
     */
    public String getMp4() {
        return mp4;
    }

    /**
     *
     * @param mp4
     * The mp4
     */
    public void setMp4(String mp4) {
        this.mp4 = mp4;
    }

}