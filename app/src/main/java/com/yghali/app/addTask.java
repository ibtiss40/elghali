package com.yghali.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.yghali.app.Model.Tache;

import java.util.ArrayList;
import java.util.List;

public class addTask extends AppCompatActivity {
    private Tache tache;
    private List<Tache> ltache = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_tache);
        EditText titre = findViewById(R.id.titre);
        EditText description = findViewById(R.id.description);
        EditText time = findViewById(R.id.time);
        Button btnadd = (Button) findViewById(R.id.AddNote);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(titre.getText().toString()) && !TextUtils.isEmpty(description.getText().toString()) && !TextUtils.isEmpty(time.getText().toString())) {
                    int id = tache.listtache.size() ;
                    String tite = titre.getText().toString();
                    String des = description.getText().toString();
                    String tim = time.getText().toString();
                    Fragment obj = new Fragment();
                     obj=new profil();
                    Tache newnote = new Tache(id,tite,des,tim);
                    newnote.listtache.add(newnote);
             //    FragmentManager frgManager = getSupportFragmentManager();
                //   frgManager.beginTransaction().replace(R.id.basma,obj).show(obj).commit();
                  //  obj.getView();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));

                }
                else{
                    Log.i("98","erreur");
                    Toast.makeText(getApplicationContext(),"entrer tout les champs",Toast.LENGTH_LONG).show();}





            }

        });}
}