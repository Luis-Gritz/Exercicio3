package com.example.exercicio3;

import androidx.annotation.IntegerRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textResult;
    private ListView listLado;
    private ListView listResultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResult = findViewById(R.id.textResult);
        listLado = findViewById(R.id.listLado);
        listResultados = findViewById(R.id.listResultados);

    }

    public void num_lancamento(View view) {
        int max = 5;
        ArrayList<Integer> lados = new ArrayList<Integer>();
        int soma = 0;
        for (int i = 1; i <= max; i++) {
            int lado = resultDado();
            lados.add(lado);
            soma = soma + lado;

        }

        ArrayList<String> resultados = new ArrayList<String>();
        int cont1 = 0;
        int cont2 = 0;
        int cont3 = 0;
        int cont4 = 0;
        int cont5 = 0;
        int cont6 = 0;

        for (int i = 0; i < lados.size(); i++) {
            if (lados.get(i) == 1) {
                cont1 += 1;
            }
            if (lados.get(i) == 2) {
                cont2 += 1;
            }
            if (lados.get(i) == 3) {
                cont3 += 1;
            }
            if (lados.get(i) == 4) {
                cont4 += 1;
            }
            if (lados.get(i) == 5) {
                cont5 += 1;
            }
            if (lados.get(i) == 6) {
                cont6 += 1;
            }
        }

        //Regras de Jogada 1,2,3,...
        if (cont1 != 0) {
            resultados.add("Jogada de 1");
        }
        if (cont2 != 0) {
            resultados.add("Jogada de 2");
        }
        if (cont3 != 0) {
            resultados.add("Jogada de 3");
        }
        if (cont4 != 0) {
            resultados.add("Jogada de 4");
        }
        if (cont5 != 0) {
            resultados.add("Jogada de 5");
        }
        if (cont6 != 0) {
            resultados.add("Jogada de 6");
        }


        //Regras de Trinca
        if (cont1 == 3) {
            resultados.add("Trinca de Uns");
        }
        if (cont2 == 3) {
            resultados.add("Trinca de Dois");
        }
        if (cont3 == 3) {
            resultados.add("Trinca de três");
        }
        if (cont4 == 3) {
            resultados.add("Trinca de Quatros");
        }
        if (cont5 == 3) {
            resultados.add("Trinca de Cincos");
        }
        if (cont6 == 3) {
            resultados.add("Trinca de Seis");
        }

        //Regras da Quadras
        if (cont1 == 4) {
            resultados.add("Quadra de Uns");
        }
        if (cont2 == 4) {
            resultados.add("Quadra de Dois");
        }
        if (cont3 == 4) {
            resultados.add("Quadra de três");
        }
        if (cont4 == 4) {
            resultados.add("Quadra de Quatros");
        }
        if (cont5 == 4) {
            resultados.add("Quadra de Cincos");
        }
        if (cont6 == 4) {
            resultados.add("Quadra de Seis");
        }

        //FullHand
        if (cont1 == 3) {
            if (cont2 == 2 || cont3 == 2 || cont4 == 2 || cont5 == 2 || cont6 == 2){
                resultados.add("FullHand");
            }
        }
        if (cont2 == 3) {
            if (cont1 == 2 || cont3 == 2 || cont4 == 2 || cont5 == 2 || cont6 == 2){
                resultados.add("FullHand");
            }
        }
        if (cont3 == 3) {
            if (cont1 == 2 || cont2 == 2 || cont4 == 2 || cont5 == 2 || cont6 == 2){
                resultados.add("FullHand");
            }
        }
        if (cont4 == 3) {
            if (cont1 == 2 || cont2 == 2 || cont3 == 2 || cont5 == 2 || cont6 == 2){
                resultados.add("FullHand");
            }
        }
        if (cont5 == 3) {
            if (cont1 == 2 || cont2 == 2 || cont3 == 2 || cont4 == 2 || cont6 == 2){
                resultados.add("FullHand");
            }
        }
        if (cont6 == 3){
            if(cont1 == 2 || cont2 == 2 || cont3 == 2 || cont4 == 2 || cont5 == 2){
                resultados.add("FullHand");
            }
        }

        //Sequencia Alta
        ArrayList<Integer> seqAlt = new ArrayList<Integer>() {{add(2);add(3);add(4); add(5); add(6);}};
        if (lados.equals(seqAlt)){
            resultados.add("Sequência Alta");

        }

        //Sequencia Baixa
        ArrayList<Integer> seqBai = new ArrayList<Integer>() {{ add(1);add(2);add(3);add(4); add(5);}};
        if (lados.equals(seqBai)){
            resultados.add("Sequência Baixa");

        }

        //General
        if (cont1 == 5 || cont2 == 5 || cont3 == 5 || cont4 == 5 || cont5 == 5 || cont6 == 5){
            resultados.add("Jogada General");
        }
        resultados.add("Jogada Aleatória");



        String resultSoma = Integer.toString(soma);
        textResult.setText(resultSoma);
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, lados);
        listLado.setAdapter(arrayAdapter);
        ArrayAdapter<String> arrayAdapterResults = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resultados);
        listResultados.setAdapter(arrayAdapterResults);
    }

    public int resultDado(){
        int max = 6;
        int min = 1;
        Random aleatorio = new Random();
        int result = aleatorio.nextInt((max - min) + 1) + min;
        return result;


    }
}

