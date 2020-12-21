package com.example.myappcalc;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CalculatorLogic calculator;

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] numberIds = new int[]{
                R.id.zero,
                R.id.one,
                R.id.two,
                R.id.three,
                R.id.four,
                R.id.five,
                R.id.six,
                R.id.seven,
                R.id.eight,
                R.id.nine,
                R.id.dot
        };

        int[] actionsIds = new int[]{
                R.id.plus,
                R.id.minus,
                R.id.multiply,
                R.id.division,
                R.id.equals
        };

        text = findViewById(R.id.text);

        calculator = new CalculatorLogic();

        View.OnClickListener numberButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onNumPressed(view.getId());
                text.setText(calculator.getText());
        }
        };

        View.OnClickListener actionButtonOnclickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onActionPressed(view.getId());
                text.setText(calculator.getText());
            }
        };

//        View.OnClickListener dotButtonOnClickListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                calculator.onDotPressed();
//                text.setText(calculator.getText());
//            }
//        };


        //setting listeners for each  button

        for (int numberId : numberIds) {
            findViewById(numberId).setOnClickListener(numberButtonClickListener);
        }

        for (int actionsId : actionsIds) {
            findViewById(actionsId).setOnClickListener(actionButtonOnclickListener);
        }

        findViewById(R.id.reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.reset();
                text.setText(calculator.getText());
            }
        });

       // findViewById(R.id.dot).setOnClickListener(dotButtonOnClickListener);
    }
}
