package com.example.alexey.testGiphy.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.alexey.testGiphy.R;
import com.example.alexey.testGiphy.activity.ActivityCallback;
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

public class GiphyListFragment extends BaseFragment implements IListView {

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;

    @Bind(R.id.edit_text)
    EditText editText;

    @Bind(R.id.button_search)
    Button searchButton;

    private Presenter presenter = new GiphyPresenter(this);
    View view;
    private GiphyViewAdapter adapter;
    private ActivityCallback callback;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            callback = (ActivityCallback) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement activityCallback");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(view==null) {
            view = inflater.inflate(R.layout.fragment_giphy_list, container, false);
            ButterKnife.bind(this, view);

            LinearLayoutManager llm = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(llm);
            adapter = new GiphyViewAdapter(new ArrayList<GiphyItem>(), presenter);
            recyclerView.setAdapter(adapter);

            presenter.onLoadTrendingGiphy();

            searchButton.setOnClickListener(v -> presenter.onSearchButtonClick());
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }
    @Override
    protected Presenter getPresenter() {
        return presenter;
    }

    private void makeToast(String text) {
        Snackbar.make(recyclerView, text, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showData(DataGiphyItems list) {
        adapter.setGiphyList(list.getGiphyData());
    }

    @Override
    public void showFragmentAnim(String path) {
        callback.startGiphyAnimFragment(path);
    }

    @Override
    public void showError(String error) {
        makeToast(error);
    }

    @Override
    public void showEmptyList() {
        makeToast("Nothing found");
    }

    @Override
    public String getSearchKey() {
        return editText.getText().toString();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
