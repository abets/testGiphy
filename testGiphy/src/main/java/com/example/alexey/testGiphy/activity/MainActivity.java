package com.example.alexey.testGiphy.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.alexey.testGiphy.R;
import com.example.alexey.testGiphy.fragments.GiphyAnimationFragment;
import com.example.alexey.testGiphy.fragments.GiphyListFragment;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;
/**
 * Created by Alexey on 15.11.2016.
 */
public class MainActivity extends AppCompatActivity implements ActivityCallback{

    private static String TAG = "TAG";

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        fragmentManager = getSupportFragmentManager();

        Fragment fragment = fragmentManager.findFragmentByTag(TAG);
        if (fragment == null) replaceFragment(new GiphyListFragment(), false);
    }

    private void replaceFragment(Fragment fragment, boolean addBackStack) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment, TAG);
        if (addBackStack) transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }

    @Override
    public void startGiphyAnimFragment(String path) {
        replaceFragment(GiphyAnimationFragment.newInstance(path), true);
    }
}
