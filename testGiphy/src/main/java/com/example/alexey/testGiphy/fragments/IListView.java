package com.example.alexey.testGiphy.fragments;

import com.example.alexey.testGiphy.model.data.DataGiphyItems;

/**
 * Created by Alexey on 15.11.2016.
 */

public interface IListView extends IView{

    void showEmptyList();

    String getSearchKey();

    void showData(DataGiphyItems list);

    void showFragmentAnim(String path);
}
