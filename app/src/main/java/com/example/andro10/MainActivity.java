package com.example.andro10;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int count1 = 0, count2 = 0;
    private int maxCount = 0;
    private TextView textView1, textView2, teamName1, teamName2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.text1);
        textView2 = findViewById(R.id.text2);
        teamName1 = findViewById(R.id.team_name_1);
        teamName2 = findViewById(R.id.team_name_2);

        // Set up the button to show input dialog
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInputDialog();
            }
        });

        // Set up the buttons to increment counts
        findViewById(R.id.button_count_up_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementCount(1);
            }
        });

        findViewById(R.id.button_count_up_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementCount(2);
            }
        });
    }

    private void showInputDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Masukkan Nama Tim dan Point Maks");

        // Inflate the custom dialog layout
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_input, null);
        builder.setView(dialogView);

        final EditText inputTeam1 = dialogView.findViewById(R.id.input_team_1);
        final EditText inputTeam2 = dialogView.findViewById(R.id.input_team_2);
        final EditText inputMaxCount = dialogView.findViewById(R.id.input_max_count);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    teamName1.setText(inputTeam1.getText().toString());
                    teamName2.setText(inputTeam2.getText().toString());
                    maxCount = Integer.parseInt(inputMaxCount.getText().toString());
                    resetCounts();
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid input. Please enter valid numbers.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("Cancel", null);
        builder.show();
    }

    private void resetCounts() {
        count1 = 0;
        count2 = 0;
        textView1.setText(String.valueOf(count1));
        textView2.setText(String.valueOf(count2));
    }

    private void incrementCount(int countNumber) {
        if (countNumber == 1) {
            count1++;
            textView1.setText(String.valueOf(count1));
            if (count1 >= maxCount) {
                showWinnerDialog(teamName1.getText().toString());
            }
        } else if (countNumber == 2) {
            count2++;
            textView2.setText(String.valueOf(count2));
            if (count2 >= maxCount) {
                showWinnerDialog(teamName2.getText().toString());
            }
        }
    }

    private void showWinnerDialog(String winner) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("We have a winner!");
        builder.setMessage(winner + " wins!");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                resetCounts();
            }
        });
        builder.show();
    }

    public void onShowToastClicked(View view) {
        Toast.makeText(MainActivity.this, "Hallo, Pengadil!", Toast.LENGTH_SHORT).show();
    }

}
