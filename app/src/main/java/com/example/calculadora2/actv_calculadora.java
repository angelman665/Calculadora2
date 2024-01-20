package com.example.calculadora2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class actv_calculadora extends AppCompatActivity implements View.OnClickListener {
    TextView txtvisor;
    Button btmais, btmenos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actv_calculadora);
        txtvisor = findViewById(R.id.txt_visor_calculadora);
        btmais = findViewById(R.id.btmais);
        btmais.setOnClickListener(this);
        btmenos = findViewById(R.id.btmenos);
        btmenos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btmais) {
            txtvisor.append("+");
        } else if (v.getId() == R.id.btmenos) {
            //txtvisor.append("-");
            finish();
        }
    }
}