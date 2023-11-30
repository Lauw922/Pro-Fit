package com.example.pro_fit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {

    Button btn_login, btn_register;
    EditText et_first_name, et_last_name, et_mail, et_password;
    FirebaseAuth mAuth;



    public void initUi(){
        mAuth = FirebaseAuth.getInstance();
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);
        et_first_name = findViewById(R.id.et_firstname);
        et_last_name = findViewById(R.id.et_lastname);
        et_mail = findViewById(R.id.et_mail);
        et_password = findViewById(R.id.et_password);
    }

    public void setBtn_login(){
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this, Login.class));

            }
        });
    }


    public void setBtn_register(){
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, password, fname, lname;
                email = String.valueOf(et_mail.getText());
                password = String.valueOf(et_password.getText());
                fname = String.valueOf(et_first_name.getText());
                lname = String.valueOf(et_last_name.getText());

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

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Toast.makeText(Register.this, "Account created",
                                            Toast.LENGTH_SHORT).show();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(Register.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initUi();
        setBtn_login();
        setBtn_register();
    }

}