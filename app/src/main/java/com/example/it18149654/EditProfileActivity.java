package com.example.it18149654;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import Database.DBHelper;

public class EditProfileActivity extends AppCompatActivity {

    private EditText et_username, et_password, et_dob;
    private Button btn_search, btn_edit, btn_delete;
    private RadioGroup rg_gender;
    private RadioButton rb;

    private DBHelper dbHelper;

    private String username, password, dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        et_username = findViewById(R.id.et_uname_crud);
        et_password = findViewById(R.id.et_pwd_crud);
        et_dob = findViewById(R.id.et_dob_crud);

        btn_search = findViewById(R.id.btn_search_crud);
        btn_edit = findViewById(R.id.btn_edit_crud);
        btn_delete = findViewById(R.id.btn_delete_crud);

        rg_gender = findViewById(R.id.rg_gender);

        dbHelper = new DBHelper(this);

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = et_username.getText().toString().trim();
                password = et_password.getText().toString().trim();
                dob = et_dob.getText().toString().trim();

                /*
                boolean res = dbHelper.updateInfo();

                if (res) {
                    Toast.makeText(EditProfileActivity.this, "Success", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(EditProfileActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(EditProfileActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
                */
            }
        });

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = et_username.getText().toString().trim();

                //dbHelper.readAllInfo(id);
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean res = dbHelper.deleteInfo();

                if (res) {
                    Toast.makeText(EditProfileActivity.this, "Success", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(EditProfileActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(EditProfileActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
