package com.taylorbest.chorereward;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.taylorbest.chorereward.utils.AsyncRequest;
import com.taylorbest.chorereward.utils.Consts;
import com.taylorbest.chorereward.utils.OnAsyncRequestComplete;

import java.util.HashMap;

/**
 * Created by chadley on 10/15/2015.
 */
public class LoginFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        final EditText loginEmailEditText = (EditText) v.findViewById(R.id.login_email_text);
        final EditText loginPasswordEditText = (EditText) v.findViewById(R.id.login_password_text);

        final Button loginButton = (Button) v.findViewById(R.id.btnLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(loginEmailEditText.getText().toString())
                        || TextUtils.isEmpty(loginPasswordEditText.getText().toString())) {

                } else {
                    Log.d(Consts.TAG, "Clicked the login button!!!");
                    // try to authenticate using the email address and password provided
                    HashMap<String, String> params = new HashMap<String, String>();
                    params.put("uid", loginEmailEditText.getText().toString());
                    params.put("pwd", loginPasswordEditText.getText().toString());

                    new AsyncRequest((OnAsyncRequestComplete) getActivity(), params, "do_login", "http://www.taylorbest.com/budget/model/mobile/accounts.php").execute();

                }

            }
        });

        return v;
    }
}
