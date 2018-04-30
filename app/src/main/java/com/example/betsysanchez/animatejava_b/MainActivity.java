package com.example.betsysanchez.animatejava_b;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    Button rotate,translate,scale,alpha;
    int stopVar=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.faceIcon);
        rotate = findViewById(R.id.btnRotate);
        translate = findViewById(R.id.btnTranslate);
        scale = findViewById(R.id.btnScale);
        alpha = findViewById(R.id.btnAlpha);
        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RotateAnimation anim = new RotateAnimation(0f, 150f, 15f, 15f);
                anim.setInterpolator(new LinearInterpolator());
                anim.setRepeatCount(Animation.INFINITE);
                anim.setDuration(700);
                stopVar++;
                if(stopVar%2==0){
                    imageView.setAnimation(null);
                }else{
                    imageView.startAnimation(anim);}
            }
        });

        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = new TranslateAnimation(0, 500,0, 0);
                animation.setDuration(1000);
                animation.setFillAfter(true);
                imageView.startAnimation(animation);
                imageView.setVisibility(View.VISIBLE);
            }
        });
        scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = new ScaleAnimation(0.0f,1.0f,0.0f,1.0f,
                        Animation.RELATIVE_TO_PARENT,0.5f,Animation.RELATIVE_TO_PARENT,0.5f);
                animation.setDuration(1000);
                imageView.startAnimation(animation);
            }
        });
        alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = new AlphaAnimation(0.0f,1.1f);
                animation.setDuration(1000);
                imageView.startAnimation(animation);
            }
        });
    }

}
