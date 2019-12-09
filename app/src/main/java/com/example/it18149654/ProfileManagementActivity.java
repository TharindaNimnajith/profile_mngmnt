package com.example.it18149654;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import Database.DBHelper;

public class ProfileManagementActivity extends AppCompatActivity {

    private EditText et_username, et_password, et_dob;
    private Button btn_update_profile;
    private RadioGroup rg_gender;
    private RadioButton rb;
    private String gender;

    private DBHelper dbHelper;

    private String username, dob, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_management);

        et_username = findViewById(R.id.et_uname);
        et_password = findViewById(R.id.et_pwd);
        et_dob = findViewById(R.id.et_dob);

        btn_update_profile = findViewById(R.id.btn_update);

        rg_gender = findViewById(R.id.rg_gender);

        dbHelper = new DBHelper(this);

        btn_update_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = et_username.getText().toString().trim();
                password = et_password.getText().toString().trim();
                dob = et_dob.getText().toString().trim();

                //gender

                long id = dbHelper.addInfo(username, password, dob);

                if (id == -1)
                    Toast.makeText(ProfileManagementActivity.this, "Error", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(ProfileManagementActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
