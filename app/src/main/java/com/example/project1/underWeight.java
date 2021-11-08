package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.project1.model.factory;
import com.example.project1.model.myInterface;

import java.util.ArrayList;

public class underWeight extends AppCompatActivity {
    factory fac =new factory();
    myInterface obj = fac.getModel();
    Spinner spinner;
    TextView txt1;
    TextView txt2;
    private ArrayAdapter<String> myArrayAdapter1;
    private ArrayList<String> arr1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_under_weight);
        spinner=findViewById(R.id.spinner1);
        txt1=findViewById(R.id.haveToDoText);
        txt2=findViewById(R.id.avoidText);
        arr1 = new ArrayList<>();
        for (int i = 0; i < obj.getAllCategory().size(); i++) {
            arr1.add(obj.getAllCategory().get(i));
        }
        myArrayAdapter1 = new ArrayAdapter<String>(underWeight.this, android.R.layout.simple_spinner_dropdown_item, arr1);
        spinner.setAdapter(myArrayAdapter1);
    }
    public void next2(View view) {
        String str =spinner.getSelectedItem().toString();

        for (int j = 0; j < obj.getHaveToDo(str,"UnderWeight").size(); j++) {
            txt1.setText(obj.getHaveToDo(str,"UnderWeight").get(j).getInfo());
        }

        for (int j = 0; j < obj.getAvoid(str,"UnderWeight").size(); j++) {

            txt2.setText(obj.getHaveToDo(str,"UnderWeight").get(j).getInfo());

        }



    }


}