package com.geren.sudoku.level;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.geren.sudoku.R;
import com.geren.sudoku.main.view.MainActivity;

public class LevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
    }

    public void gotoMain(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }


}
