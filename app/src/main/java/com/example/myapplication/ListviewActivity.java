package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListviewActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        listView = (ListView) findViewById((R.id.lv_list));

        List<String> data = new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data); //Listview와 List를 연결하는(Activity, ListView Form)
        listView.setAdapter(adapter);

        data.add("안녕하세요");
        data.add("반갑습니다");
        data.add("안드로이드");
        adapter.notifyDataSetChanged(); //저장
    }
}