package com.ikeda.primeiroapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ExecutionException;


public class CepActivity extends AppCompatActivity {

    Button buttonBuscarCep;
    EditText inputCep;
    TextView textCep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cep);
        buttonBuscarCep = findViewById(R.id.buttonConsulta);
        inputCep = findViewById(R.id.inputCep);
        textCep = findViewById(R.id.textCep);

        buttonBuscarCep.setOnClickListener(view -> {
            try {
                CEP retorno = new HttpService(inputCep.getText().toString()).execute().get();
                textCep.setText(retorno.toString());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


    }
}
