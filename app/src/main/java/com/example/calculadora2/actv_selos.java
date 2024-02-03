package com.example.calculadora2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class actv_selos extends AppCompatActivity implements View.OnClickListener {

    EditText txtvisor;
    TextView txtselo5, txtselo3;
    Button btGerarSelos, btLimpar, btVoltar;
    int valor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actv_selos);

        txtvisor = findViewById(R.id.txt_visor_selos);
        txtselo5 = findViewById(R.id.txt_selos5_selos);
        txtselo3 = findViewById(R.id.txt_selos3_selos);

        btGerarSelos = findViewById(R.id.bt_gerarselos_selos);
        btGerarSelos.setOnClickListener(this);

        btLimpar = findViewById(R.id.bt_limpar_selos);
        btLimpar.setOnClickListener(this);

        btVoltar = findViewById(R.id.bt_voltar_selos);
        btVoltar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.bt_gerarselos_selos) {
            String visor = txtvisor.getText().toString();

            if (!visor.isEmpty()) {
                valor = Integer.parseInt(visor);

                logicaSelos();
                txtvisor.setEnabled(false); // or editText.setFocusable(false);
                btGerarSelos.setEnabled(false);

            }
        } else if (v.getId() == R.id.bt_limpar_selos) {
            txtvisor.setText("");
            txtselo3.setText("");
            txtselo5.setText("");
            txtvisor.setEnabled(true);
            btGerarSelos.setEnabled(true);

        } else if (v.getId() == R.id.bt_voltar_selos) {
            Intent it = new Intent(actv_selos.this, MainActivity.class);
            startActivity(it);
        }

    }


    public void logicaSelos() {
        int quoc, r, s5 = 0, s3 = 0;
        String selo5, selo3;


        //System.out.println("Introduza um valor: ");
        // int valor = scan.nextInt();

        if (valor >= 8) {

            quoc = valor / 8;
            r = valor % 8;
            switch (r) {
                case 0:
                    s3 = quoc;
                    s5 = quoc;
                    break;
                case 1:
                    s3 = quoc + 2;
                    s5 = quoc - 1;
                    break;
                case 2:
                    s3 = quoc - 1;
                    s5 = quoc + 1;
                    break;
                case 3:
                    s3 = quoc + 1;
                    s5 = quoc;
                    break;
                case 4:
                    s3 = quoc + 3;
                    s5 = quoc - 1;
                    break;
                case 5:
                    s3 = quoc;
                    s5 = quoc + 1;
                    break;
                case 6:
                    s3 = quoc + 2;
                    s5 = quoc;
                    break;
                case 7:
                    s3 = quoc - 1;
                    s5 = quoc + 2;
                    break;

            }

        } else {

            if (valor == 3) {
                s3 = 1;
                s5 = 0;
            } else if (valor == 5) {
                s3 = 0;
                s5 = 1;
            } else if (valor == 6) {
                s3 = 2;
                s5 = 0;
            } else {
                txtvisor.setText("nº Invalido");
            }

        }

        selo5 = String.valueOf(s5);
        txtselo5.append(selo5);
        selo3 = String.valueOf(s3);
        txtselo3.append(selo3);
    }


}
