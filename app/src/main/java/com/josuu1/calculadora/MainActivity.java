package com.josuu1.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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
                findViewById(R.id.ButtonIgual),
                findViewById(R.id.ButtonNegativo)
        ));
        //Button.OnClickListener(new View.OnClickListener(){

        };
    }

