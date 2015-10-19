package com.taylorbest.chorereward.models;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by chadley on 10/19/2015.
 */
public class CircleCollection {

    private ArrayList<Circle> mCircles;
    private Context context;
    private static CircleCollection sCircleCollection;

    private CircleCollection(Context context) {
        this.context = context;
        mCircles = new ArrayList<Circle>();

    }

    public static CircleCollection get(Context c) {
        if (sCircleCollection == null ) {
            sCircleCollection = new CircleCollection(c);
        }
        return sCircleCollection;
    }

    public ArrayList<Circle> getCircles() {
        return mCircles;
    }

    public Circle getCircle(int id) {
        for (int i=0; i<mCircles.size(); i++) {
            if (mCircles.get(i).getId() == id) {
                return mCircles.get(i);
            }
        }
        return null;
    }
}
