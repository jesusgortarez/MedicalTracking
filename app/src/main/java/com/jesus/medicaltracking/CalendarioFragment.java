package com.jesus.medicaltracking;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DateFormat;
import java.util.Calendar;

public class CalendarioFragment extends Fragment  {
    Button configuracionButton;
    EditText calendarioEditText;
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

        calendarioEditText = (EditText) v.findViewById(R.id.calendarioEditText);
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
                // +1 because January is zero
                final String selectedDate = day + " / " + (month+1) + " / " + year;
                calendarioEditText.setText(selectedDate);
            }
        });

        newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
    }
}