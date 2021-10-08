package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnCalculate;
    EditText txtHeight, txtWeight;
    TextView lblResult;


    private double weight = 0;
    private int height = 0;
    private double bmi = 0;
    private String message = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        txtWeight = (EditText) findViewById(R.id.txtWeight);
        txtHeight = (EditText) findViewById(R.id.txtHeight);
        lblResult = (TextView) findViewById(R.id.lblResult);
    }


    public void calculateBmi(View view){

        weight = Double.parseDouble(txtWeight.getText().toString());
        height = Integer.parseInt(txtHeight.getText().toString());
        bmi = (weight/height/height)*10000;

        if(bmi < 18.5){
            message = "BMI: "+bmi +"\n Classification: Underweight";
        }
        else if(bmi >= 18.5 && bmi <= 24.9){
            message = "BMI: "+bmi +"\n Classification: Normal";
        }
        else if(bmi >= 25 && bmi <= 29.9){
            message = "BMI: "+bmi +"\n Classification: Overweight";
        }
        else if(bmi >= 30 && bmi <= 34.9){
            message = "BMI: "+bmi +"\n Classification: Obesity";
        }
        else if(bmi > 35){
            message = "BMI: "+bmi +"\n Classification: Severe Obesity\n Danger!";
        }
        else {
            message = "Kindly Enter correct information";
        }

        lblResult.setText(message);
    }
}