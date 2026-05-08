package com.br.techweekmobile.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.br.techweekmobile.R;

public class ProgramacaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programacao);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Programação");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        findViewById(R.id.btn_participar_1).setOnClickListener(v -> abrirCheckIn());
        findViewById(R.id.btn_participar_2).setOnClickListener(v -> abrirCheckIn());
        findViewById(R.id.btn_participar_3).setOnClickListener(v -> abrirCheckIn());
    }

    private void abrirCheckIn() {
        Intent intent = new Intent(this, CheckInActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}