package com.josuu1.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

    ArrayList<String> operadores = new ArrayList<>(Arrays.asList("+", "-", "x", "÷", "%"));
    TextView mainET;

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
                findViewById(R.id.ButtonDecimal)
        ));

        for (Button button : BotonesNumeros) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String textoActual = mainET.getText().toString();
                    String textoBoton = button.getText().toString();

                    if (textoActual.equals("0") || textoActual.equals("-0")) {
                        if (textoActual.startsWith("-")) {
                            mainET.setText("-" + textoBoton);
                        } else {
                            mainET.setText(textoBoton);
                        }
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
                            && !textoActual.endsWith("÷") && !textoActual.endsWith("%") && !textoActual.endsWith(",")) {
                        mainET.append(textoBoton);
                    }
                    }
            });
        }

    }

    public void equal(View v) {
        String operacionUser = mainET.getText().toString();

        operacionUser = operacionUser.replaceAll("÷", "/");
        operacionUser = operacionUser.replaceAll("x", "*");
        operacionUser = operacionUser.replace(",", ".");
        operacionUser = operacionUser.replace("%", "/100");

        Expression exp = new Expression(operacionUser);

        String resultado = String.valueOf(exp.calculate());

        mainET.setText(resultado);

    }

    public void clear(View v) {
        mainET.setText("0");
    }

    public void borrar(View v) {
        String textoActual = mainET.getText().toString(); //obtenemos texto

        if (!textoActual.isEmpty() && !textoActual.equals("0")) { //asguramos de uqe no este vacio o con 0
            textoActual = textoActual.substring(0, textoActual.length() - 1);
        }
        if (textoActual.isEmpty()) {
            textoActual = "0";
        }
        mainET.setText(textoActual);
    }
    public void negative(View v) {
        String texto = mainET.getText().toString();
        int i = texto.length() - 1;

        while (i >= 0 && !operadores.contains(String.valueOf(texto.charAt(i)))) {
            i--;
        }

        String inicio = texto.substring(0, i + 1);
        String ultimo = texto.substring(i + 1);

        if (ultimo.startsWith("-")) {
            return;
        }

        if (ultimo.equals("0")) {
            return;
        }

        if (ultimo.startsWith("-")) {
            ultimo = ultimo.substring(1);
        } else {
            ultimo = "(-" + ultimo +")";
        }

        mainET.setText(inicio + ultimo);
    }


}

