package com.example.myapplication3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView result;
    Double firstValues, secondValues, result_op;
    String operation;
    Double number1;
    Double number2;
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result_field);
        if (savedInstanceState != null){
            number1 = savedInstanceState.getDouble("number1");
            number2 = savedInstanceState.getDouble("number2");
            operator = savedInstanceState.getString("operator");
            firstValues = number1;
            secondValues = number2;
            operation = operator;
        }
        Log.d("calkuly", "onCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("calkuly", "onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("calkuly", "onResume");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("calkuly", "onStop");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("calkuly", "onRestart");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("calkuly", "onDestroy");
    }
    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.seven:
                result.append("7");
                break;
            case R.id.eight:
                result.append("8");
                break;
            case R.id.nine:
                result.append("9");
                break;
            case R.id.four:
                result.append("4");
                break;
            case R.id.five:
                result.append("5");
                break;
            case R.id.six:
                result.append("6");
                break;
            case R.id.one:
                result.append("1");
                break;
            case R.id.two:
                result.append("2");
                break;
            case R.id.three:
                result.append("3");
                break;
            case R.id.zero:
                result.append("0");
                break;
            case R.id.clear:
                result.setText("");
                break;
            case R.id.point:
                String string = (result.getText().toString().trim());
                if (string.length() > 0) {
                    result.setText(string + ".");
                    break;
                }
            case R.id.back:
                String str;
                str = result.getText().toString();
                result.setText(null);
                str = str.substring(0, str.length() - 1);
                result.setText(result.getText() + str);
                break;
        }
    }
    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.plus:
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "+");
                operation = "+";
                break;
            case R.id.division:
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "/");
                operation = "/";
                break;
            case R.id.minus:
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "-");
                operation = "-";
                break;
            case R.id.multiplication:
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "*");
                operation = "*";
                break;
            case R.id.equally:
                if (operation != null) {
                    String two = result.getText().toString().replace(firstValues.toString() + operation, "");
                    secondValues = Double.valueOf(two);
                    switch (operation) {
                        case "+":
                            plusOperation();
                            break;
                        case "/":
                            divisionOperation();
                            break;
                        case "-":
                            minusOperation();
                            break;
                        case "*":
                            multiplicationOperation();
                            break;
                    }
                }
        }
    }
    public void plusOperation() {
        result_op = firstValues + secondValues;
        result.setText(result_op.toString());
    }
    public void divisionOperation() {
        result_op = firstValues / secondValues;
        result.setText(result_op.toString());
    }
    public void minusOperation() {
        result_op = firstValues - secondValues;
        result.setText(result_op.toString());
    }
    public void multiplicationOperation() {
        result_op = firstValues * secondValues;
        result.setText(result_op.toString());
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (firstValues != null){
            outState.putDouble("number1", firstValues);
        }
        if (secondValues != null){
            outState.putDouble("number2", secondValues);
        }
        if (operation != null){
            outState.putString("operator", operation);
        }
    }
}