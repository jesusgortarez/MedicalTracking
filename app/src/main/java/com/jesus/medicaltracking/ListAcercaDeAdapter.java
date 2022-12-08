package com.jesus.medicaltracking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
public class ListAcercaDeAdapter extends ArrayAdapter<ListAcercaDe> {

    ArrayList<ListAcercaDe> listAcercaDe;

    public ListAcercaDeAdapter(@NonNull Context context, int resource, @NonNull ArrayList<ListAcercaDe> listAcercaDe) {
        super(context, resource, listAcercaDe);
        this.listAcercaDe = listAcercaDe;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());

        convertView = layoutInflater.inflate(R.layout.item_acerca_de,parent,false);

        TextView listAcercaDeNameTextView = convertView.findViewById(R.id.listAcercaDeNameTextView);
        TextView listAcercaDeDataTextView = convertView.findViewById(R.id.listAcercaDeDataTextView);

        listAcercaDeNameTextView.setText(listAcercaDe.get(position).getName());
        listAcercaDeDataTextView.setText(listAcercaDe.get(position).getData());
        return convertView;
    }
}
