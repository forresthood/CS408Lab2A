package com.example.cs408lab2a;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int playerScore = 0;
    private int cpuScore = 0;
    Random rand = new Random();

    public enum Weapon {
        ROCK("Rock"),
        PAPER("Paper"),
        SCISSORS("Scissors");
        private String message;

        private Weapon(String msg) { message = msg; }

        @Override
        public String toString() { return message; }
    }
    private Weapon randWeapon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void rockClicked(View v){
        randWeapon = cpuWeapon();
        TextView score = (TextView) findViewById(R.id.scoreView);
        TextView player = (TextView) findViewById(R.id.playerWeaponView);
        TextView cpu = (TextView) findViewById(R.id.cpuWeaponView);
        TextView winner = (TextView) findViewById(R.id.winnerView);

        switch (randWeapon){
            case ROCK:
                score.setText("Player: " + String.valueOf(playerScore) + ", Computer: " + String.valueOf(cpuScore));
                player.setText("Player's Weapon: Rock");
                cpu.setText("Computer's Weapon: Rock");
                winner.setText("Tie!");
                break;
            case PAPER:
                cpuScore++;
                score.setText("Player: " + String.valueOf(playerScore) + ", Computer: " + String.valueOf(cpuScore));
                player.setText("Player's Weapon: Rock");
                cpu.setText("Computer's Weapon: Paper");
                winner.setText("Computer Wins!");
                break;
            case SCISSORS:
                playerScore++;
                score.setText("Player: " + String.valueOf(playerScore) + ", Computer: " + String.valueOf(cpuScore));
                player.setText("Player's Weapon: Rock");
                cpu.setText("Computer's Weapon: Scissors");
                winner.setText("Player Wins!");
                break;
        }
    }

    public void paperClicked(View v){
        randWeapon = cpuWeapon();
        TextView score = (TextView) findViewById(R.id.scoreView);
        TextView player = (TextView) findViewById(R.id.playerWeaponView);
        TextView cpu = (TextView) findViewById(R.id.cpuWeaponView);
        TextView winner = (TextView) findViewById(R.id.winnerView);

        switch (randWeapon){
            case ROCK:
                playerScore++;
                score.setText("Player: " + String.valueOf(playerScore) + ", Computer: " + String.valueOf(cpuScore));
                player.setText("Player's Weapon: Paper");
                cpu.setText("Computer's Weapon: Rock");
                winner.setText("Player Wins!");
                break;
            case PAPER:
                score.setText("Player: " + String.valueOf(playerScore) + ", Computer: " + String.valueOf(cpuScore));
                player.setText("Player's Weapon: Paper");
                cpu.setText("Computer's Weapon: Paper");
                winner.setText("Tie!");
                break;
            case SCISSORS:
                cpuScore++;
                score.setText("Player: " + String.valueOf(playerScore) + ", Computer: " + String.valueOf(cpuScore));
                player.setText("Player's Weapon: Paper");
                cpu.setText("Computer's Weapon: Scissors");
                winner.setText("Computer Wins!");
                break;
        }
    }

    public void scissorsClicked(View v){
        randWeapon = cpuWeapon();
        TextView score = (TextView) findViewById(R.id.scoreView);
        TextView player = (TextView) findViewById(R.id.playerWeaponView);
        TextView cpu = (TextView) findViewById(R.id.cpuWeaponView);
        TextView winner = (TextView) findViewById(R.id.winnerView);

        switch (randWeapon){
            case ROCK:
                cpuScore++;
                score.setText("Player: " + String.valueOf(playerScore) + ", Computer: " + String.valueOf(cpuScore));
                player.setText("Player's Weapon: Scissors");
                cpu.setText("Computer's Weapon: Rock");
                winner.setText("Computer Wins!");
                break;
            case PAPER:
                playerScore++;
                score.setText("Player: " + String.valueOf(playerScore) + ", Computer: " + String.valueOf(cpuScore));
                player.setText("Player's Weapon: Scissors");
                cpu.setText("Computer's Weapon: Paper");
                winner.setText("Player Wins!");
                break;
            case SCISSORS:
                score.setText("Player: " + String.valueOf(playerScore) + ", Computer: " + String.valueOf(cpuScore));
                player.setText("Player's Weapon: Scissors");
                cpu.setText("Computer's Weapon: Scissors");
                winner.setText("Tie!");
                break;
        }
    }

    private Weapon cpuWeapon(){
        int randomInt = rand.nextInt(3);
        switch(randomInt){
            case 0:
                return Weapon.ROCK;
            case 1:
                return Weapon.PAPER;
            case 2:
                return Weapon.SCISSORS;
            default:
                throw new IllegalStateException("Unexpected value: " + randomInt);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
