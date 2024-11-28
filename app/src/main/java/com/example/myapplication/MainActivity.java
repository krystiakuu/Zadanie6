package com.example.myapplication;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView komunikat;
    private EditText email;
    private EditText haslo;
    private EditText phaslo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUI();

        Button przycisk = findViewById(R.id.przycisk);
        przycisk.setOnClickListener(v -> walidacja());
    }

    private void initializeUI() {
        komunikat = findViewById(R.id.acc);
        email = findViewById(R.id.mail);
        haslo = findViewById(R.id.pass1);
        phaslo = findViewById(R.id.pass2);
    }

    private void walidacja() {
        String Mail = email.getText().toString().trim();
        String Pass = haslo.getText().toString().trim();
        String Passp = phaslo.getText().toString().trim();

        if (Mail.isEmpty()) {
            komunikat.setText("Prosze wprowadzic adres e-mail");
        } else if (!Mail.contains("@")) {
            komunikat.setText("Niepoprawny adres e-mail");
        } else if (Pass.isEmpty()) {
            komunikat.setText("Prosze wprowadzic haslo");
        } else if (Passp.isEmpty()) {
            komunikat.setText("Prosze powtorzyc haslo");
        } else if (!Pass.equals(Passp)) {
            komunikat.setText("Hasla sie roznia");
        } else {
            komunikat.setText("Witaj " + Mail);
        }
    }
}
