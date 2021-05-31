package com.yghali.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.yghali.app.Model.Tache;

import java.util.List;

public class AdapterTache extends ArrayAdapter<Tache> {
    LayoutInflater inflater;
    public AdapterTache(@NonNull Context context, @NonNull List objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View newItem;
        LayoutInflater li = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        newItem = li.inflate(R.layout.element_tache,parent,false);
        TextView time = newItem.findViewById(R.id.timeR);
        LinearLayout LY = newItem.findViewById(R.id.gris);
        TextView titr = newItem.findViewById(R.id.titre);
        LinearLayout lin = newItem.findViewById(R.id.lin);
        TextView descr =newItem.findViewById(R.id.description);

        titr.setText(this.getItem(position).getName());
        descr.setText(this.getItem(position).getDescription());
        time.setText(this.getItem(position).getTime());
        return newItem;
    }
}
