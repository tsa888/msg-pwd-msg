package com.ts.msg.invw.PwMgr;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText web_app_name, user_name, user_pwd;
    Button update_button, delete_button;

    String id, webapp, usrname, usrpwd;

    static {
        System.loadLibrary("PwMgr");
    }
    public native String deleteJNI();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        web_app_name = findViewById(R.id.web_app_name_update);
        user_name = findViewById(R.id.usr_name_update);
        user_pwd = findViewById(R.id.usr_pwd_update);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        getAndSetIntentData();

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                webapp = web_app_name.getText().toString().trim();
                usrname = user_name.getText().toString().trim();
                usrpwd = user_pwd.getText().toString().trim();
                myDB.updateData(id, webapp, usrname, usrpwd);
            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("webapp") &&
                getIntent().hasExtra("usrname") && getIntent().hasExtra("usrpwd")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            webapp = getIntent().getStringExtra("webapp");
            usrname = getIntent().getStringExtra("usrname");
            usrpwd = getIntent().getStringExtra("usrpwd");

            //Setting Intent Data
            web_app_name.setText(webapp);
            user_name.setText(usrname);
            user_pwd.setText(usrpwd);

        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + webapp + " ?");
        builder.setMessage("Do you want to delete " + webapp + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(id);
                deleteJNI();
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}
