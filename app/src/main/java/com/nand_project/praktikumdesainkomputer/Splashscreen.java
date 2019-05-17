package com.nand_project.praktikumdesainkomputer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class Splashscreen extends AppCompatActivity {

    //Set waktu lama splashscreen
    private ImageView iv;
    int counter =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splashscreen);

        iv = findViewById(R.id.splash);

        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);

        iv.startAnimation(myanim);

        final Intent i = new Intent(this, MainActivity.class);

        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();

    }
}
