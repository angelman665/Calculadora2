package com.example.calculadora2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class actv_calculadora extends AppCompatActivity implements View.OnClickListener {

    // CRIAÇÃO DE VARIAVEIS
    TextView txtvisor;
    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0;
    Button btmais, btmenos, btvezes, btdivide, btigual;
    int n1, n2, resultado;
    int cmais = 0, cmenos = 0;
    String resultadoTexto;

    // CODIGO EXECUTADO ASSIM QUE É SELECIONADA A OPÇÃO "CALCULADORA" NO MENU
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // MOSTRA O LAYOUT DA CALCULADORA
        setContentView(R.layout.activity_actv_calculadora);
        // CONECTA O VISOR COM A VARIAVEL "txtvisor"
        txtvisor = findViewById(R.id.txt_visor_calculadora);
        // CONECÇÃO DE BUTÕES DO LAYOUT COM AS VARIAVEIS
        btmais = findViewById(R.id.btmais);
        btmais.setOnClickListener(this);
        btmenos = findViewById(R.id.btmenos);
        btmenos.setOnClickListener(this);
        btvezes = findViewById(R.id.btvezes);
        btvezes.setOnClickListener(this);
        btdivide = findViewById(R.id.btdivide);
        btdivide.setOnClickListener(this);
        btigual = findViewById(R.id.btigual);
        btigual.setOnClickListener(this);

        bt1 = findViewById(R.id.bt_1_calculadora);
        bt1.setOnClickListener(this);
        bt2 = findViewById(R.id.bt_2_calculadora);
        bt2.setOnClickListener(this);
        bt3 = findViewById(R.id.bt_3_calculadora);
        bt3.setOnClickListener(this);
        bt4 = findViewById(R.id.bt_4_calculadora);
        bt4.setOnClickListener(this);
        bt5 = findViewById(R.id.bt_5_calculadora);
        bt5.setOnClickListener(this);
        bt6 = findViewById(R.id.bt_6_calculadora);
        bt6.setOnClickListener(this);
        bt7 = findViewById(R.id.bt_7_calculadora);
        bt7.setOnClickListener(this);
        bt8 = findViewById(R.id.bt_8_calculadora);
        bt8.setOnClickListener(this);
        bt9 = findViewById(R.id.bt_9_calculadora);
        bt9.setOnClickListener(this);
        bt0 = findViewById(R.id.bt_0_calculadora);
        bt0.setOnClickListener(this);


    }

    // CODIGO CORRIDO QUANDO É CLICADO UM BOTÃO
    @Override
    public void onClick(View v) {


        if (v.getId() == R.id.bt_1_calculadora)
            txtvisor.append("1");
        else if (v.getId() == R.id.bt_2_calculadora)
            txtvisor.append("2");
        else if (v.getId() == R.id.bt_3_calculadora)
            txtvisor.append("3");
        else if (v.getId() == R.id.bt_4_calculadora)
            txtvisor.append("4");
        else if (v.getId() == R.id.bt_5_calculadora)
            txtvisor.append("5");
        else if (v.getId() == R.id.btmais) {
            //criada um variavel "text" que recebe o valor atual do visor
            String text = txtvisor.getText().toString();
            //convertemos o String para Int e guardamos no n1
            n1 = Integer.parseInt(text);
            //adicionamos "+" no visor
            txtvisor.append("+");
        } else if (v.getId() == R.id.btigual) {
            //Quando o botão "=" é pressionado, chamamos o metodo calculo()
            calculo();
            //apaga-se tudo que estava no visor e coloca-se o resultado da conta
            txtvisor.setText(resultadoTexto);

        }


    }

    //Metodo onde se faz os calculos
    public void calculo() {
        //Por enquanto só funciona com calculo basico. Soma de 2 numeros ex:"123+213"

        String text = txtvisor.getText().toString();
        int posicao = text.indexOf('+');

        String text2 = text.substring(posicao + 1).trim();
        n2 = Integer.parseInt(text2);

        resultado = n1 + n2;
        resultadoTexto = String.valueOf(resultado);

    }
}