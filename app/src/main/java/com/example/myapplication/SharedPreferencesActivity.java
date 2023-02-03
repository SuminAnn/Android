package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class SharedPreferencesActivity extends AppCompatActivity {

    private EditText et_save;
    private String shared = "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        et_save = (EditText) findViewById(R.id.et_save);

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        String value = sharedPreferences.getString("value", ""); //두번쨰 인자는 꺼내오는 거기 때문에 ""을 입력
        et_save.setText(value);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String value = et_save.getText().toString(); //editText에 String을 가져온다
        editor.putString("value", value);
        editor.commit();
    } // 앱을 종료시(Activity를 벗어났을때)

    //SharedPreferences : 앱을 종료후 재실행시(앱이 지워지기 전까지) data가 남아 있을 수 있도록 사용하는 함수
    // 설정 값들을 지정할떄 많이 사용한다, 앱을 삭제시에는 사라진다(임시저장이기 떄문)
}