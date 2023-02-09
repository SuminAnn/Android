package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DialogActivity extends AppCompatActivity {

    private Button btn_dialog;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        btn_dialog = (Button) findViewById(R.id.btn_dialog);
        tv_result = (TextView) findViewById(R.id.tv_result);

        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder(DialogActivity.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("Title");
                ad.setMessage("Dialog");

                final EditText et = new EditText(DialogActivity.this);
                ad.setView(et);

                ad.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String result = et.getText().toString();
                        tv_result.setText(result);
                        dialog.dismiss(); // 현재 다이어로그 종료
                    }
                });

                ad.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); // 현재 다이어로그 종료
                    }
                });
                ad.show();
            }
        });
    }
}//Dialog : 팝업창