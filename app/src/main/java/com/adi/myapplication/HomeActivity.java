package com.adi.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    Button btnPlus, btnMinus, btnKali, btnBagi;
    TextView tvHasil;
    EditText et1, et2;
    double angka1, angka2, hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnKali = findViewById(R.id.btnKali);
        btnBagi = findViewById(R.id.btnBagi);
        tvHasil = findViewById(R.id.tvHasil);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);

        tambah();
        kurang();
        kali();
        bagi();

    }

    private void bagi() {
        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angka1 = Double.parseDouble(et1.getText().toString());
                angka2 = Double.parseDouble(et2.getText().toString());
                hasil = angka1 / angka2;
                tvHasil.setText(String.valueOf(hasil));
            }
        });
    }

    private void kali() {
        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angka1 = Double.parseDouble(et1.getText().toString());
                angka2 = Double.parseDouble(et2.getText().toString());
                hasil = angka1 * angka2;
                tvHasil.setText(String.valueOf(hasil));

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void kurang() {
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angka1 = Double.parseDouble(et1.getText().toString());
                angka2 = Double.parseDouble(et2.getText().toString());
                hasil = angka1 - angka2;
                tvHasil.setText(String.valueOf(hasil));
            }
        });
    }

    private void tambah() {
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angka1 = Double.parseDouble(et1.getText().toString());
                angka2 = Double.parseDouble(et2.getText().toString());
                hasil = angka1 + angka2;
                tvHasil.setText(String.valueOf(hasil));

            }
        });
    }
}
