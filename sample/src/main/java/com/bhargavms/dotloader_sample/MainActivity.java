package com.bhargavms.dotloader_sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bhargavms.dotloader.DotLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DotLoader dotLoader = (DotLoader) findViewById(R.id.dot_loader);
        // testing set number of pods after some delay
        dotLoader.postDelayed(new Runnable() {
            @Override
            public void run() {
                dotLoader.setNumberOfDots(5);
            }
        }, 5000);

        dotLoader.postDelayed(new Runnable() {
            @Override
            public void run() {
                dotLoader.setNumberOfDots(6);
            }
        }, 10000);

        dotLoader.postDelayed(new Runnable() {
            @Override
            public void run() {
                dotLoader.setNumberOfDots(3);
            }
        }, 15000);
    }
}
