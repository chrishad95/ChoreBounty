package com.taylorbest.chorereward;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.taylorbest.chorereward.models.Chore;
import com.taylorbest.chorereward.models.Circle;
import com.taylorbest.chorereward.models.CircleCollection;
import com.taylorbest.chorereward.models.Security;
import com.taylorbest.chorereward.utils.AsyncRequest;
import com.taylorbest.chorereward.utils.Consts;
import com.taylorbest.chorereward.utils.OnAsyncRequestComplete;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by chadley on 10/19/2015.
 */
public class CircleListFragment extends ListFragment implements OnAsyncRequestComplete {

    private ArrayList<Circle> mCircles;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getActivity().setTitle("Circles");
        mCircles = CircleCollection.get(getActivity()).getCircles();

        CircleAdapter adapter = new CircleAdapter(mCircles);
        setListAdapter(adapter);


        // try to authenticate with stored credentials, if login fails, then go to login screen
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("security_key", Security.getSecurityKey());
        params.put("user_key", Security.getUserKey());

        // get circles for the user
        new AsyncRequest((OnAsyncRequestComplete) this, params, "get_circles", "http://www.taylorbest.com/budget/model/mobile/circles.php").execute();


    }


    @Override
    public void asyncResponse(String response, String label) {
        if (label == "get_circles") {
            try {

                Log.d(Consts.TAG, response);

                // an array of chore objects in json form should be in the response.
                JSONArray jsonArray = new JSONArray(response);
                // clear the array of chores
                mCircles.clear();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    if (jsonObject.has("title")) {
                        Circle c = new Circle(jsonObject.getString("title"));
                        c.setId(jsonObject.getInt("id"));
                        mCircles.add(c);
                    }
                }

                // so now that we have the new data, let us have our adapter refresh...
                ((CircleAdapter)getListAdapter()).notifyDataSetChanged();
            } catch (Exception e) {
                Log.d(Consts.TAG, e.toString());

            }
        }

    }


    private class CircleAdapter extends ArrayAdapter<Circle> {

        public CircleAdapter(ArrayList<Circle> circles) {

            super(getActivity(), 0, circles);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_circle, null);

            }
            Circle c = getItem(position);
            TextView titleTextView = (TextView) convertView.findViewById(R.id.circle_list_item_titleTextView);
            titleTextView.setText(c.getTitle());

            return convertView;

        }
    }
}
