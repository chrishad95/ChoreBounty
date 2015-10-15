package com.taylorbest.chorebounty;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.taylorbest.chorebounty.models.Chore;

import java.text.DateFormat;
import java.util.ArrayList;

/**
 * Created by chadley on 10/14/2015.
 */
public class ChoreListFragment extends ListFragment{
    private ArrayList<Chore> mChores;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Chores");
        mChores = ChoreCollection.get(getActivity()).getChores();

        ChoreAdapter adapter = new ChoreAdapter(mChores);
        setListAdapter(adapter);

    }

    private class ChoreAdapter extends ArrayAdapter<Chore> {

        public ChoreAdapter(ArrayList<Chore> chores) {
            super(getActivity(), 0, chores);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // no view given then inflate one.
            if(convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_chore, null);
            }

            // configure the view for this chore
            Chore c = getItem(position);

            TextView titleTextView = (TextView) convertView.findViewById(R.id.chore_list_item_titleTextView);
            TextView dateTextView = (TextView) convertView.findViewById(R.id.chore_list_item_dateTextView);
            CheckBox completedCheckBox = (CheckBox) convertView.findViewById(R.id.chore_list_item_completedCheckBox);

            titleTextView.setText(c.getTitle());
            dateTextView.setText(DateFormat.getDateInstance().format(c.getDateCreated()));
            completedCheckBox.setChecked(c.isCompleted());



            return convertView;

        }
    }
}

