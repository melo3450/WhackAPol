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

public class SelectDemocraticCandidate extends ListActivity {

    private Firebase fbr;
    private Firebase fbCandidate;

    String[] candidates ={
            "Bernie Sanders",
            "Hilary Clinton"
    };

    public static String candidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_list);
        setListAdapter(new IconicAdapter());

        TextView title = (TextView) findViewById(R.id.title);
        title.setText("Select a Democratic candidate.");

        fbr = new Firebase("https://whackacandidate.firebaseio.com/");
        fbCandidate = fbr.child("selectedDem");
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Log.d("test", "clicked"+position);
        // 0: Hilary
        // 1: Bernie
        switch (position){
            case 0:
                fbCandidate.setValue("Bernie");
                candidate = "Bernie Sanders";
                break;
            case 1:
                fbCandidate.setValue("Hilary");
                candidate = "Hilary Clinton";
                break;
        }
    }

    class IconicAdapter extends ArrayAdapter<String> {
        IconicAdapter() {
            super(SelectDemocraticCandidate.this, R.layout.simplerow, R.id.candidate, candidates);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = super.getView(position, convertView, parent);
            ImageView icon = (ImageView) row.findViewById(R.id.icon);
            if (position%2 == 0) {
                icon.setImageResource(R.drawable.bernie);
            } else {
                icon.setImageResource(R.drawable.hillary);
            }
            TextView textView = (TextView) row.findViewById(R.id.candidate);

            return row;
        }
    }

    public void nextActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

