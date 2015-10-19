package com.taylorbest.chorereward;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.taylorbest.chorereward.models.Security;
import com.taylorbest.chorereward.utils.Consts;
import com.taylorbest.chorereward.utils.OnAsyncRequestComplete;

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



                Log.d(Consts.TAG, response);

                JSONObject jsonObject = new JSONObject(response);
                if (jsonObject.has("security_key") && jsonObject.has("user_key") ) {
                    Security.setSecurityKey(jsonObject.getString("security_key"));
                    Security.setUserKey(jsonObject.getString("user_key"));

                    SharedPreferences sp = getBaseContext().getSharedPreferences(Consts.PREFS_NAME, getBaseContext().MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("security_key", jsonObject.getString("security_key"));
                    editor.putString("user_key", jsonObject.getString("user_key"));
                    editor.commit();

                    Intent intent = new Intent(LoginActivity.this, CircleListActivity.class);
                    startActivity(intent);
                    finish();
                }


            } catch (Exception e) {
                Log.d(Consts.TAG, e.toString());
            }
        }

    }
}
