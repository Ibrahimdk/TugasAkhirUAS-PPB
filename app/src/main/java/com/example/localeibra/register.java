package com.example.localeibra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_act);
    }

    public void registerbtn(View view) {
        Intent it = new Intent(register.this, loginact.class );
        startActivity(it);
    }
}