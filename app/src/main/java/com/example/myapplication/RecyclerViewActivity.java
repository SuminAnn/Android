package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private List<ItemList> itemList;
    private CustomRecyclerAdapter customRecyclerAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager; // recyclerView에서 쓰인다

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        itemList = new ArrayList<>();
        customRecyclerAdapter = new CustomRecyclerAdapter(itemList); //Data를 담는 adapter
        recyclerView.setAdapter(customRecyclerAdapter);

        Button btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemList.size()<10){
                    ItemList item = new ItemList(itemList.size()+1,R.drawable.ic_launcher_background, "orion", "orionpass");
                    itemList.add(item);
                    customRecyclerAdapter.notifyDataSetChanged(); // 새로고침
                }else{
                    Toast.makeText(RecyclerViewActivity.this, "최대 10개까지 추가 가능합니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // 기존에는 ListView를 통해 스크롤되는 리스트를 표현했다.
    // ListView는 스크롤시 버벅임(데이터의 Item만큼 뷰를 생성), 기본 애니메이션 지원X, 수직 스크롤만 지원 등의
    // 문제점을 해결하기 위해 RecyclerView가 등장했다다
    // RecyclerView는 데이터 집합을 개별 아이템 단위로 구성하여 출력하는 ViewGroup이다 또한 재사용성이 좋다
    // View 객체 자체를 재사용하면서 View가 담고 있는 데이터만 바인딩한다
}