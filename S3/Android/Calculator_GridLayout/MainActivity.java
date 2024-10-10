package com.example.gridcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private String currentInput = "";
    private String operator = "";
    private double firstNumber = 0.0;
    private boolean isOperatorPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.tvDisplay);

        // Number buttons
        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);

        // Operator buttons
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSubtract = findViewById(R.id.btnSubtract);
        Button btnMultiply = findViewById(R.id.btnMultiply);
        Button btnDivide = findViewById(R.id.btnDivide);
        Button btnEquals = findViewById(R.id.btnEquals);
        Button btnDot = findViewById(R.id.btnDot);

        // Function buttons
        Button btnClear = findViewById(R.id.btnClear);
        Button btnBackspace = findViewById(R.id.btnBackspace);

        // Set onClickListeners for number buttons
        View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                appendToInput(b.getText().toString());
            }
        };

        btn0.setOnClickListener(numberListener);
        btn1.setOnClickListener(numberListener);
        btn2.setOnClickListener(numberListener);
        btn3.setOnClickListener(numberListener);
        btn4.setOnClickListener(numberListener);
        btn5.setOnClickListener(numberListener);
        btn6.setOnClickListener(numberListener);
        btn7.setOnClickListener(numberListener);
        btn8.setOnClickListener(numberListener);
        btn9.setOnClickListener(numberListener);
        btnDot.setOnClickListener(numberListener);

        // Set onClickListeners for operator buttons
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("+");
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("-");
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("*");
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("/");
            }
        });

        // Set onClickListener for the equals button
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });

        // Clear the display
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });

        // Backspace functionality
        btnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentInput.isEmpty()) {
                    currentInput = currentInput.substring(0, currentInput.length() - 1);
                    display.setText(currentInput.isEmpty() ? "0" : currentInput);
                }
            }
        });
    }

    private void appendToInput(String value) {
        if (isOperatorPressed) {
            currentInput = "";
            isOperatorPressed = false;
        }

        if (value.equals(".") && currentInput.contains(".")) {
            return; // Avoid multiple dots
        }

        currentInput += value;
        display.setText(currentInput);
    }

    private void performOperation(String operator) {
        if (!currentInput.isEmpty()) {
            firstNumber = Double.parseDouble(currentInput);
            this.operator = operator;
            isOperatorPressed = true;
        }
    }

    private void calculateResult() {
        if (!currentInput.isEmpty() && !operator.isEmpty()) {
            double secondNumber = Double.parseDouble(currentInput);
            double result = 0.0;

            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    if (secondNumber != 0) {
                        result = firstNumber / secondNumber;
                    } else {
                        display.setText("Error"); // Division by zero error
                        return;
                    }
                    break;
            }

            currentInput = String.valueOf(result);
            display.setText(currentInput);
            operator = "";
        }
    }

    private void clear() {
        currentInput = "";
        firstNumber = 0.0;
        operator = "";
        display.setText("0");
    }
}
