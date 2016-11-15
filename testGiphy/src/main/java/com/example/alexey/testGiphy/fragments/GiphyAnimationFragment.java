package com.example.alexey.testGiphy.fragments;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;

import com.example.alexey.testGiphy.R;
import com.example.alexey.testGiphy.adapter.GiphyViewAdapter;
import com.example.alexey.testGiphy.model.data.DataGiphyItems;
import com.example.alexey.testGiphy.model.data.GiphyItem;
import com.example.alexey.testGiphy.presenter.GiphyPresenter;
import com.example.alexey.testGiphy.presenter.Presenter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Alexey on 15.11.2016.
 */

public class GiphyAnimationFragment extends BaseFragment  implements IGiphyItemView  {
    private Presenter presenter = new GiphyPresenter(this);
    private static final String BUNDLE_GIPHY_KEY = "BUNDLE_GIPHY_KEY";

    @Bind(R.id.fragment_anim_giphy_img)
    ImageView imgGiphy;

    @Bind(R.id.fragment_anim_layout)
    View layout;

    @Bind(R.id.fragment_anim_giphy_web)
    WebView webView;

    public static GiphyAnimationFragment newInstance(String key) {
        GiphyAnimationFragment myFragment = new GiphyAnimationFragment();

        Bundle args = new Bundle();
        args.putSerializable(BUNDLE_GIPHY_KEY, key);
        myFragment.setArguments(args);

        return myFragment;
    }
    private String getKeyBundle() {
        return (String) getArguments().getSerializable(BUNDLE_GIPHY_KEY);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_giphy_animation, container, false);
        ButterKnife.bind(this, view);
        String key  = getKeyBundle();

        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(getKeyBundle());

        return view;
    }

    @Override
    protected Presenter getPresenter() {
        return presenter;
    }


    @Override
    public void showError(String error) {
        makeToast(error);
    }


    private void makeToast(String text) {
        Snackbar.make(layout, text, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showData() {

    }
}
