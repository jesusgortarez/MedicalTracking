package com.jesus.medicaltracking;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class CalendarioFragment extends Fragment {
    Button configuracionButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calendario, container, false);

        configuracionButton = (Button) v.findViewById(R.id.configuracionButton);
        configuracionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Abre un activity desde un fragment
                Intent intent = new Intent(getActivity(), ConfigActivity.class);
                ((MainActivity) getActivity()).startActivity(intent);

            }
        });

        return v;
    }
}