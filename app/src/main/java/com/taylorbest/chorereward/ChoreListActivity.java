package com.taylorbest.chorereward;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.taylorbest.chorereward.models.Chore;
import com.taylorbest.chorereward.models.Security;
import com.taylorbest.chorereward.utils.Consts;
import com.taylorbest.chorereward.utils.OnAsyncRequestComplete;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by chadley on 10/14/2015.
 */
public class ChoreListActivity extends SingleFragmentActivity implements OnAsyncRequestComplete{

    private ArrayList<Chore> mChores;

    @Override
    protected Fragment createFragment() {
        return new ChoreListFragment();
    }

    @Override
    public void asyncResponse(String response, String label) {

        if (label == "get_chores") {
            try {

                mChores = ChoreCollection.get(getApplicationContext()).getChores();


                Log.d(Consts.TAG, response);

                // an array of chore objects in json form should be in the response.
                JSONArray jsonArray = new JSONArray(response);
                // clear the array of chores
                mChores.clear();
                for (int i=0; i< jsonArray.length(); i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    if (jsonObject.has("title")) {
                        Chore c = new Chore();
                        c.setTitle(jsonObject.getString("title"));
                        c.setId(jsonObject.getInt("id"));
                        mChores.add(c);
                    }
                }


//                FragmentManager fm = getSupportFragmentManager();
//                AccountsFragment fragment = (AccountsFragment) fm.findFragmentById(R.id.container);
//                fragment.updateAccountList(accountList);
            } catch (Exception e) {
                Log.d(Consts.TAG, e.toString());
            }
        }
    }
}
