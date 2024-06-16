package com.example.calculadora2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MySQL extends SQLiteOpenHelper {

    private Context context;
    private static final String DB_NOME = "JogadoresDB.db";
    private static final int DB_VERSAO = 1;

    private static final String TABELA_NOME = "jogadores";
    private static final String COLUNA_ID = "_id";
    private static final String COLUNA_JOGADORES = "nome_jogador";
    private static final String COLUNA_IDADE = "idade_jogador";

    public MySQL(@Nullable Context context) {
        super(context, DB_NOME, null, DB_VERSAO);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABELA_NOME +
                " (" + COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUNA_JOGADORES + " TEXT, " +
                COLUNA_IDADE + " INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_NOME);
        onCreate(db);
    }


    void inserirJogador(String jogador, int idade_jogador) {
        SQLiteDatabase db = this.getWritableDatabase(); //método pertence à classe SQLOpenHelper serve para escrever dados na tabela
        ContentValues cv = new ContentValues(); //Armazena os dados da app para repassar para a base de dados.

        cv.put(COLUNA_JOGADORES, jogador); //Método para inserir dados na coluna, recebendo o respectivo parâmetro
        cv.put(COLUNA_IDADE, idade_jogador);
        long result = db.insert(TABELA_NOME, null, cv); //Método insere os dados contidos na variável de ContentValues nas respectivas colunas da base de dados
        if (result == -1) {
            Toast.makeText(context, "Falhou", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Inserido com Sucesso", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor lerBD(){
        String query = "SELECT * FROM " + TABELA_NOME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }

    void atualizarBD(String id_coluna,String nome_jogador, String idade_jogador){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUNA_JOGADORES, nome_jogador);
        cv.put(COLUNA_IDADE, idade_jogador);
        long result = db.update(TABELA_NOME, cv,  " _id=?", new String[]{id_coluna});
        if (result == -1) {
            Toast.makeText(context,"Failed to update", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context,"Successfully Updated!", Toast.LENGTH_SHORT).show();
        }
    }

    void apagaUmaLinha(String id_linha){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABELA_NOME,"_id=?",new String[]{id_linha});
        if (result == -1) {
            Toast.makeText(context,"Failed to delete", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context,"Successfully Deleted", Toast.LENGTH_SHORT).show();
        }
    }

}
