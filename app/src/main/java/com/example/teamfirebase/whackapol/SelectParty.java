package com.example.teamfirebase.whackapol;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;

/**
 * Created by louismenacho on 4/23/16.
 */
public class SelectParty extends ListActivity {

    private Firebase fbr;
    private Firebase fbParty;
    private String party = "";

    String[] candidates ={
            "Democratic",
            "Republican"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_list);
        setListAdapter(new IconicAdapter());

        TextView title = (TextView) findViewById(R.id.title);
        title.setText("Select a party.");

        fbr = new Firebase("https://whackacandidate.firebaseio.com/");
        fbParty = fbr.child("selectedParty");

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Log.d("test", "clicked"+position);
        // 0: Hilary
        // 1: Bernie
        switch (position){
            case 0:
                fbParty.setValue("Democratic");
                party = "Democratic";
                break;
            case 1:
                fbParty.setValue("Republican");
                party = "Republican";
                break;
        }
    }

    class IconicAdapter extends ArrayAdapter<String> {
        IconicAdapter() {
            super(SelectParty.this, R.layout.simplerow, R.id.candidate, candidates);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = super.getView(position, convertView, parent);
            ImageView icon = (ImageView) row.findViewById(R.id.icon);
            if (position%2 == 0) {
                icon.setImageResource(R.drawable.democrat);
            } else {
                icon.setImageResource(R.drawable.republican);
            }
            TextView textView = (TextView) row.findViewById(R.id.candidate);

            return row;
        }
    }

    public void nextActivity(View view) {
        // Go to picking candidates
        if(party.equals("Democratic")){
            Log.d("D", "Demo");
            Intent selectCandidate = new Intent(this, SelectDemocraticCandidate.class);
            startActivity(selectCandidate);
        } else if (party.equals("Republican")) {
            Log.d("R", "Republican");
            Intent selectCandidate = new Intent(this, SelectRepublicanCandidate.class);
            startActivity(selectCandidate);
        } else {
            Log.d("test", "Pick a party");
        }
    }



}

