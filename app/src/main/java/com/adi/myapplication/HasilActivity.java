package com.adi.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HasilActivity extends AppCompatActivity {
    String hasil;
    TextView tvHasil;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        tvHasil = findViewById(R.id.tvHasil);
        sp = getSharedPreferences("Hasil", 0);
        hasil = sp.getString("penjumlahan", "");

        tvHasil.setText(hasil);
    }
}