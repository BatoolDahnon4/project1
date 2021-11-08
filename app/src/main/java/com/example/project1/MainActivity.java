package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edtweight;
    private EditText edtheight;
    private EditText edtresult;
    private Button calculate;
    private Button toActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtweight = findViewById(R.id.edtweight);
        edtheight = findViewById(R.id.edtheight);
        edtresult = findViewById(R.id.edtresult);
        calculate = findViewById(R.id.calculate);
        toActivity = findViewById(R.id.toActivity);
    }

    public void show_bmi(View view) {
        Float weighttext = Float.valueOf(edtweight.getText().toString());
        Float heighttext = Float.valueOf(edtheight.getText().toString());
        Float results= (weighttext / (heighttext*heighttext));
        edtresult.setText(String.valueOf(results));
        if (results<18.5){
            edtresult.setText(String.valueOf("you are Underweight"));
            toActivity.setVisibility(View.VISIBLE);
         //   calculate.setVisibility(View.INVISIBLE);
        }
        if (results>= 18.5 && results < 25){
            edtresult.setText(String.valueOf("you have a healthy body"));
            toActivity.setVisibility(View.VISIBLE);
         //   calculate.setVisibility(View.INVISIBLE);

        }
        if (results>25){
            edtresult.setText(String.valueOf("you are overweight"));
            toActivity.setVisibility(View.VISIBLE);
           // calculate.setVisibility(View.INVISIBLE);

        }
    }

    public void toActivity(View view) {
        Float weighttext = Float.valueOf(edtweight.getText().toString());
        Float heighttext = Float.valueOf(edtheight.getText().toString());
        Float results= (weighttext / (heighttext*heighttext));
        edtresult.setText(String.valueOf(results));
        if (results<18.5){
            Intent intent = new Intent(this, underWeight.class);
            startActivity(intent);
        }
        if (results>= 18.5 && results < 25){

            Intent intent = new Intent(this, healthyWeight.class);
            startActivity(intent);
        }
        if (results>25){
            Intent intent = new Intent(this, overWeight.class);
            startActivity(intent);
        }
    }
}