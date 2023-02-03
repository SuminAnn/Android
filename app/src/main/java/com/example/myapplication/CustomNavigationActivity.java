package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CustomNavigationActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private View draerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_navigation);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        draerView = (View) findViewById(R.id.drawer);

        Button btn_open = (Button) findViewById(R.id.btn_open);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(draerView);
            }
        });

        drawerLayout.setDrawerListener(listener);
        draerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        Button btn_close = (Button) findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
            }
        });

    }

    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
            Toast.makeText(getApplicationContext(), "SLIDE", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {
            Toast.makeText(getApplicationContext(), "OPEN", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {
            Toast.makeText(getApplicationContext(), "CLOSE", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onDrawerStateChanged(int newState) {
            Toast.makeText(getApplicationContext(), "CHANGE", Toast.LENGTH_SHORT).show();

        }
    };
}