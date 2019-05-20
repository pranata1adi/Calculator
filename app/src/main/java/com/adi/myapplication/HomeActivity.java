package com.adi.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    Intent intent;
    TextView tvHasil;
    EditText et1, et2;
    SharedPreferences sp;
    double angka1, angka2, hasil;
    Button btnPlus, btnMinus, btnKali, btnBagi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        btnKali = findViewById(R.id.btnKali);
        btnBagi = findViewById(R.id.btnBagi);
        tvHasil = findViewById(R.id.tvHasil);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);

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
                if (!et1.getText().toString().equals("") && !et2.getText().toString().equals("")) {
                    angka1 = Double.parseDouble(et1.getText().toString());
                    angka2 = Double.parseDouble(et2.getText().toString());
                    hasil = angka1 + angka2;

                    sp = getSharedPreferences("Hasil", 0);
                    @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = sp.edit();
                    editor.putString("penjumlahan", String.valueOf(hasil));
                    editor.apply();
//                    intent.putExtra("hasil", hasil);

                    intent = new Intent(HomeActivity.this, HasilActivity.class);
                    startActivity(intent);

                    //ini buat blblbl
//                    tvHasil.setText(String.valueOf(hasil));
                } else {
                    Toast.makeText(HomeActivity.this, "Harap isi angkanya", Toast.LENGTH_SHORT).show();
                    if (et1.getText().toString().equals(""))
                        et1.setError("Harap isi angkanya");
                }
            }
        });
    }
}
