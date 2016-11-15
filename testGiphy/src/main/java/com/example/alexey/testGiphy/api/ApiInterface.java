package com.example.alexey.testGiphy.api;

import com.example.alexey.testGiphy.Constants;
import com.example.alexey.testGiphy.model.data.DataGiphyItems;
import com.example.alexey.testGiphy.model.data.GiphyItem;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

import static com.example.alexey.testGiphy.Constants.GIPHY_API_KEY;

/**
 * Created by Alexey on 15.11.2016.
 */

public interface ApiInterface {

        @GET("v1/gifs/trending?api_key=dc6zaTOxFJmzC")
        Observable<DataGiphyItems> getGiphyTrending();

        @GET("v1/gifs/search")
        Observable<DataGiphyItems> getSearchGiphy(@Query("q") String key,@Query("api_key") String api_key);

}
