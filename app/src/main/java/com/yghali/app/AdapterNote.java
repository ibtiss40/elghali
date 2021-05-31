package com.yghali.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class AdapterNote extends ArrayAdapter<blocnote> {



    public AdapterNote(@NonNull Context context, @NonNull List objects)

    {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        blocnote note = getItem(position);

        View newItem;
        LayoutInflater li = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        newItem = li.inflate(R.layout.element_note,parent,false);
            LinearLayout lineaire = newItem.findViewById(R.id.chaimae);
            TextView titr = newItem.findViewById(R.id.titre);
            LinearLayout lin = newItem.findViewById(R.id.lin);
            TextView content =newItem.findViewById(R.id.content);
        titr.setText(this.getItem(position).getNom());
        content.setText(this.getItem(position).getContenu());
        return convertView;
    }

}
