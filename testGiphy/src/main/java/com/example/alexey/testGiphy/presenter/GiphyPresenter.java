package com.example.alexey.testGiphy.presenter;

import com.example.alexey.testGiphy.fragments.IGiphyItemView;
import com.example.alexey.testGiphy.fragments.IListView;
import com.example.alexey.testGiphy.model.Model;
import com.example.alexey.testGiphy.model.ModelImpl;
import com.example.alexey.testGiphy.model.data.DataGiphyItems;

import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;


/**
 * Created by Alexey on 15.11.2016.
 */

public class GiphyPresenter implements Presenter {

    private Model model = new ModelImpl();

    private IListView view;
    private IGiphyItemView itemView;
    private Subscription subscription = Subscriptions.empty();

    public GiphyPresenter(IListView view) {
        this.view = view;
    }
    public GiphyPresenter(IGiphyItemView view) {
        this.itemView = view;
    }

    @Override
    public void onSearchButtonClick() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        subscription = model.getSearchGiphy(view.getSearchKey())
                .subscribe(new Observer<DataGiphyItems>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(DataGiphyItems data) {
                        if (data != null && data.getGiphyData().size()>0) {
                            view.showData(data);
                        } else {
                            view.showEmptyList();
                        }
                    }
                });

    }

    @Override
    public void onLoadTrendingGiphy() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }

        subscription = model.getGiphyTrending()
                .subscribe(new Observer<DataGiphyItems>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(DataGiphyItems data) {
                        if (data != null) {
                            view.showData(data);
                        } else {
                            view.showEmptyList();
                        }
                    }
                });

    }

    @Override
    public void onStop() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    @Override
    public void onClickGiphy(String path) {
        view.showFragmentAnim(path);
    }
}