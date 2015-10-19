package com.taylorbest.chorereward;

import android.support.v4.app.Fragment;


/**
 * Created by chadley on 10/19/2015.
 */
public class CircleListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CircleListFragment();
    }
}
