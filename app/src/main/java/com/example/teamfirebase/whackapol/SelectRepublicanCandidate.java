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


public class SelectRepublicanCandidate extends ListActivity {


    private Firebase fbr;
    private Firebase fbCandidate;

    String[] candidates ={
            "Ted Cruz",
            "Donald Trump"
    };

    public static String candidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_list);
        setListAdapter(new IconicAdapter());

        TextView title = (TextView) findViewById(R.id.title);
        title.setText("Select a Republican candidate.");

        fbr = new Firebase("https://whackacandidate.firebaseio.com/");
        fbCandidate = fbr.child("selectedRep");

//        this.setListAdapter(new ArrayAdapter<String>(
//                this, R.layout.democrat_row,
//                R.id.candidate,candidates)
//        );

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Log.d("test", "clicked"+position);
        // 0: Hilary
        // 1: Bernie
        switch (position){
            case 0:
                fbCandidate.setValue("Ted Cruz");
                candidate = "Ted Cruz";
                break;
            case 1:
                fbCandidate.setValue("Donald Trump");
                candidate = "Donald Trump";
                break;
        }
    }

    class IconicAdapter extends ArrayAdapter<String> {
        IconicAdapter() {
            super(SelectRepublicanCandidate.this, R.layout.simplerow, R.id.candidate, candidates);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = super.getView(position, convertView, parent);
            ImageView icon = (ImageView) row.findViewById(R.id.icon);
            if (position%2 == 0) {
                icon.setImageResource(R.drawable.ted);
            } else {
                icon.setImageResource(R.drawable.donald);
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

