// MIT License available at: https://github.com/HansenML/RecipeRealizer/blob/master/LICENSE
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

public class RemoveEdit extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText eName, ei1, ei2, ei3, ei4, ei5, ei6, ei7, ei8, ei9, ei10, ei11, ei12, ei13, ei14, ei15, RId;
    Button bSave;
    Button bViewAll;
    Button bUpdate;
    Button bRemove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remove_edit);
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
        RId = (EditText) findViewById(R.id.editText);
        bSave = (Button) findViewById(R.id.button_save);
        bViewAll = (Button) findViewById(R.id.button_view);
        bUpdate = (Button) findViewById(R.id.button_edit);
        bRemove = (Button) findViewById(R.id.button_remove);
        viewAll();
        addRecipe();
        updateRecipeByID();
        removeRecipe();
    }
    public void removeRecipe(){
        bRemove.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick (View v) {
                        Integer removedRecipe = myDB.removeRecipe(RId.getText().toString());
                        if (removedRecipe > 0)
                            Toast.makeText(RemoveEdit.this, "Recipe Removal Successful. \nRemoved: " +
                                    RId.getText().toString() + "Recipe.", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(RemoveEdit.this, "Recipe deletion FAILED", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void addRecipe() {
        bSave.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         startActivity(new Intent(RemoveEdit.this, AddRecipe.class));
                                     }
                                 }
        );
    }

    public void updateRecipeByID () {
        bUpdate.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick (View v){
                        boolean isUpdated = myDB.updateRecipe(RId.getText().toString(), eName.getText().toString(), ei1.getText().toString(),
                                ei2.getText().toString(), ei3.getText().toString(),
                                ei4.getText().toString(), ei5.getText().toString(),
                                ei6.getText().toString(), ei7.getText().toString(),
                                ei8.getText().toString(), ei9.getText().toString(),
                                ei10.getText().toString(), ei11.getText().toString(),
                                ei12.getText().toString(), ei13.getText().toString(),
                                ei14.getText().toString(), ei15.getText().toString());
                        if (isUpdated == true)
                            Toast.makeText(RemoveEdit.this, "Recipe Update Successful", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(RemoveEdit.this, "Recipe Update FAILED", Toast.LENGTH_LONG).show();
                    }
                });
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
                                                sbuffer.append("Recipe: " + cursor.getString(1)+"\n\n");
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

