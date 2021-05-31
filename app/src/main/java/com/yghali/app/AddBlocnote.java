package com.yghali.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class  AddBlocnote extends Dialog implements AdapterView.OnItemSelectedListener,android.view.View.OnClickListener {
    AlertDialog.Builder builder;
    private blocnote blocnote;
    private List<blocnote> lbloc = new ArrayList<>();
    AdapterNote adapter;

    public AddBlocnote(@NonNull Context context) {
        super(context);
    }

    @Override
    public void onClick(View v) {

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_note);
        Button close =findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { AddBlocnote.this.dismiss(); }
        });

        Button ajouter = findViewById(R.id.AddBlocnote);
        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText titre = findViewById(R.id.nom);
                EditText description = findViewById(R.id.description);
                if(!TextUtils.isEmpty(titre.getText().toString())&&!TextUtils.isEmpty(description.getText().toString()))
                {
                   // int id = blocnote.listblocnotes.size() ;
                    String titr = titre.getText().toString();
                    String descri = description.getText().toString();
                    blocnote newnote = new blocnote(titr,descri);
                    blocnote.listblocnotes.add(newnote);

                  //  Log.d("1",newnote.getContenu());


                    Log.d("1","mm");
                    AddBlocnote.this.dismiss();
                }
                else{
                    Log.i("98","erreur");
                    Toast.makeText(getContext(),"entrer les champs",Toast.LENGTH_LONG).show();}

            }
        } );

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
