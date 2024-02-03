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
    Button btlimpaAll, btvirgula, btapagaUm, btfact, btpositnegativ;
    boolean novoCalculo = true, temPonto = false;

    double resultado, n1, n2;
    String resultadoTexto, simbolo;
    int count = 0;

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

        btfact = findViewById(R.id.bt_factorial_calc);
        btfact.setOnClickListener(this);

        btpositnegativ = findViewById(R.id.bt_positnegat_calc);
        btpositnegativ.setOnClickListener(this);


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


            if (text.endsWith("+") || text.endsWith("-") || text.endsWith("*") || text.endsWith("/") || text.endsWith(".")) { // se o texto acabar num dos simbolos entra no if
                if (text.startsWith("-") || text.startsWith(".")) { // se começar com "-" ou "." entra no if
                    text = text.substring(0, text.length() - 1); //apaga-se o ultimo char da string
                    txtvisor.setText(text); // mostrar a string no visor
                    novoCalculo = true; //não há simbolo depois do numero - novo calculo
                } else {
                    text = text.substring(0, text.length() - 1); //apaga-se o ultimo char da string
                    txtvisor.setText(text + simbolo); // mostrar a string no visor
                }

            } else if (stringVazia(text) == 0) // se a string estiver vazia
                txtvisor.setText(""); // mostramos a string vazia
            else if (text.startsWith("-")) { // se a string começar com "-"
                logicaBt_operacao(); // faz a logica da operação - entra no metodo
                //txtvisor.setText(text + "+");
            } else
                logicaBt_operacao(); // faz a logica da operação - entra no metodo

        }
        // BOTÃO MENOS---------------------
        else if (v.getId() == R.id.btmenos) {
            String text = txtvisor.getText().toString();
            simbolo = "-";


            if (text.endsWith("+") || text.endsWith("-") || text.endsWith("*") || text.endsWith("/") || text.endsWith(".")) { // se o texto acabar num dos simbolos entra no if
                text = text.substring(0, text.length() - 1); // se começar com "-" ou "." entra no if
                txtvisor.setText(text + simbolo); // Coloca-se o simbolo no visor
            } else if (stringVazia(text) == 0) // se a string estiver vazia
                txtvisor.append("-");
            else
                logicaBt_operacao();// faz a logica da operação - entra no metodo

        }
        // BOTÃO VEZES **************************
        else if (v.getId() == R.id.btvezes) {
            String text = txtvisor.getText().toString();
            simbolo = "*";
//AQUI A LOGICA REPETE-SE COMO NO BOTÃO MAIS
            if (text.endsWith("+") || text.endsWith("-") || text.endsWith("*") || text.endsWith("/") || text.endsWith(".")) {// se o texto acabar num dos simbolos entra no if
                if (text.startsWith("-") || text.startsWith(".")) {
                    text = text.substring(0, text.length() - 1);
                    txtvisor.setText(text);
                    novoCalculo = true;
                } else {
                    text = text.substring(0, text.length() - 1);
                    txtvisor.setText(text + simbolo);
                }
            } else if (stringVazia(text) == 0)
                txtvisor.setText("");
            else if (text.startsWith("-"))
                txtvisor.setText(text + "*");
            else
                logicaBt_operacao();
        }
        //BOTÃO DIVIDIR/////////////////////////////
        else if (v.getId() == R.id.btdivide) {
//AQUI A LOGICA REPETE-SE COMO NO BOTÃO MAIS
            String text = txtvisor.getText().toString();
            simbolo = "/";

            if (text.endsWith("+") || text.endsWith("-") || text.endsWith("*") || text.endsWith("/") || text.endsWith(".")) {
                if (text.startsWith("-") || text.startsWith(".")) {
                    text = text.substring(0, text.length() - 1);
                    txtvisor.setText(text);
                    novoCalculo = true;
                } else {
                    text = text.substring(0, text.length() - 1);
                    txtvisor.setText(text + simbolo);
                }
            } else if (stringVazia(text) == 0)
                txtvisor.setText("");
            else if (text.startsWith("-"))
                txtvisor.setText(text + "/");
            else
                logicaBt_operacao();
        }
        // BEM VINDO AO INFERNO DOS IF'S
        else if (v.getId() == R.id.btigual) {
            String text = txtvisor.getText().toString();
            //primeiro vamos ver se a string acaba com algum dos simbolos
            if (text.endsWith("+") || text.endsWith("-") || text.endsWith("*") || text.endsWith("/") || text.endsWith(".")) {
                text = text.substring(0, text.length() - 1); // se acabar num simbolo, apagamos e mostramos o texto no visor
                txtvisor.setText(text);
            } else if (stringVazia(text) == 0) // se a string estiver vazia, vamos mostrar a string no visor
                txtvisor.setText("");
            else if (text.startsWith("-")) { // aqui vemos que o numero é negativo, temos que ver se existe alguma operação a ocorrer
                if (text.indexOf('+') != -1 || text.indexOf('*') != -1 || text.indexOf('/') != -1) { // significa que para alem do num ser negativo, ainda existe outro simbolo
                    // na string, se for mais, veze ou dividi, fazemos conta.
                    calculo();
                    text = txtvisor.getText().toString();
                    n1 = intOuDouble(text);
                    novoCalculo = true;
                } else { // se entrar aqui significa que é um nº negativo a subtrair
                    int primeiro = text.indexOf('-'); // Encontrar primeira posição de '-'
                    int segundo = text.indexOf('-', primeiro + 1); // Encontrar segunca posição de '-'

                    boolean temDoisMenos = segundo != -1; // bool para ver se tem dois menos ou não
                    if (temDoisMenos) { // fazer o calculo se tiver 2 simbolos "-"
                        calculo();
                        text = txtvisor.getText().toString();
                        n1 = intOuDouble(text);
                        novoCalculo = true;
                    }//caso tenha clicado no igual com operação ex "-2-" não faz nada. Precisa de ser "-2-2" para funcionar
                }

            } else if (text.indexOf('+') != -1 || text.indexOf('*') != -1 || text.indexOf('/') != -1 || text.indexOf('-') != -1) { //se for um calculo simples, entra aqui
                calculo();
                text = txtvisor.getText().toString();
                n1 = intOuDouble(text);
                novoCalculo = true;
            }

            //BOTÃO PARA LIMPAR O VISOR
        } else if (v.getId() == R.id.bt_limpatext_calc) {
            txtvisor.setText(""); // limpa o visor
            novoCalculo = true; //passa a ser um novo calculo
            temPonto = false; // não tem numero, não tem pontos

            // BOTÃO DA VIRGULA
        } else if (v.getId() == R.id.btvirgula) { // mas um inferno............
            String text = txtvisor.getText().toString();

            // aqui temos que ver se o nº já tem ou não um ponto, quantos pontos tem, não pode haver pontos depois de sinais nem depois de pontos
            if (!temPonto) { // se não tiver nenhum ponto, entra aqui
                if (text == "") { // se a string estiver vazia, vamos adicionar um 0 e um "."
                    text = "0.";
                    txtvisor.setText(text);
                    temPonto = true;
                } else if (text.endsWith("+") || text.endsWith("-") || text.endsWith("*") || text.endsWith("/")) { // se a string acabar num sinal, vamos
                    // apaga-lo e adicionar um "."
                    text = text.substring(0, text.length() - 1);
                    txtvisor.setText(text + ".");
                    temPonto = true;
                } else { // caso contrario vamos só adicionar um ponto
                    txtvisor.setText(text + ".");
                    temPonto = true;
                }

            } else if (text.startsWith("-")) { // numero negativos..... dor de cabeça
                // solução que encontrei foi tirar o "-" do inicio do numero e lidar com o nº como se fosse positivo e no fim adicionar o "-" ao numero
                text = text.substring(1);

                count = 0;
                //vamos passar pela string toda para procurar o nº de "." que há
                for (int i = 0; i < text.length(); i++) {
                    if (text.charAt(i) == '.') {
                        count++;
                    }
                }
                //se a string tiver algum sinal, vamos entrar aqui
                if (text.indexOf('/') != -1 || text.indexOf('+') != -1 || text.indexOf('-') != -1 || text.indexOf('*') != -1) {
                    if (text.endsWith("/") || text.endsWith("+") || text.endsWith("-") || text.endsWith("*")) { // se acabar com um sinal, n faz nada

                    } else if (text.endsWith(".")) { // isto podia estar em cima, mas o codigo funciona assim e n vou mexer para não rebentar

                    } else if (count == 2) { // se houverem 2 ".", não fazemos nada


                    } else if (text.startsWith("-") && count == 1 && !text.endsWith(".")) { //ele nunca entra aqui acho eu pq la em cima estamos a tirar o "-" do text
                        txtvisor.setText("-" + text + ".");                                 //pelo que a string nunca pode começar por "-"... mas funcona, n vou mexer
                    } else
                        txtvisor.setText("-" + text + "."); //aqui vamos colocar o "-" que tiramos la em cima e adicionar um "." no fim do numero.

                }
            }
            /*
            else {
                count = 0;

                for (int i = 0; i < text.length(); i++) {
                    if (text.charAt(i) == '.') {
                        count++;
                    }
                }

                if (text.indexOf('/') != -1 || text.indexOf('+') != -1 || text.indexOf('-') != -1 || text.indexOf('*') != -1) {
                    if (text.endsWith("/") || text.endsWith("+") || text.endsWith("-") || text.endsWith("*")) {

                    } else if (text.endsWith(".")) {

                    } else if (count == 2) {


                    } else if (text.startsWith("-") && count == 1 && !text.endsWith(".")) {
                        txtvisor.setText(text + ".");
                    } else
                        txtvisor.setText(text + ".");

                }


            }
*/

            //BOTÃO PARA APAGAR O ULTIMO Nº OU SINAL
            //aqui temos de perceber se o que apagamos é um nº, um sinal ou um ponto
        } else if (v.getId() == R.id.bt_apagaUm) {
            String text = txtvisor.getText().toString();

            count = 0;
            //vamos perceber quantos pontos há, para caso apaguemos um ponto, podemos saber como manunsear "temPonto"
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == '.') {
                    count++;
                }
            }

            if (stringVazia(text) == 0) { // se o visor estiver vazio, vamos mostrar o visor vazio e atualizar os booleans
                txtvisor.setText("");
                novoCalculo = true;
                temPonto = false;
            } else if (text.endsWith(".") && count == 1) { // se apagarmos o ultimo ".", vamos dizer que já não tem pontos
                text = text.substring(0, text.length() - 1);
                txtvisor.setText(text);
                temPonto = false;
                if (stringVazia(text) == 0) // se após apagarmos a string ficar vazia, vamos atualizar boolean
                    novoCalculo = true;
            } else {
                text = text.substring(0, text.length() - 1);
                txtvisor.setText(text);
                if (stringVazia(text) == 0)
                    novoCalculo = true;
            }
            //BOTÃO FACTORIAL
        } else if (v.getId() == R.id.bt_factorial_calc) {
            String text = txtvisor.getText().toString();

            //factorial não funciona com nº negativos ou decimais.
            if (!(text.startsWith("-") || text.endsWith("-") || text.endsWith("/") || text.endsWith("*") || text.endsWith("+")) && !temPonto && !text.isEmpty()) {
                n1 = intOuDouble(text);
                resultado += factorial((int) n1);
                mostraResultado();
            }
            //BOTÃO Nº NEGATIVO / POSITIVO
        } else if (v.getId() == R.id.bt_positnegat_calc) {
            String text = txtvisor.getText().toString();
            //logica simples, se tiver um "-", tira-se, se não tiver um "-", coloca-se
            if (text.startsWith("-"))
                text = text.substring(1);
            else if (!text.startsWith("-") && !text.isEmpty())
                text = "-" + text;

            txtvisor.setText(text);
        }
    }

    //Metodo onde se faz os calculos
    public void calculo() {


        String text = txtvisor.getText().toString();

        //se a string tiver um "+"
        if (text.indexOf('+') != -1) {

            int posicao = text.indexOf('+'); //vamos buscar o index/posição do "+"
            String text2 = text.substring(posicao + 1).trim(); //guardamos o nº depois do "+" ex "12+21" é guardado o "21"
            n2 = intOuDouble(text2); // colocamos o nº numa variavel double
            resultado = n1 + n2; //faz-se a conta

            mostraResultado();
            //igual
        } else if (text.indexOf('*') != -1) {
            int posicao = text.indexOf('*');
            String text2 = text.substring(posicao + 1).trim();
            n2 = intOuDouble(text2);
            resultado = n1 * n2;

            mostraResultado();
            //igual
        } else if (text.indexOf('/') != -1) {
            int posicao = text.indexOf('/');
            String text2 = text.substring(posicao + 1).trim();
            n2 = intOuDouble(text2);
            resultado = n1 / n2;

            mostraResultado();
            //aqui é diferente. Como o nº pode ser negativo, não basta encontrar o "-", temos de encontrar o 2º "-", pois o 1º é o "-" do nº negativo.
        } else {
            if (text.startsWith("-")) {
                //se o nº for negativo vamos buscar a posição do 2º "-"
                int posicao1 = text.indexOf("-"); //buscar a posição do 1º "-" que é sempre no inicio
                int posicao2 = text.indexOf("-", posicao1 + 1); //buscar a posição do 2º "-". Este sinal é da operação
                String text2 = text.substring(posicao2 + 1).trim(); //guardamos o nº depois do "-" ex "-12-21" é guardado o "21"
                n2 = intOuDouble(text2);
                resultado = n1 - n2;

                mostraResultado();
            } else { // se o nº for positivo, a nossa vida é uma alegria :)
                // aqui é facil. Encontrar a posição do sinal, guardar o nº depois do sinal, fazer o calculo, mostrar no visor
                int posicao = text.indexOf('-');
                String text2 = text.substring(posicao + 1).trim();
                n2 = intOuDouble(text2);
                resultado = n1 - n2;
                mostraResultado();
            }
        }

    }

    public static long factorial(int n) { // metodo para calcular o fatorial - é usada a recursividade para chamar o mesmo metodo e tirando 1 ao "n" sempre que se chama
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // Metodo serve para ver se o resultado é double ou int - escreve resultado no textview
    // isto serve para o visor ficar mais apresentavel, caso seja inteiro, não quero que apareça "10.0", fica melhor "10"
    public void mostraResultado() {
        if (resultado % 1 == 0) {
            resultadoTexto = String.valueOf((int) resultado);
            temPonto = false; //se não for decimal, atualizamos o boolean
        } else {
            resultadoTexto = String.valueOf(resultado);
            temPonto = true; // se for decimal, atualizamos o boolean
        }


        txtvisor.setText(resultadoTexto); // e mostramos o resultado no visor

    }

    // mesma logica de cima - a variavel em si é um double mas podemos foçar um INT caso n seja decimal
    public double intOuDouble(String texto1) {

        try {
            double nTemp = Integer.parseInt(texto1);
            return nTemp;
        } catch (NumberFormatException e1) {
            double nTemp = Double.parseDouble(texto1);
            return nTemp;
        }
    }

    // basta fazer texto.isEmpty() mas eu não sabia e criei isto lol
    public int stringVazia(String text1) {

        int count = 0;
        for (int i = 0; i < text1.length(); i++) {
            count++;
        }
        return count;
    }

    // este metodo criei para diferenciar o comportamento dos butões dos sinais em caso de ser um calculo novo ou não
    // se for um novo calculo, vamos simplesmente guardar o nº antes do sinal. ex escrevo "15" e clico "+", guarda o "15" na variavel n1 e só depois adiciona o "+"
    //caso o n1 já exista. ex "15+10". Aqui se eu clicar no "+", ele faz a conta e só depois é que adiciona o "+", ficando "25+"
    //mais detalhes em baixo
    public void logicaBt_operacao() {

        //se for um novo calculo entra qui
        if (novoCalculo) {
            String text = txtvisor.getText().toString(); // exemplo. texto="15"
            // botão "+" pressionado
            if (simbolo == "+") {
                n1 = intOuDouble(text); //guarda o texto, o n1 agora tem 15
                txtvisor.append("+"); // adicionado "+" ao visor, ficando "15+"
                novoCalculo = false;
                // logica é igual para todos os sinais
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
            // ele aqui so entra caso já hajam 2 nº declarados no visor e nós clicamos num sinal - ele faz o calculo e depois adiciona o sinal
            //exemplo: "15+15" agora clico no "+" o visor fica "30+" - fez a conta e adicionou o sinal no fim
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