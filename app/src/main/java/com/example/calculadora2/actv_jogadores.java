package com.example.calculadora2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class actv_jogadores extends AppCompatActivity implements View.OnClickListener{

    RecyclerView recyclerView;
    FloatingActionButton bt_adicionar;
    ArrayList<String> id_jogador,nome_jogador,idade_jogador;
    RecycleViewAdapter rvAdapter;
    MySQL myDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_jogadores);

        recyclerView = findViewById(R.id.recycleview_jogadores);
        bt_adicionar = findViewById(R.id.rv_float_bt_adicionar);
        bt_adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(actv_jogadores.this, DBInsert.class);
                startActivity(intent);
            }
        });

        myDB = new MySQL(actv_jogadores.this);
        id_jogador = new ArrayList<>();
        nome_jogador = new ArrayList<>();
        idade_jogador = new ArrayList<>();

        storeDataInArrays();
        rvAdapter = new RecycleViewAdapter(actv_jogadores.this,this,id_jogador,nome_jogador,idade_jogador);
        recyclerView.setAdapter(rvAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(actv_jogadores.this));
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            recreate();
        }
    }

    void storeDataInArrays(){ //busca os dados da BD e coloca nas arrays de cada elemento
        Cursor cursor = myDB.lerBD();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Nenhum registro encontrado", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()) {
                id_jogador.add(cursor.getString(0));
                nome_jogador.add(cursor.getString(1));
                idade_jogador.add(cursor.getString(2));
            }
        }
    }

}
