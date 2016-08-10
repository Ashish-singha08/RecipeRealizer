package com.example.mikieandnicky.reciperealizer;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddRecipe extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText eName, ei1, ei2, ei3, ei4, ei5, ei6, ei7, ei8, ei9, ei10, ei11, ei12, ei13, ei14, ei15;
    Button bSave;
    Button bViewAll;
    Button bRemove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_recipe);
        myDB = new DatabaseHelper(this);
        eName = (EditText) findViewById(R.id.editText18); //Adding pointers to edit fields
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
        bViewAll = (Button) findViewById(R.id.button_view);
        bRemove = (Button) findViewById(R.id.button_remove);
        addRecipe();
        viewAll();
        removeRecipe();
    }
    public void removeRecipe(){
        bRemove.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick (View v) {
                        startActivity(new Intent(AddRecipe.this, RemoveEdit.class));
                    }
                }
        );
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
                                         if (isInserted)
                                             Toast.makeText(AddRecipe.this, "Recipe Insertion Successful", Toast.LENGTH_LONG).show();
                                         else
                                             Toast.makeText(AddRecipe.this, "Recipe Insertion FAILED", Toast.LENGTH_LONG).show();
                                     }
                                 }
        );
    }

    public void viewAll () {
        bViewAll.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Cursor cursor = myDB.getAllData();
                                            if (cursor.getColumnCount()==0) {
                                                showRecipe("Error: ", "Nothing Found");
                                                return;
                                            }
                                            StringBuffer sbuffer = new StringBuffer();
                                            while(cursor.moveToNext()){
                                                sbuffer.append("\nID: " + cursor.getString(0)+"\n");
                                                sbuffer.append("Recipe: " + cursor.getString(1)+"\n");
                                                sbuffer.append("Ingredients: \n");
                                                if (cursor.getString(2).length() > 1)
                                                    sbuffer.append(cursor.getString(2)+ "\n");
                                                if (cursor.getString(3).length() > 1)
                                                    sbuffer.append(cursor.getString(3)+ "\n");
                                                if (cursor.getString(4).length() > 1)
                                                    sbuffer.append(cursor.getString(4)+ "\n");
                                                if (cursor.getString(5).length() > 1)
                                                    sbuffer.append(cursor.getString(5)+ "\n");
                                                if (cursor.getString(6).length() > 1)
                                                    sbuffer.append(cursor.getString(6)+ "\n");
                                                if (cursor.getString(7).length() > 1)
                                                    sbuffer.append(cursor.getString(7)+ "\n");
                                                if (cursor.getString(8).length() > 1)
                                                    sbuffer.append(cursor.getString(8)+ "\n");
                                                if (cursor.getString(9).length() > 1)
                                                    sbuffer.append(cursor.getString(9)+ "\n");
                                                if (cursor.getString(10).length() > 1)
                                                    sbuffer.append(cursor.getString(10)+ "\n");
                                                if (cursor.getString(11).length() > 1)
                                                    sbuffer.append(cursor.getString(11)+ "\n");
                                                if (cursor.getString(12).length() > 1)
                                                    sbuffer.append(cursor.getString(12)+ "\n");
                                                if (cursor.getString(13).length() > 1)
                                                    sbuffer.append(cursor.getString(13)+ "\n");
                                                if (cursor.getString(14).length() > 1)
                                                    sbuffer.append(cursor.getString(14)+ "\n");
                                                if (cursor.getString(15).length() > 1)
                                                    sbuffer.append(cursor.getString(15)+ "\n");
                                                if (cursor.getString(16).length() > 1)
                                                    sbuffer.append(cursor.getString(16)+ "\n");
                                            }
                                            showRecipe(" Recipes ", sbuffer.toString());
                                        }
                                    }

        );
    }

    public void showRecipe (String title, String recipe){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(recipe);
        builder.show();

    }
}

