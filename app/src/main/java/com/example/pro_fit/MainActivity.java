package com.example.pro_fit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_go_register;

    public void initUi(){
        btn_go_register = findViewById(R.id.btn_goRegister);

    }

    public void setBtn_go_register(){
        btn_go_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TAG", "onClick: Cliquer");
                    startActivity(new Intent(MainActivity.this, Register.class));

            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
        setBtn_go_register();
    }
}