package com.example.calculadora2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class DBUpdate extends AppCompatActivity {

    EditText input_nome, input_idade;
    Button btn_update,btn_delete;
    String id_jogador, nome_jogador, idade_jogador;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_update);

        input_nome = findViewById(R.id.edit_update_nomeJogador);
        input_idade = findViewById(R.id.edit_update_idadeJogador);
        getAndSetIntentData();
        btn_update = findViewById(R.id.bt_update_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome_jogador = input_nome.getText().toString().trim();
                String idade_jogador = input_idade.getText().toString().trim();
                MySQL myDB = new MySQL(DBUpdate.this);
                myDB.atualizarBD(id_jogador, nome_jogador, idade_jogador);
                finish();
            }
        });
        btn_delete = findViewById(R.id.bt_delete_update);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();//Chama método da caixa de dialogo que contem o método de apagar linha ds BD
            }
        });
    }

    //Método recupera os dados do item selecionado armazenados pelo Intent para serem mostrados no ecrã de update
    void getAndSetIntentData() {
        if (getIntent().hasExtra("id_jogador") && getIntent().hasExtra("nome_jogador") && getIntent().hasExtra("idade_jogador")) {
            //Pega dados do Intent
            id_jogador = getIntent().getStringExtra("id_jogador");
            nome_jogador = getIntent().getStringExtra("nome_jogador");
            idade_jogador = getIntent().getStringExtra("idade_jogador");
            //Define dados no EditText
            input_nome.setText(nome_jogador);
            input_idade.setText(idade_jogador);
            Log.d("stev",nome_jogador+""+idade_jogador);
        } else {
            Toast.makeText(this, "Erro ao recuperar dados", Toast.LENGTH_SHORT).show();
        }
    }

    //Caixa de dialogo para confirmação da intenção de apagar item
    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Apagar " + nome_jogador + "?");
        builder.setMessage("Tem a certeza que quer apagar " + nome_jogador + "?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MySQL myDB = new MySQL(DBUpdate.this);
                myDB.apagaUmaLinha(id_jogador); // Método que apaga a linha da BD
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }

}
