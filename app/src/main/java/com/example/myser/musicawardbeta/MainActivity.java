package com.example.myser.musicawardbeta;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private long loadTime = 3000;

    private Thread thread;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = this;

        thread = new Thread() {
            @Override
            public void run () {
                continueToApp(loadTime, new Intent(activity, HomeActivity.class));
            }
        };

        thread.start();
    }

    //Load an activity after _waitTime amount of milliseconds.
    private void continueToApp(long _waitTime, Intent _nextActivityIntent) {
        try {
            Thread.sleep(_waitTime);
            startActivity(_nextActivityIntent);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Loads next activity after when user taps the screen.
    public void continueToApp(View view) {
        Intent intentNextActivity = new Intent(this, HomeActivity.class);

        startActivity(intentNextActivity);
    }

}
