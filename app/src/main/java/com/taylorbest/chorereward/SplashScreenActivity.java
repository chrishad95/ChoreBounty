package com.taylorbest.chorereward;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;

import com.taylorbest.chorereward.models.Security;
import com.taylorbest.chorereward.utils.AsyncRequest;
import com.taylorbest.chorereward.utils.Consts;
import com.taylorbest.chorereward.utils.OnAsyncRequestComplete;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by chadley on 10/14/2015.
 */
public class SplashScreenActivity extends Activity implements OnAsyncRequestComplete {


    SharedPreferences sp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // try to load the stored credentials from shared preferences
        sp  = getBaseContext().getSharedPreferences(Consts.PREFS_NAME, getBaseContext().MODE_PRIVATE);


        String securityKey = sp.getString("security_key", "");
        String userKey = sp.getString("user_key", "");

        Log.d(Consts.TAG, "security_key:" + securityKey);
        Log.d(Consts.TAG, "user_key:" + userKey);


        if (TextUtils.isEmpty(securityKey) || TextUtils.isEmpty(userKey)) {

            Thread startTimer = new Thread() {
                public void run() {
                    try {

                        sleep(5000);
                        Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                        startActivity(i);
                        finish();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            };
            startTimer.start();
        } else {

            // try to authenticate with stored credentials, if login fails, then go to login screen
            HashMap<String, String> params = new HashMap<String, String>();
            params.put("security_key", securityKey);
            params.put("user_key", userKey);

            new AsyncRequest((OnAsyncRequestComplete) this, params, "do_authenticate", "http://www.taylorbest.com/budget/model/mobile/auth.php").execute();
        }



    }


    @Override
    public void asyncResponse(String response, String label) {
        if (label == "do_authenticate") {
            try {
                Log.d(Consts.TAG, "inside do_authenticate");
                Log.d(Consts.TAG, response);

                JSONObject jsonObject = new JSONObject(response);

                if (jsonObject.has("security_key") && jsonObject.has("user_key") ) {
                    Security.setSecurityKey(jsonObject.getString("security_key"));
                    Security.setUserKey(jsonObject.getString("user_key"));
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("security_key", jsonObject.getString("security_key"));
                    editor.putString("user_key", jsonObject.getString("user_key"));
                    editor.commit();

                    // should load data here.

                    Intent intent = new Intent(SplashScreenActivity.this, CircleListActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Log.d(Consts.TAG, "no security key so we need login screen");
                    // failed to get a security key so we need to login
                    Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();

                }

            } catch (Exception e) {
                Log.d(Consts.TAG, e.toString());
                Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        }

    }
}
