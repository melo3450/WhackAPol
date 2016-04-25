package com.example.teamfirebase.whackapol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.firebase.client.*;

/**
 * Created by alisoncheu on 4/24/16.
 */
public class Title extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title);
    }

    public void start(View view){
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }
}

