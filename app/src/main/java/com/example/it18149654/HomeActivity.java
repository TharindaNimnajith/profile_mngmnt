package com.example.it18149654;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Database.DBHelper;

public class HomeActivity extends AppCompatActivity {

    private EditText et_username, et_password;
    private Button btn_login, btn_register;

    private String username, password;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);

        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);

        dbHelper = new DBHelper(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = et_username.getText().toString().trim();
                password = et_password.getText().toString().trim();

                boolean res = dbHelper.login(username, password);

                if (res) {
                    Intent intent = new Intent(HomeActivity.this, EditProfileActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(HomeActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ProfileManagementActivity.class);
                startActivity(intent);
            }
        });
    }
}
