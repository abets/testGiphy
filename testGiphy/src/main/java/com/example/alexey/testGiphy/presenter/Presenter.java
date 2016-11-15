package com.example.alexey.testGiphy.presenter;

/**
 * Created by Alexey on 15.11.2016.
 */
public interface Presenter {
    void onSearchButtonClick();
    void onLoadTrendingGiphy();
    void onStop();
    void onClickGiphy(String path);
}
