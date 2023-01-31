package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ToastImageViewActivity extends AppCompatActivity {

    ImageView iv_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_image_view);
        iv_test = (ImageView) findViewById(R.id.iv_test);
        Intent intent = getIntent();
        String str = intent.getStringExtra("str");

        iv_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                // Toast(Context, 문구, 길이).show()
            }
        });
    }
}