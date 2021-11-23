package com.example.lab_02_converter_illarionov_393;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Lab_02_Конвертер_Илларионов_393

    Spinner spFROM;
    Spinner spTO;
    EditText etFROM;
    TextView tvTO;
    double from = 0;
    double to = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spFROM = findViewById(R.id.lstFrom);
        spTO = findViewById(R.id.lstTo);
        etFROM = findViewById(R.id.txtFrom);
        tvTO = findViewById(R.id.labTo);

        ArrayAdapter<String> adp = new <String> ArrayAdapter(this, android.R.layout.simple_list_item_1);

        adp.add("mm");
        adp.add("cm");
        adp.add("m");
        adp.add("km");

        spFROM.setAdapter(adp);
        spTO.setAdapter(adp);

    }

    public int Errors(int a) //Errors

    {
        if (etFROM.length()==0)
        {
            tvTO.setText("Field is empty"); // If field is empty
            return -1;
        }
        try
        {
            from = Double.parseDouble(etFROM.getText().toString());

        }
        catch (Exception ex)
        {
            tvTO.setText("Value is not number"); //If value is not number
            return -1;
        }
        return 0;
    }

    public void on_convert(View V)
    {

        String sFrom = (String) spFROM.getSelectedItem();
        String sTo = (String) spTO.getSelectedItem();

        int res = Errors(1);
        if (res== -1)
        {
            return;
        }

        if (sFrom.equals("mm"))
        {
            if (sTo.equals("mm")) to = from * 1.0;
            if (sTo.equals("cm")) to = from * 0.1;
            if (sTo.equals("m")) to = from * 0.001;
            if (sTo.equals("km")) to = from * 0.000001;
        }

        if (sFrom.equals("cm"))
        {
            if (sTo.equals("mm")) to = from * 10.0;
            if (sTo.equals("cm")) to = from * 1.0;
            if (sTo.equals("m")) to = from * 0.01;
            if (sTo.equals("km")) to = from * 0.00001;
        }

        if (sFrom.equals("m"))
        {
            if (sTo.equals("mm")) to = from * 1000.0;
            if (sTo.equals("cm")) to = from * 100.0;
            if (sTo.equals("m")) to = from * 1.0;
            if (sTo.equals("km")) to = from * 0.001;
        }

        if (sFrom.equals("km"))
        {
            if (sTo.equals("mm")) to = from * 1000000.0;
            if (sTo.equals("cm")) to = from * 100000.0;
            if (sTo.equals("m")) to = from * 1000.0;
            if (sTo.equals("km")) to = from * 1.0;
        }

        tvTO.setText(String.valueOf(to));

    }
}