package com.taylorbest.chorereward;

import android.support.v4.app.Fragment;

/**
 * Created by chadley on 10/14/2015.
 */
public class ChoreListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ChoreListFragment();
    }
}
