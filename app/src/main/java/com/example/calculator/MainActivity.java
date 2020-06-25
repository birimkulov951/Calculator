package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.Calculator3.MESSAGE";
    EditText numberA;
    EditText numberB;

    double doubleA = 0;
    double doubleB = 0;
    double answer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the View that shows the numbers category
        numberA = (EditText) findViewById(R.id.editTextNumberDecimal5a);
        numberB = (EditText) findViewById(R.id.editTextNumberDecimal5b);

        numberA.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                doubleA = 0;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                doubleA = Double.parseDouble(numberA.getText().toString());
                Log.i("ontextChanged", numberA.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {
                doubleA = Double.parseDouble(numberA.getText().toString());
                Log.d("aftertextChanged", numberA.toString());
            }
        });
        numberB.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                doubleB=0;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                doubleB = Double.parseDouble(numberB.getText().toString());

            }

            @Override
            public void afterTextChanged(Editable s) {
                doubleB = Double.parseDouble(numberB.getText().toString());

            }
        });
    }


    public void add(View view) {
        answer = doubleA + doubleB;
        Intent intent = new Intent(this, AnswerActivity.class);
        String message = String.valueOf(answer);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void subtract(View view) {
        answer = doubleA - doubleB;
        Intent intent = new Intent(this, AnswerActivity.class);
        String message = String.valueOf(answer);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void multiply(View view) {
        answer = doubleA * doubleB;
        Intent intent = new Intent(this, AnswerActivity.class);
        String message = String.valueOf(answer);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void divide(View view) {
        answer = doubleA / doubleB;
        Intent intent = new Intent(this, AnswerActivity.class);
        String message = String.valueOf(answer);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}