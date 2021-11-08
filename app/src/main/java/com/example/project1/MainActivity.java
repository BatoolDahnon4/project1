package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project1.model.Information;
import com.google.gson.Gson;

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
        //---------------------------------------------------------
        Information info = new Information(weighttext,heighttext);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String data = gson.toJson(info);

        editor.putString("DATA", data);
        editor.commit();
        //-----------------------------------------------------------------
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
        Thread thread = new Thread(new mythread(10));
        thread.start();
        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();

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
    class mythread implements Runnable {
        int seconds;

        public mythread(int seconds) {
            this.seconds = seconds;
        }

        @Override
        public void run() {

            for (int i = 0; i < seconds; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}