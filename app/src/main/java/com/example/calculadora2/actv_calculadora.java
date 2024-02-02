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
    Button btlimpaAll, btvirgula, btapagaUm;
    boolean novoCalculo = true, negativo = false;

    double resultado, n1, n2;
    String resultadoTexto, simbolo, menos = "-";

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

        btlimpaAll = findViewById(R.id.bt_limpatext_calc);
        btlimpaAll.setOnClickListener(this);

        btvirgula = findViewById((R.id.btvirgula));
        btvirgula.setOnClickListener(this);

        btapagaUm = findViewById(R.id.bt_apagaUm);
        btapagaUm.setOnClickListener(this);


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
        else if (v.getId() == R.id.bt_6_calculadora)
            txtvisor.append("6");
        else if (v.getId() == R.id.bt_7_calculadora)
            txtvisor.append("7");
        else if (v.getId() == R.id.bt_8_calculadora)
            txtvisor.append("8");
        else if (v.getId() == R.id.bt_9_calculadora)
            txtvisor.append("9");
        else if (v.getId() == R.id.bt_0_calculadora)
            txtvisor.append("0");
            // BOTÃO MAIS++++++++++
        else if (v.getId() == R.id.btmais) {
            String text = txtvisor.getText().toString();
            simbolo = "+";


            if (text.endsWith("+") || text.endsWith("-") || text.endsWith("*") || text.endsWith("/") || text.endsWith(".")) {
                text = text.substring(0, text.length() - 1);
                txtvisor.setText(text + simbolo);
            } else if (stringVazia(text) == 0)
                txtvisor.setText("");
            else if (text.startsWith("-"))
                txtvisor.setText(text + "+");
            else
                logicaBt_operacao();

        }
        // BOTÃO MENOS---------------------
        else if (v.getId() == R.id.btmenos) {
            String text = txtvisor.getText().toString();
            simbolo = "-";

            if (text.endsWith("+") || text.endsWith("-") || text.endsWith("*") || text.endsWith("/") || text.endsWith(".")) {
                text = text.substring(0, text.length() - 1);
                txtvisor.setText(text + simbolo);
            } else if (stringVazia(text) == 0)
                txtvisor.append("-");
            else
                logicaBt_operacao();

        }
        // BOTÃO VEZES **************************
        else if (v.getId() == R.id.btvezes) {
            String text = txtvisor.getText().toString();
            simbolo = "*";

            if (text.endsWith("+") || text.endsWith("-") || text.endsWith("*") || text.endsWith("/") || text.endsWith(".")) {
                text = text.substring(0, text.length() - 1);
                txtvisor.setText(text + simbolo);
            } else if (stringVazia(text) == 0)
                txtvisor.setText("");
            else if (text.startsWith("-"))
                txtvisor.setText(text + "*");
            else
                logicaBt_operacao();
        }
        //BOTÃO DIVIDIR/////////////////////////////
        else if (v.getId() == R.id.btdivide) {

            String text = txtvisor.getText().toString();
            simbolo = "/";

            if (text.endsWith("+") || text.endsWith("-") || text.endsWith("*") || text.endsWith("/") || text.endsWith(".")) {
                text = text.substring(0, text.length() - 1);
                txtvisor.setText(text + simbolo);
            } else if (stringVazia(text) == 0)
                txtvisor.setText("");
            else if (text.startsWith("-"))
                txtvisor.setText(text + "/");
            else
                logicaBt_operacao();
        }
        // TODO ACABAR LOGICA DO BOTÃO IGUAL
        else if (v.getId() == R.id.btigual) {
            String text = txtvisor.getText().toString();
            if (text.endsWith("+") || text.endsWith("-") || text.endsWith("*") || text.endsWith("/") || text.endsWith(".")) {
                text = text.substring(0, text.length() - 1);
                txtvisor.setText(text);
            } else if (stringVazia(text) == 0)
                txtvisor.setText("");
            else if (text.indexOf('+') != -1 || text.indexOf('-') != -1 || text.indexOf('*') != -1 || text.indexOf('/') != -1) {
                calculo();
                text = txtvisor.getText().toString();
                n1 = intOuDouble(text);
                novoCalculo = true;

            }


        } else if (v.getId() == R.id.bt_limpatext_calc) {
            txtvisor.setText("");
            novoCalculo = true;

        } else if (v.getId() == R.id.btvirgula) {
            String text = txtvisor.getText().toString();
            if (text.indexOf('.') == -1) {
                if (text == "") {
                    text = "0.";
                    txtvisor.setText(text);
                } else if (text.endsWith("+") || text.endsWith("-") || text.endsWith("*") || text.endsWith("/")) {
                    text = text.substring(0, text.length() - 1);
                    txtvisor.setText(text + ".");
                } else
                    txtvisor.setText(text + ".");
            } else {
                if (text.indexOf('+') != -1 || text.indexOf('-') != -1 || text.indexOf('*') != -1 || text.indexOf('/') != -1) {
                    int count = 0;
                    for (int i = 0; i < text.length(); i++) {
                        if (text.charAt(i) == '.') {
                            count++;
                        }
                    }
                    if (text.endsWith("+") || text.endsWith("-") || text.endsWith("*") || text.endsWith("/")) {

                    } else if (count < 2)
                        txtvisor.setText(text + ".");

                }
            }
        } else if (v.getId() == R.id.bt_apagaUm) {
            String text = txtvisor.getText().toString();

            if (stringVazia(text) == 0) {
                txtvisor.setText("");
                novoCalculo = true;
            } else {
                text = text.substring(0, text.length() - 1);
                txtvisor.setText(text);
                if (stringVazia(text) == 0)
                    novoCalculo = true;
            }

        }
    }

    //Metodo onde se faz os calculos
    public void calculo() {
        //Por enquanto só funciona com calculo basico. Soma de 2 numeros ex:"123+213"

        String text = txtvisor.getText().toString();


        if (text.indexOf('+') != -1) {

            int posicao = text.indexOf('+');
            String text2 = text.substring(posicao + 1).trim();
            n2 = intOuDouble(text2);
            resultado = n1 + n2;


            mostraResultado();
        } else if (text.indexOf('*') != -1) {
            int posicao = text.indexOf('*');
            String text2 = text.substring(posicao + 1).trim();
            n2 = intOuDouble(text2);
            resultado = n1 * n2;

            mostraResultado();
        } else if (text.indexOf('/') != -1) {
            int posicao = text.indexOf('/');
            String text2 = text.substring(posicao + 1).trim();
            n2 = intOuDouble(text2);
            resultado = n1 / n2;

            mostraResultado();
        } else {
            if (text.startsWith("-")) {
                int posicao1 = text.indexOf("-");
                int posicao2 = text.indexOf("-", posicao1 + 1);
                String text2 = text.substring(posicao2 + 1).trim();
                n2 = intOuDouble(text2);
                resultado = n1 - n2;

                mostraResultado();
            } else {
                int posicao = text.indexOf('-');
                String text2 = text.substring(posicao + 1).trim();
                n2 = intOuDouble(text2);
                resultado = n1 - n2;

                mostraResultado();
            }
        }

    }

    // Metodo serve para ver se o resultado é double ou int - escreve resultado no textview
    public void mostraResultado() {
        if (resultado % 1 == 0)
            resultadoTexto = String.valueOf((int) resultado);
        else
            resultadoTexto = String.valueOf(resultado);


        txtvisor.setText(resultadoTexto);

    }


    public double intOuDouble(String texto1) {

        try {
            double nTemp = Integer.parseInt(texto1);
            return nTemp;
        } catch (NumberFormatException e1) {
            double nTemp = Double.parseDouble(texto1);
            return nTemp;
        }
    }

    public int stringVazia(String text1) {

        int count = 0;
        for (int i = 0; i < text1.length(); i++) {
            count++;
        }
        return count;
    }


    public void logicaBt_operacao() {


        if (novoCalculo) {
            String text = txtvisor.getText().toString();
            if (simbolo == "+") {
                n1 = intOuDouble(text);
                txtvisor.append("+");
                novoCalculo = false;
            } else if (simbolo == "-") {

                n1 = intOuDouble(text);
                txtvisor.append("-");
                novoCalculo = false;
            } else if (simbolo == "*") {
                n1 = intOuDouble(text);
                txtvisor.append("*");
                novoCalculo = false;
            } else if (simbolo == "/") {
                n1 = intOuDouble(text);
                txtvisor.append("/");
                novoCalculo = false;
            }
        } else {
            String text = txtvisor.getText().toString();
            if (simbolo == "+") {
                calculo();
                text = txtvisor.getText().toString();
                n1 = intOuDouble(text);
                txtvisor.append("+");

            } else if (simbolo == "-") {
                calculo();
                text = txtvisor.getText().toString();
                n1 = intOuDouble(text);
                txtvisor.append("-");
            } else if (simbolo == "*") {
                calculo();
                text = txtvisor.getText().toString();
                n1 = intOuDouble(text);
                txtvisor.append("*");

            } else if (simbolo == "/") {
                calculo();
                text = txtvisor.getText().toString();
                n1 = intOuDouble(text);
                txtvisor.append("/");
            }
        }

    }


}