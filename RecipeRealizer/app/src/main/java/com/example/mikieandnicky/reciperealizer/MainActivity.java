package com.example.mikieandnicky.reciperealizer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText eName, ei1, ei2, ei3, ei4, ei5, ei6, ei7, ei8, ei9, ei10, ei11, ei12, ei13, ei14, ei15;
    Button bSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new DatabaseHelper(this);
        eName = (EditText) findViewById(R.id.editText); //Adding pointers to edit fields
        ei1 = (EditText) findViewById(R.id.editText2);
        ei2 = (EditText) findViewById(R.id.editText3);
        ei3 = (EditText) findViewById(R.id.editText4);
        ei4 = (EditText) findViewById(R.id.editText5);
        ei5 = (EditText) findViewById(R.id.editText6);
        ei6 = (EditText) findViewById(R.id.editText7);
        ei7 = (EditText) findViewById(R.id.editText8);
        ei8 = (EditText) findViewById(R.id.editText9);
        ei9 = (EditText) findViewById(R.id.editText10);
        ei10 = (EditText) findViewById(R.id.editText11);
        ei11 = (EditText) findViewById(R.id.editText12);
        ei12 = (EditText) findViewById(R.id.editText13);
        ei13 = (EditText) findViewById(R.id.editText14);
        ei14 = (EditText) findViewById(R.id.editText15);
        ei15 = (EditText) findViewById(R.id.editText16);
        bSave = (Button) findViewById(R.id.button_save);
        addRecipe();
    }

    public void addRecipe() {
        bSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDB.insert_recipe(eName.getText().toString(), ei1.getText().toString(),
                                ei2.getText().toString(), ei3.getText().toString(),
                                ei4.getText().toString(), ei5.getText().toString(),
                                ei6.getText().toString(), ei7.getText().toString(),
                                ei8.getText().toString(), ei9.getText().toString(),
                                ei10.getText().toString(), ei11.getText().toString(),
                                ei12.getText().toString(), ei13.getText().toString(),
                                ei14.getText().toString(), ei15.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(MainActivity.this, "Recipe Insertion Successful", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Recipe Insertion FAILED", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}

