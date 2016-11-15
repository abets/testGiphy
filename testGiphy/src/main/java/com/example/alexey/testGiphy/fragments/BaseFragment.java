package com.example.alexey.testGiphy.fragments;

import android.support.v4.app.Fragment;

import com.example.alexey.testGiphy.presenter.Presenter;

/**
 * Created by Alexey on 15.11.2016.
 */
public abstract class BaseFragment extends Fragment {

    protected abstract Presenter getPresenter();

    @Override
    public void onStop() {
        super.onStop();
        if (getPresenter() != null) {
            getPresenter().onStop();
        }
    }
}