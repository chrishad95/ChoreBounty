package com.taylorbest.chorereward.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by chadley on 10/16/2015.
 */

public class AsyncRequest extends AsyncTask<Void, Integer, String>{

    private OnAsyncRequestComplete caller;
    private String label = "";
    Context context;
    HashMap<String, String> parameters = null;
    private String url;

    public AsyncRequest(OnAsyncRequestComplete caller, HashMap<String, String> p, String l, String url){
        this.caller = caller;
        this.parameters = p;
        this.label = l;
        this.url = url;
    }

    @Override
    protected String doInBackground(Void... arg0) {
        String res = "";
        res = post(url);
        return res;
    }

    private String post(String address) {

        URL url;

        BufferedReader bufferedReader = null;
        String res = "";

        try {
            url  = new URL(address);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(getPostDataString(parameters));
            writer.flush();
            writer.close();
            os.close();
            int responseCode = conn.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = conn.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);

                StringBuilder sb = new StringBuilder();
                String readLine = bufferedReader.readLine();
                while (readLine != null){
                    sb.append(readLine);
                    readLine = bufferedReader.readLine();
                }
                res=sb.toString();

            } else {
                res = "";
            }

        }
        catch (Exception e)
        {
            Log.d(Consts.TAG, e.getMessage());
        }
        finally {
            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e){
                    Log.d(Consts.TAG, e.toString());
                }

            }
        }
        Log.d(Consts.TAG, "Result in asynctask: " + res);
        return res;
    }

    public void onPostExecute(String response){
        caller.asyncResponse(response, label);
    }
    private String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for(Map.Entry<String, String> entry : params.entrySet()){
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        return result.toString();
    }
}