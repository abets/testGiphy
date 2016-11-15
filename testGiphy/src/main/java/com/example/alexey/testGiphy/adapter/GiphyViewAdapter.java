package com.example.alexey.testGiphy.adapter;

import android.text.TextUtils;

import com.example.alexey.testGiphy.model.data.GiphyItem;
import com.example.alexey.testGiphy.presenter.Presenter;

import java.util.List;

/**
 * Created by Alexey on 15.11.2016.
 */

public class GiphyViewAdapter extends BaseAdapter<GiphyItem> {

    private static String TITLE_NAME = "Giphy - ";

    private Presenter presenter;

    public GiphyViewAdapter(List<GiphyItem> list, Presenter presenter) {
        super(list);
        this.presenter = presenter;
    }

    @Override
    public void onBindViewHolder(BaseAdapter.ViewHolder viewHolder, int i) {
        GiphyItem giphyItem = list.get(i);
        viewHolder.text.setText(TITLE_NAME + giphyItem.getId());

        viewHolder.text.setOnClickListener(v ->
            {
                if(giphyItem.getImages()!=null&&
                        giphyItem.getImages().getDownsized()!=null&&
                        !TextUtils.isEmpty(giphyItem.getImages().getDownsized().getUrl())) {
                    presenter.onClickGiphy(giphyItem.getImages().getDownsized().getUrl());
                }
            });
    }

    public void setGiphyList(List<GiphyItem> list) {
        this.list = list;
        notifyDataSetChanged();
    }

}