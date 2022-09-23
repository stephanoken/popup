package com.example.popup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    Button btnGrapes, btnCarrots, btnadd;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGrapes = findViewById(R.id.btnGrapes);
        btnCarrots = findViewById(R.id.btnCarrots);
        btnadd = findViewById(R.id.btnadd);



        dialog = new Dialog(this);


        btnGrapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog(1);
            }
        });

        btnCarrots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog(2);
            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { setContentView(R.layout.add);

            }
        });






    }

    private void ShowDialog(int btnNumber) {

        if (btnNumber == 1) {
            dialog.setContentView(R.layout.alert_dialog);
        } else {
            dialog.setContentView(R.layout.alert_dialog2);
        }

        Button PurchaseButton = dialog.findViewById(R.id.PurchaseButton);
        Button CancelButton = dialog.findViewById(R.id.CancelButton);



        PurchaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnNumber == 1) {
                    btnGrapes.setVisibility(View.GONE);
                } else {
                    btnCarrots.setVisibility(View.GONE);
                }
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Successfully Purchased!", Toast.LENGTH_SHORT).show();
            }
        });



        CancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.create();
        dialog.show();
    }


}