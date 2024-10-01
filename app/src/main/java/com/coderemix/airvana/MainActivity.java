package com.coderemix.airvana;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private AnimatedBallView animatedBallView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        animatedBallView = findViewById(R.id.animatedBallView);
        Button startButton = findViewById(R.id.breathButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBreathAnimation();
            }
        });

    }
    private void startBreathAnimation() {
        // Size Animation for 1-minute duration
        ValueAnimator sizeAnimator = ValueAnimator.ofFloat(200f, 400f, 200f); // Inhale to Exhale
        sizeAnimator.setDuration(4000); // One inhale-exhale cycle of 4 seconds
        sizeAnimator.setRepeatCount(ValueAnimator.INFINITE); // Loop indefinitely
        sizeAnimator.addUpdateListener(animation -> {
            float animatedRadius = (float) animation.getAnimatedValue();
            animatedBallView.setRadius(animatedRadius);
        });

        // Stop the animation after 1 minute
        sizeAnimator.setRepeatCount((60000 / 4000)); // Repeat the animation to last 1 minute
        sizeAnimator.start();
    }
}