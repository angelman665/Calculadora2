package com.example.calculadora2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DBInsert extends AppCompatActivity implements View.OnClickListener{

    EditText jogador_input, idade_jogador_input;
    Button bt_inserir;

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_insert);
        jogador_input = findViewById(R.id.edit_insert_nomeJogador);
        idade_jogador_input = findViewById(R.id.edit_insert_idadeJogador);
        bt_inserir = findViewById(R.id.bt_insert_insert);
        bt_inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MySQL myDB = new MySQL(DBInsert.this); //Cria objeto da classe MySQL capaz de usar os metodos de criação da BD
                myDB.inserirJogador(jogador_input.getText().toString(),
                        Integer.parseInt(idade_jogador_input.getText().toString())); //Passa os parâmetros necerrários do método InserirEquipa
                finish();
            }
        });
    }
}
