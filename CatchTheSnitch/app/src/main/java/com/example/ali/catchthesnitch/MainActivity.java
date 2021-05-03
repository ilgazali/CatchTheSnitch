package com.example.ali.catchthesnitch;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView timeView;
    TextView scoreView;
    ImageView imageview;
    ImageView imageview1;
    ImageView imageview2;
    ImageView imageview3;
    ImageView imageview4;
    ImageView imageview5;
    ImageView imageview6;
    ImageView imageview7;
    ImageView imageview8;
    ImageView imageview9;
    ImageView imageview10;
    ImageView imageview11;
    ImageView imageview12;
    ImageView imageview13;
    ImageView imageview14;
    int score;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeView = findViewById(R.id.timeView);
        scoreView = findViewById(R.id.scoreView);
        imageview = findViewById(R.id.imageView);
        imageview1 = findViewById(R.id.imageView1);
        imageview2 = findViewById(R.id.imageView2);
        imageview3 = findViewById(R.id.imageView3);
        imageview4 = findViewById(R.id.imageView4);
        imageview5 = findViewById(R.id.imageView5);
        imageview6 = findViewById(R.id.imageView6);
        imageview7 = findViewById(R.id.imageView7);
        imageview8 = findViewById(R.id.imageView8);
        imageview9 = findViewById(R.id.imageView9);
        imageview10 = findViewById(R.id.imageView10);
        imageview11 = findViewById(R.id.imageView11);
        imageview12= findViewById(R.id.imageView12);
        imageview13 = findViewById(R.id.imageView13);
        imageview14 = findViewById(R.id.imageView14);

        imageArray = new ImageView[] {imageview, imageview1, imageview2, imageview3,imageview4,imageview5,imageview6,imageview7, imageview8,imageview9,imageview10,imageview11,imageview12,imageview13,imageview14 };

     hideImages();

        score = 0;
        new CountDownTimer(10000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timeView.setText("Time:"+ millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
            timeView.setText("Time Off");
            handler.removeCallbacks(runnable);
                for(ImageView image: imageArray){

                    image.setVisibility(View.INVISIBLE);
                }
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Restart Game?");
                alert.setMessage("are you sure to restart game?");
                alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);

                    }
                });
                alert.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "GAME OVER", Toast.LENGTH_LONG).show();
                    }
                });
                alert.show();
            }
        }.start();

    }
    public void increaseScore(View view){
        score++;
        scoreView.setText("Score: "+ score);

    }

    public void hideImages(){

  handler = new Handler();
  runnable = new Runnable() {
      @Override
      public void run() {
          for(ImageView image: imageArray){

              image.setVisibility(View.INVISIBLE);
          }

          Random random = new Random();

          int i = random.nextInt(15);

          imageArray[i].setVisibility(View.VISIBLE);
          handler.postDelayed(this,1000);

      }
  };
  handler.post(runnable);


    }


}
