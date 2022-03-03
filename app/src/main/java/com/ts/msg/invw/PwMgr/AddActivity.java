package com.ts.msg.invw.PwMgr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText web_app_name, user_name, user_pwd;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        web_app_name = findViewById(R.id.web_app_name);
        user_name = findViewById(R.id.usr_name);
        user_pwd = findViewById(R.id.usr_pwd);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addRecord(web_app_name.getText().toString().trim(),
                        user_name.getText().toString().trim(),
                        user_pwd.getText().toString().trim());
            }
        });
    }
}