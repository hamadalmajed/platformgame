package com.example.platformgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class Start extends AppCompatActivity {

    static int lastscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {    // make it first page in program
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void startGame(View view) {  //to start game

        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }


    //Disable Return Button
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {    // to disable android controls ?chk

        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_BACK:
                    return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }
    public void exitGames(View view) { // to exit game

        final AlertDialog.Builder builder = new AlertDialog.Builder(Start.this);  // ready from android
        builder.setTitle("Exit");  // alert exit button
        builder.setMessage("Do you want to exit ??");  // message to exit
        builder.setPositiveButton("Yes. Exit now!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {    // confirmation message

                finish();  // means exited succesfully

            }
        });

        builder.setNegativeButton("Not now", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {     // alternative message

                dialogInterface.dismiss();   // to cancel exit
            }
        });

        AlertDialog dialog = builder.create();  // starts builder for buttons
        dialog.show();
    }

}

