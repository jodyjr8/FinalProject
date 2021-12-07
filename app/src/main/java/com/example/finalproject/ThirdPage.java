package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;

public class ThirdPage extends AppCompatActivity {

    private boolean nothingAte;
    private ImageView mPedestal;
    private ImageView mPedestalGem;
    private TextView mFirstScene;
    private TextView mSecondScene;
    private TextView mThirdScene;
    private Button mReplaceGem;
    private Button mLeaveGem;
    private TextView mEndScene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_page);

        Intent intent = getIntent();
        String decision =intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        if(decision.equals("nothing")){
            nothingAte=true;
        }
        mPedestal = findViewById(R.id.pedestal);
        mPedestalGem = findViewById(R.id.pedestalgem);
        mFirstScene = findViewById(R.id.first_scene);
        mSecondScene = findViewById(R.id.second_scene);
        mThirdScene = findViewById(R.id.third_scene);
        mReplaceGem = findViewById(R.id.replace);
        mLeaveGem = findViewById(R.id.leave);
        mEndScene = findViewById(R.id.end_scene);

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


    public void gemReplaced(View view) {
        mPedestal.setVisibility(View.VISIBLE);
        mPedestalGem.setVisibility(View.INVISIBLE);
        mFirstScene.setVisibility(View.INVISIBLE);
        mSecondScene.setVisibility(View.VISIBLE);
        mLeaveGem.setEnabled(false);
        mReplaceGem.setEnabled(false);
        if(nothingAte){
            mReplaceGem.setVisibility(View.INVISIBLE);
            mLeaveGem.setVisibility(View.INVISIBLE);
            mThirdScene.setVisibility(View.VISIBLE);
        }
        else {
            mEndScene.setVisibility(View.VISIBLE);
        }
    }
    public void leaveGem(View view){
        mFirstScene.setVisibility(View.INVISIBLE);
        mSecondScene.setVisibility(View.VISIBLE);
        mSecondScene.setText(R.string.leftgem);
        mLeaveGem.setEnabled(false);
        mReplaceGem.setEnabled(false);
    }

}