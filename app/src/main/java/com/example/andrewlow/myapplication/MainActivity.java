package com.example.andrewlow.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText1;
    Spinner spin;
    ArrayAdapter<String>adapter;
    List<String> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);
        Button btn2 = findViewById(R.id.button5);
        Button btn3 = findViewById(R.id.button3);
        spin = findViewById(R.id.spinner2);

         list.add("One");
         list.add("Two");
        list.add("Three");

        String[]list2 = {"Four","Five","Six"};
        adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,list);

        spin.setAdapter(adapter);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.add("One");
                list.add("Two");
                list.add("Three");
               // spin.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),"Data added",Toast.LENGTH_SHORT).show();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.add("Four");
                list.add("Five");
                list.add("Six");
                //spin.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });


        //editText = findViewById(R.id.editText);
       // editText1 = findViewById(R.id.editText2);

       // displayData();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(it);
            }
        });

    }

    public void displayData(){
        SharedPreferences sharedPreferences = getSharedPreferences("test", Context.MODE_PRIVATE);
        String one = sharedPreferences.getString("username","");
        String two = sharedPreferences.getString("password","");

        editText.setText(one + "Password: "+ two);

    }


}
