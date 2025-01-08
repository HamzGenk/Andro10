package com.example.andro10;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    EditText editText1, editText2;
    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        editText2=findViewById(R.id.editTextText);
        radio1=findViewById(R.id.radioButton);
        radio1=findViewById(R.id.radioButton2);
        radio1=findViewById(R.id.radioButton3);

        };

    public void showText(View view) {
        String nophone=editText2.getText().toString();
        String pilih="";
            if (radio1.isChecked()) {
                pilih="Telp Rumah";
            } else if (radio2.isChecked()) {
                pilih="Mobile";
            } else if (radio3.isChecked()) {
                pilih="Telp Kantor";
            }

        Toast.makeText(this, pilih+" : "+nophone, Toast.LENGTH_SHORT).show();
    }

}


