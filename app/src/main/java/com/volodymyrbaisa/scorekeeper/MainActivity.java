package com.volodymyrbaisa.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final int BARRIER = 99;
    private final int TOUCHDOWN = 7;
    private final int FIELD_GOAL = 3;
    private final int SAFETY = 2;

    private int teamA = 0;
    private int teamB = 0;

    private TextView textFieldTeamA;
    private TextView textFieldTeamB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        textFieldTeamA = findViewById(R.id.left_text_field);
        textFieldTeamB = findViewById(R.id.right_text_field);
    }

    public void onClickTouchdownTeamA(View v) {
        displayTeamA(TOUCHDOWN);
    }

    public void onClickFieldGoalTeamA(View v) {
        displayTeamA(FIELD_GOAL);
    }

    public void onClickSafetyTeamA(View v) {
        displayTeamA(SAFETY);
    }

    public void onClickTouchdownTeamB(View v) {
        displayTeamB(TOUCHDOWN);
    }

    public void onClickFieldGoalTeamB(View v) {
        displayTeamB(FIELD_GOAL);
    }

    public void onClickSafetyTeamB(View v) {
        displayTeamB(SAFETY);
    }

    public void onClickReset(View v) {
        teamA = 0;
        teamB = 0;
        displayTeamA(0);
        displayTeamB(0);
    }

    private void displayTeamA(int value) {
        teamA = checkBarrier(teamA += value);
        textFieldTeamA.setText(String.valueOf(teamA));
    }

    private void displayTeamB(int value) {
        teamB = checkBarrier(teamB += value);
        textFieldTeamB.setText(String.valueOf(teamB));
    }

    private int checkBarrier(int team) {
        if(team > BARRIER) {
            return BARRIER;
        }
        return team;
    }
}
