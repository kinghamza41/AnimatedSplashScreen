package com.example.animatedsplahscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        lottieAnimationView = findViewById(R.id.animation);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lottieAnimationView.setVisibility(View.VISIBLE);
                lottieAnimationView.playAnimation();
                button.setVisibility(View.INVISIBLE);

                Thread td = new Thread() {
                    public void run() {
                        try {
                            sleep(1000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            Intent intent = new Intent(MainActivity.this, CovidActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                };
                td.start();
            }
        });

    }
}