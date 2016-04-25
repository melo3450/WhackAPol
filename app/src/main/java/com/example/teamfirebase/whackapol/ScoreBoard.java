package com.example.teamfirebase.whackapol;

import android.widget.RelativeLayout;
import android.content.Context;
import android.graphics.Typeface;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ScoreBoard {
    Context context;
    RelativeLayout container;
    private int score=0;
    private TextView totalscore;

    public ScoreBoard(Context context, RelativeLayout container) {
        this.context=context;
        this.container=container;

        totalscore= (TextView)container.findViewById(R.id.score2);
    }

    public void updateScore(int player, int earned) { //will use candidate according to which party chosen etc
            score += 15;
        totalscore.setText(score+"");
    }
}

