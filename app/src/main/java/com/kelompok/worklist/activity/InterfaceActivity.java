package com.kelompok.worklist.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kelompok.worklist.R;

public class InterfaceActivity extends AppCompatActivity {
    private int waktu_loading = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home = new Intent(InterfaceActivity.this, MainActivity.class);
                startActivity(home);
                finish();
            }
        },waktu_loading);
    }
}
