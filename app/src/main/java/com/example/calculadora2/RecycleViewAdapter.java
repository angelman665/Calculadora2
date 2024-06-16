package com.example.calculadora2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{

    private Context context;
    Activity activity;
    private ArrayList id_jogador, nome_jogador, idade_jogador;
    int position;

    RecycleViewAdapter(actv_jogadores activity,
                       Context context,
                       ArrayList id_jogador,
                       ArrayList nome_jogador,
                       ArrayList idade_jogador) { //Construtor do RecycleViewAdapter
        this.activity = activity;
        this.context = context;
        this.id_jogador = id_jogador;
        this.nome_jogador = nome_jogador;
        this.idade_jogador = idade_jogador;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //Inflate da Recycle view
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_jogador, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {//Popula a RecycleView com os dados
        this.position = position;
        holder.id_jogador_txt.setText(id_jogador.get(position).toString());
        holder.nome_jogador_txt.setText(nome_jogador.get(position).toString());
        holder.idade_jogador_txt.setText(idade_jogador.get(position).toString());
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Armazena no intent os dados dos campos da RecyclerView clicada, para serem enviado à classe de Update que irá mostrar os dados na View de Update
                Intent intent = new Intent(context, DBUpdate.class);
                intent.putExtra("id_jogador", String.valueOf(id_jogador.get(position)));
                intent.putExtra("nome_jogador", String.valueOf(nome_jogador.get(position)));
                intent.putExtra("idade_jogador", String.valueOf(idade_jogador.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return id_jogador.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id_jogador_txt, nome_jogador_txt, idade_jogador_txt;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id_jogador_txt = itemView.findViewById(R.id.edit_idjogador_itemjogador);
            nome_jogador_txt = itemView.findViewById(R.id.edit_nome_jogador);
            idade_jogador_txt = itemView.findViewById(R.id.edit_idade_jogador);
            mainLayout = itemView.findViewById(R.id.itemjogador);
        }
    }

}
