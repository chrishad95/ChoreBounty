package com.taylorbest.chorebounty;

import android.content.Context;

import com.taylorbest.chorebounty.models.Chore;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by chadley on 10/14/2015.
 */
public class ChoreCollection {
    private ArrayList<Chore> mChores;
    private Context mAppContext;
    private static ChoreCollection sChoreCollection;

    private ChoreCollection(Context appContext) {



        // this is a comment
        mAppContext = appContext;
        mChores = new ArrayList<Chore>();
        for (int i=0; i<10; i++) {
            Chore c = new Chore();
            c.setTitle("Chore #" + i);
            c.setDateCreated(new Date());
            c.setCompleted(i % 2 == 0);
            mChores.add(c);
        }
    }

    public static ChoreCollection get(Context c) {
        if(sChoreCollection == null) {
            sChoreCollection = new ChoreCollection(c.getApplicationContext());
        }
        return sChoreCollection;
    }

    public ArrayList<Chore> getChores() { return mChores; }

    public Chore getChore(UUID id) {
        for (Chore c : mChores) {
            if (c.getId().equals(id)){
                return c;
            }
        }
        return null;
    }
}
