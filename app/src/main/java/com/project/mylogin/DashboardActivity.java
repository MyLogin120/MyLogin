package com.project.mylogin; // Pastikan untuk mengganti dengan nama package Anda

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    private TextView textViewWelcome;
    private Button buttonLogout;
    private Button buttonSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        textViewWelcome = findViewById(R.id.textViewWelcome);
        buttonLogout = findViewById(R.id.buttonLogout);
        buttonSettings = findViewById(R.id.buttonSettings);

        // Ambil username dari intent jika diperlukan
        String username = getIntent().getStringExtra("USERNAME");
        textViewWelcome.setText("Selamat datang, " + username + "!");

        // Menangani klik tombol Logout
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kembali ke MainActivity (halaman login)
                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Selesaikan DashboardActivity agar pengguna tidak dapat kembali
            }
        });

        // Menangani klik tombol Pengaturan
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Di sini Anda bisa menambah intent untuk membuka Activity Pengaturan
                // Sebagai contoh, kita hanya menunjukkan Toast
                Toast.makeText(DashboardActivity.this, "Fungsi Pengaturan belum diimplementasikan.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
