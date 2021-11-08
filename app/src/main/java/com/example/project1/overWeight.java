package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.project1.model.factory;
import com.example.project1.model.myInterface;

import java.util.ArrayList;

public class overWeight extends AppCompatActivity {
    factory fac =new factory();
    myInterface obj = fac.getModel();
    Spinner spinner;
    ListView list;
    ListView list2;
    private ArrayAdapter<String> myArrayAdapter1;
    private ArrayList<String> arr1;
    private ArrayAdapter<String> myArrayAdapter2;
    private ArrayList<String> arr2;
    private ArrayAdapter<String> myArrayAdapter3;
    private ArrayList<String> arr3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over_weight);
        list=(ListView) findViewById(R.id.list1);
        list2=(ListView) findViewById(R.id.list2);
        spinner=findViewById(R.id.spinner1);
        arr1 = new ArrayList<>();
        for (int i = 0; i < obj.getAllCategory().size(); i++) {
            arr1.add(obj.getAllCategory().get(i));
        }
        myArrayAdapter1 = new ArrayAdapter<String>(overWeight.this, android.R.layout.simple_spinner_dropdown_item, arr1);
        spinner.setAdapter(myArrayAdapter1);
        //****************************************************



        }


    public void next(View view) {
        String str =spinner.getSelectedItem().toString();
        arr2 = new ArrayList<>();
        for (int j = 0; j < obj.getHaveToDo(str,"obesity").size(); j++) {

            arr2.add(obj.getHaveToDo(str,"obesity").get(j).getInfo());

        }
        myArrayAdapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,arr2);
        list.setAdapter(myArrayAdapter2);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }

        });
        arr3 = new ArrayList<>();
        for (int j = 0; j < obj.getAvoid(str,"obesity").size(); j++) {

            arr3.add(obj.getAvoid(str,"obesity").get(j).getInfo());

        }
        myArrayAdapter3 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,arr3);
        list2.setAdapter(myArrayAdapter3);
        list2.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });



    }
}