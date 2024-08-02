package com.project.mylogin; // Ganti dengan nama package Anda

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;
    private LoginManager loginManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        // Inisialisasi LoginManager
        loginManager = new LoginManager();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                User user = new User(username, password);

                // Memvalidasi pengguna dengan LoginManager
                if (loginManager.validateUser(user)) {
                    // Pindah ke DashboardActivity
                    Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                    intent.putExtra("USERNAME", username); // Kirim username ke activity dashboard
                    startActivity(intent);
                    finish(); // Selesaikan MainActivity agar pengguna tidak dapat kembali ke halaman login
                } else {
                    Toast.makeText(MainActivity.this, "Username atau Password Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}