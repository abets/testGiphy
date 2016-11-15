package com.example.alexey.testGiphy.model;

import com.example.alexey.testGiphy.Constants;
import com.example.alexey.testGiphy.api.ApiInterface;
import com.example.alexey.testGiphy.api.ApiModule;
import com.example.alexey.testGiphy.model.data.DataGiphyItems;
import com.example.alexey.testGiphy.model.data.GiphyItem;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Alexey on 15.11.2016.
 */

public class ModelImpl implements Model {

    ApiInterface apiInterface = ApiModule.getApiInterface();

    @Override
    public Observable<DataGiphyItems> getGiphyTrending() {
        return apiInterface.getGiphyTrending()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<DataGiphyItems> getSearchGiphy(String key) {
        return apiInterface.getSearchGiphy(key, Constants.GIPHY_API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
