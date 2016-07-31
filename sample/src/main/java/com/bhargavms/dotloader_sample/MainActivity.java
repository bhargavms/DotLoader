package com.bhargavms.dotloader_sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bhargavms.dotloader.DotLoader;

public class MainActivity extends AppCompatActivity {
    DotLoader dotLoader;
    DotLoader textDotLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dotLoader = (DotLoader) findViewById(R.id.dot_loader);
        textDotLoader = (DotLoader) findViewById(R.id.text_dot_loader);
        // testing set number of dots after some delay
        dotLoader.postDelayed(new Runnable() {
            @Override
            public void run() {
                dotLoader.setNumberOfDots(5);
            }
        }, 3000);

        dotLoader.postDelayed(new Runnable() {
            @Override
            public void run() {
                dotLoader.setNumberOfDots(6);
            }
        }, 6000);

//        dotLoader.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                dotLoader.setNumberOfDots(3);
//            }
//        }, 9000);

        for (int i = 1; i < 4; i++) {
            textDotLoader.postDelayed(new DotIncrementRunnable(3 + i, textDotLoader), i * 3000);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        dotLoader.resetColors();
        textDotLoader.resetColors();
    }

    private static class DotIncrementRunnable implements Runnable {
        private int mNumberOfDots;
        private DotLoader mDotLoader;

        private DotIncrementRunnable(int numberOfDots, DotLoader dotLoader) {
            mNumberOfDots = numberOfDots;
            mDotLoader = dotLoader;
        }

        @Override
        public void run() {
            mDotLoader.setNumberOfDots(mNumberOfDots);
        }
    }
}
