package com.josuu1.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    EditText mainET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mainET = findViewById(R.id.mainET);

        List<Button> BotonesNumeros = new ArrayList<>(Arrays.asList(
            findViewById(R.id.ButtonOne),
            findViewById(R.id.ButtonTwo),
            findViewById(R.id.ButtonThree),
            findViewById(R.id.ButtonFour),
            findViewById(R.id.ButtonFive),
            findViewById(R.id.ButtonSix),
            findViewById(R.id.ButtonSeven),
            findViewById(R.id.ButtonEight),
            findViewById(R.id.ButtonNine),
            findViewById(R.id.ButtonCero)
        ));
        List<Button> BotonesOperation = new ArrayList<>(Arrays.asList(
            findViewById(R.id.ButtonSuma),
            findViewById(R.id.ButtonResta),
            findViewById(R.id.ButtonDivision),
            findViewById(R.id.ButtonMultiplicacion),
            findViewById(R.id.ButtonPorcentaje),
            findViewById(R.id.ButtonNegativo),
            findViewById(R.id.ButtonDecimal)
        ));

        for (Button button : BotonesNumeros) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String textoActual = mainET.getText().toString();
                    String textoBoton = button.getText().toString();

                    if (textoActual.equals("0")) {
                        mainET.setText(textoBoton);
                    } else {
                        mainET.append(textoBoton);
                    }
                }
            });
        }
        for (Button botonOperacion : BotonesOperation) {
            botonOperacion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String textoBoton = botonOperacion.getText().toString();
                    String textoActual = mainET.getText().toString();

                    if (!textoActual.endsWith("+") && !textoActual.endsWith("-") && !textoActual.endsWith("x")
                        && !textoActual.endsWith("/") && !textoActual.endsWith("%") && !textoActual.endsWith(",")) {
                        mainET.append(textoBoton);
                    }
                }
            });
        }

    }
    public void equal(View v){
        String operacionUser = mainET.getText().toString();

        operacionUser = operacionUser.replaceAll("÷", "/");
        operacionUser = operacionUser.replaceAll("x", "*");
        operacionUser = operacionUser.replace(",", ".");

        Expression exp = new Expression(operacionUser);

        String resultado = String.valueOf(exp.calculate());

        mainET.setText(resultado);
        mainET.setSelection(resultado.length());

    }
    public void clear(View v){
        mainET.setText("0");
    }

    public void borrar(View v){
        String textoActual = mainET.getText().toString();

        if (!textoActual.isEmpty() && !textoActual.equals("0")) {
            textoActual = textoActual.substring(0, textoActual.length() - 1);
        }
        if (textoActual.isEmpty()) {
            textoActual = "0";
        }
        mainET.setText(textoActual);
        mainET.setSelection(textoActual.length());
    }
}
