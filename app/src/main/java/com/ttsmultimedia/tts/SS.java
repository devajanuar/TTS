package com.ttsmultimedia.tts;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.ProgressBar;

/**
 * Created by devajanuar on 8/14/2015.
 */
public class SS extends Activity {
    private static final int SPLASH_TIME = 3 * 1000;
    ProgressBar progressBar;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ss);

        progressBar = (ProgressBar) findViewById(R.id.PB);
        progressBar.setAlpha(SPLASH_TIME);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(SS.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },SPLASH_TIME);
    }
}
