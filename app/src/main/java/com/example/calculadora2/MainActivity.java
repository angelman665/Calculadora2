package com.example.calculadora2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar mytoolbar;

    @SuppressLint("UseSupportActionBar")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytoolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(mytoolbar);

    }


    @SuppressLint({"RestrictedApi", "UseSupportActionBar"})
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ((MenuBuilder) menu).setOptionalIconsVisible(true);
        getMenuInflater().inflate(R.menu.mymenu, menu);
        //setActionBar(mytoolbar);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnu_calculadora_mymnu) {
            Intent it = new Intent(MainActivity.this, actv_calculadora.class);
            startActivity(it);
            Toast.makeText(this, "Calculadora", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.mnu_selos_mymnu) {
            Intent it = new Intent(MainActivity.this, actv_selos.class);
            startActivity(it);
            Toast.makeText(this, "Selos", Toast.LENGTH_SHORT).show();
        }
        ;
        return super.onOptionsItemSelected(item);
    }
}