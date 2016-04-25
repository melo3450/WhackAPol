package com.example.teamfirebase.whackapol;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * Created by alison cheu on 4/23/16.
 */
public class MainPage extends AppCompatActivity implements View.OnClickListener {
    private Firebase fBase;
    private Firebase fVersion;
    private Firebase fTest;
    RadioButton button1, button2;
    private long numPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        //setup Firebase
        Firebase.setAndroidContext(this);
        fBase = new Firebase("https://whackacandidate.firebaseio.com/");
        fVersion = fBase.child("gamePlayers");

        button1 = (RadioButton) findViewById(R.id.player1);
        button2 = (RadioButton) findViewById(R.id.player2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }


    public void goPlay(View view){

        //need to check if Valid
        boolean valid = validSelection(view);
        if(valid){
            //startActivity
            Intent intent = new Intent(this,SelectParty.class);
            startActivity(intent);
        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Need to select one option!")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //do things
                        }
                    });
            builder.create();
            builder.show();
        }
    }

    private boolean validSelection(View view){
        button1 =  (RadioButton) findViewById(R.id.player1);
        button2 = (RadioButton) findViewById(R.id.player2);

        boolean checkedOne = button1.isChecked();
        boolean checkedTwo = button2.isChecked();

        if(checkedOne && checkedTwo){
            return false;
        }else if(checkedOne){
            return true;
        }else if(checkedTwo){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void onClick(View v) {
        boolean valid = validSelection(v);
        switch (v.getId()) {
            case R.id.player1:
                if(button2.isChecked()){
                    button2.setChecked(false);
                }
                break;
            case R.id.player2:
                if(button1.isChecked()){
                    button1.setChecked(false);
                }
                break;
        }
    }
}
