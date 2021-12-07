package com.example.finalproject;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import org.w3c.dom.Text;


public class SecondPage extends AppCompatActivity {

    private String mDecisionPicked;
    public static final String EXTRA_MESSAGE = "com.example.finalproject.extra.MESSAGE";
    private TextView mTextView;
    private TextView mTextView2;
    private ImageView mWorldFire;
    private ImageView mCabinKitchen;
    private TextView mGameOver;
    private Button mEatFood;
    private Button mEatNothing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondpage);

        mTextView = findViewById(R.id.textview);
        mTextView2 = findViewById(R.id.textview2);
        mWorldFire = findViewById(R.id.world_fire);
        mCabinKitchen = findViewById(R.id.cabin_kitchen);
        mGameOver = findViewById(R.id.game_over);
        mEatFood = findViewById(R.id.eat_food);
        mEatNothing = findViewById(R.id.eat_nothing);

        Intent intent = getIntent();
        String decision =intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //mTextView.setText(decision); Test to confirm intent pass

        if(decision.equals("sleep")){
            mWorldFire.setVisibility(View.VISIBLE);
            mTextView.setText(R.string.end_world1);
            mGameOver.setVisibility(View.VISIBLE);
            mTextView.setVisibility(View.VISIBLE);
        }
        if(decision.equals("wakeUp")){
            mCabinKitchen.setVisibility(View.VISIBLE);
            mTextView2.setText(R.string.second_story1);
            mTextView2.setVisibility(View.VISIBLE);
            mEatNothing.setVisibility(View.VISIBLE);
            mEatFood.setVisibility(View.VISIBLE);
        }

    }

    public void eatNothing(View view) {
        mDecisionPicked = "nothing";
        Intent intent = new Intent(SecondPage.this, ThirdPage.class);
        intent.putExtra(EXTRA_MESSAGE, mDecisionPicked);
        startActivity(intent);
    }

    public void eatFood(View view) {
        mDecisionPicked = "ate";
        Intent intent = new Intent(SecondPage.this, ThirdPage.class);
        intent.putExtra(EXTRA_MESSAGE, mDecisionPicked);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.night_mode) {
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }
        return true;
    }
}
