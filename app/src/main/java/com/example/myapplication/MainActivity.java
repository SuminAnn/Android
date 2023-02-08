package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button btn_move;
    private EditText et_text;
    private  String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_text = findViewById(R.id.et_text);

        btn_move = findViewById(R.id.btn_move);

        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = et_text.getText().toString(); //editText의 값을 String으로 변환
                Intent intent = new Intent(MainActivity.this, FragmentActivity.class); //(기존화면, 이동하고싶은 화면)
                intent.putExtra("str",str); //putExtra(data를 담는다)
                startActivity(intent); // 액티비티 이동
            }
        });
    }


}