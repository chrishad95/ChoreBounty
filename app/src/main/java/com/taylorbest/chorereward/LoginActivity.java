package com.taylorbest.chorereward;

import android.support.v4.app.Fragment;
import android.util.Log;

import com.taylorbest.chorereward.utils.Consts;
import com.taylorbest.chorereward.utils.OnAsyncRequestComplete;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by chadley on 10/14/2015.
 */
public class LoginActivity extends SingleFragmentActivity implements OnAsyncRequestComplete {
    @Override
    protected Fragment createFragment() {
        return new LoginFragment();
    }

    @Override
    public void asyncResponse(String response, String label) {
        if (label == "do_login") {
            try {

                // if the login was successful then there will be a security key, and account identity (email, username,...)
                String securityKey = "";
                String identity = "";


                //JSONObject jsonObject = new JSONObject(response);
                JSONArray jsonArray = new JSONArray(response);


                Log.d(Consts.TAG, response);



                for (int i=0; i< jsonArray.length(); i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

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
