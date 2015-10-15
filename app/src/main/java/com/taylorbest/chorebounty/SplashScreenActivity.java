package com.taylorbest.chorebounty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

/**
 * Created by chadley on 10/14/2015.
 */
public class SplashScreenActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread startTimer = new Thread() {
            public void run() {
                try {
                    // try to login with stored credentials, if login fails, then go to login screen

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

    }
}
