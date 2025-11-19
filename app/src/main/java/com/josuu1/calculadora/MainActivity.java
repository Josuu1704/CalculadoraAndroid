package com.josuu1.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;

        button1 = findViewById(R.id.ButtonOne);
        button2 = findViewById(R.id.ButtonTwo);
        button3 = findViewById(R.id.ButtonThree);
        button4 = findViewById(R.id.ButtonFour);
        button5 = findViewById(R.id.ButtonFive);
        button6 = findViewById(R.id.ButtonSix);
        button7 = findViewById(R.id.ButtonSeven);
        button8 = findViewById(R.id.ButtonEight);
        button9 = findViewById(R.id.ButtonNine);
        button0 = findViewById(R.id.ButtonCero);

        //Button.OnClickListener(new View.OnClickListener(){

        };
    }

