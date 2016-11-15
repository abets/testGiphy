package com.example.alexey.testGiphy.model;

import com.example.alexey.testGiphy.model.data.DataGiphyItems;
import com.example.alexey.testGiphy.model.data.GiphyItem;

import java.util.List;

import rx.Observable;

/**
 * Created by Alexey on 15.11.2016.
 */

public interface Model {
    Observable<DataGiphyItems> getGiphyTrending();
    Observable<DataGiphyItems> getSearchGiphy(String key);
}