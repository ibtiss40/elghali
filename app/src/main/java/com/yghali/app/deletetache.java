package com.yghali.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class deletetache  extends Dialog implements
        View.OnClickListener{
    public deletetache(@NonNull Context context) {
        super(context);
    }

    @Override
    public void onClick(View v) {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_tache);
        Button btnsup =findViewById(R.id.supprimer);
        Button annuler =findViewById(R.id.btnX);

        annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { deletetache.this.dismiss(); }
        });
    }
}
