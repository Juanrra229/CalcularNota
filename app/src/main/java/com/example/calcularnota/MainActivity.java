package com.example.calcularnota;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNota1, etNota2, etNota3, etNota4, etNestudiantes;

    private TextView tvNotaFinal, tvMensaje, tvContador;
    public Button btnCalcular, btnIngresar;
    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;
    private int CantidadP = 0;
    public int CantidadEstudiantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNestudiantes = (EditText) findViewById(R.id.etNestudiantes);
        etNota1 = (EditText) findViewById(R.id.etNota1);
        etNota2 = (EditText) findViewById(R.id.etNota2);
        etNota3 = (EditText) findViewById(R.id.etNota3);
        etNota4 = (EditText) findViewById(R.id.etNota4);
        tvNotaFinal = (TextView) findViewById(R.id.tvNotaFinal);
        tvMensaje = (TextView) findViewById(R.id.tvMensaje);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnIngresar = (Button) findViewById(R.id.Ingresar);

    }

    public void cantidadE(View view) {
        CantidadEstudiantes = Integer.parseInt(etNestudiantes.getText().toString());
    }

    private void ConvertirNotas() {
        nota1 = Double.parseDouble(etNota1.getText().toString());
        nota2 = Double.parseDouble(etNota2.getText().toString());
        nota3 = Double.parseDouble(etNota3.getText().toString());
        nota4 = Double.parseDouble(etNota4.getText().toString());

    }

    private boolean esValido(double con) {
        if (con > 0 && con <= 5) {
            return true;
        } else {
            return false;
        }
    }

    private boolean esValido1(int cantidad1) {
        if (cantidad1 > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void Calcular(View view) {
        ConvertirNotas();

        if (esValido(nota1) && esValido(nota2) && esValido(nota3) && esValido(nota4) && esValido1(CantidadEstudiantes)) {

            nota1 = (nota1 * 0.20);
            nota2 = (nota2 * 0.30);
            nota3 = (nota3 * 0.15);
            nota4 = (nota4 * 0.30);

            double notafinal = nota1 + nota2 + nota3 + nota4;
            tvNotaFinal.setText(String.valueOf(notafinal));

            CantidadEstudiantes--;

            if (notafinal < 3) {
                CantidadP = CantidadP + 1;
            }

            System.out.println("perdidos: " + CantidadP);

        } else {
            if (!esValido(nota1) || !esValido(nota2) || !esValido(nota3) || !esValido(nota4)) {
                Toast.makeText(this, "Debes ingresar una nota valida", Toast.LENGTH_LONG).show();

            }

            if (CantidadEstudiantes == 0) {
                Toast.makeText(this, "Ya calificaste la cantidad de estudiantes permitidos", Toast.LENGTH_LONG).show();
            }
        }
        tvMensaje.setText(String.valueOf(CantidadP));
    }
}



