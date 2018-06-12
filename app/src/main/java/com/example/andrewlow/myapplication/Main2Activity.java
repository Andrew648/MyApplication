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

public class Main2Activity extends AppCompatActivity {

    EditText editText;
    EditText editText1;
    Button btn;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText = findViewById(R.id.editText);
        //editText1 = findViewById(R.id.editText2);
        btn = findViewById(R.id.button2);
        Button btn2 = findViewById(R.id.button4);
        spinner = findViewById(R.id.spinner);

        String[] list= {"One", "Two","Three","Four","Five"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,list);
        spinner.setAdapter(adapter);

        sharedPreferences  = getSharedPreferences("test", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        displayData();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.putString("username",editText.getText().toString());
                //editor.putString("password",editText1.getText().toString());

                editor.apply();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public void displayData(){
        SharedPreferences sharedPreferences = getSharedPreferences("test", Context.MODE_PRIVATE);
        String one = sharedPreferences.getString("username","");
        //String two = sharedPreferences.getString("password","");
        int spin = sharedPreferences.getInt("spinner",0);
        editText.setText(one);
        spinner.setSelection(spin);

    }

    @Override
    public void onBackPressed() {
        editor.putString("username",editText.getText().toString());
        editor.putInt("spinner",spinner.getSelectedItemPosition());
        editor.apply();
        super.onBackPressed();
    }
}
