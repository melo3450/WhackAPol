package com.example.teamfirebase.whackapol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by alisoncheu on 4/24/16.
 */
public class Firebase extends AppCompatActivity {
    private com.firebase.client.Firebase fbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        //set up Firebase
        com.firebase.client.Firebase.setAndroidContext(this);
        fbr = new com.firebase.client.Firebase("https://whackacandidate.firebaseio.com/");


    }
}
