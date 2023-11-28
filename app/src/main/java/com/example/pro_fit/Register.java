package com.example.pro_fit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Register extends AppCompatActivity {

    TextInputEditText editFirstName, editLastName, editMail, editPassword;
    Button buttonReg, buttonLog;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editFirstName = findViewById(R.id.et_firstname);
        editLastName = findViewById(R.id.et_lastname);
        editMail = findViewById(R.id.et_mail);
        editPassword = findViewById(R.id.et_password);
        buttonReg = findViewById(R.id.btn_register);
        buttonLog = findViewById(R.id.btn_login);

        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,password, fname, lname;
                email = String.valueOf(editMail.getText());
                password = String.valueOf(editPassword.getText());
                fname = String.valueOf(editFirstName.getText());
                lname = String.valueOf(editLastName.getText());

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Register.this, "Entrez un email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Register.this, "Entrez un mot de passe", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(fname)){
                    Toast.makeText(Register.this, "Entrez un nom", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(lname)){
                    Toast.makeText(Register.this, "Entrez un prénom", Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });


    }
}