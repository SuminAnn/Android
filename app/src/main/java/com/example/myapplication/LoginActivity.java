package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText et_id;
    private EditText et_pass;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_id = (EditText)findViewById(R.id.et_id);
        et_pass = (EditText)findViewById(R.id.et_pass);
        btn_login = (Button) findViewById(R.id.btn_login);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = et_id.getText().toString();
                String pass = et_pass.getText().toString();
                if(id.equals("orion") && pass.equals("orionpass")){
                    Intent intent = new Intent(LoginActivity.this, RecyclerViewActivity.class);
                    intent.putExtra("id", id);
                    intent.putExtra("pwd", pass);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "아이디와 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show();
                }
//                Toast.makeText(LoginActivity.this, "id : " + id + "\n" + "pass : " + pass, Toast.LENGTH_SHORT).show();
            }
        });
    }
}