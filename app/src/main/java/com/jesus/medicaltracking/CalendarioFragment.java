package com.jesus.medicaltracking;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.EditText;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarioFragment extends Fragment  {
    Button configuracionButton;
    EditText calendarioEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calendario, container, false);


        calendarioEditText = (EditText) v.findViewById(R.id.calendarioEditText);
        configuracionButton = (Button) v.findViewById(R.id.configuracionButton);

        //Obtengo la fecha actual
        Date cDate = new Date();
        String fDate = new SimpleDateFormat("dd/MM/yyyy").format(cDate);
        //Edita el EditText con la fecha actual
        calendarioEditText.setText(fDate);
        FechaGlobal.fechaGlobal = calendarioEditText.getText().toString();

        configuracionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Abre un activity desde un fragment
                Intent intent = new Intent(getActivity(), ConfigActivity.class);
                ((MainActivity) getActivity()).startActivity(intent);

            }
        });


        calendarioEditText.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            showDatePickerDialog();
            }
        });


        return v;
    }
    private void showDatePickerDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 Porque enero es 0
                final String selectedDate = day + "/" + (month+1) + "/" + year;
                calendarioEditText.setText(selectedDate);
                FechaGlobal.fechaGlobal = calendarioEditText.getText().toString();
            }
        });

        newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
    }
}