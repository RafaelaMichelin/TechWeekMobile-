package com.br.techweekmobile.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.br.techweekmobile.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_programacao).setOnClickListener(v ->
                startActivity(new Intent(this, ProgramacaoActivity.class)));

        findViewById(R.id.btn_cadastro).setOnClickListener(v ->
                startActivity(new Intent(this, CadastroActivity.class)));

        findViewById(R.id.btn_palestrantes).setOnClickListener(v ->
                startActivity(new Intent(this, PalestrantesActivity.class)));

        findViewById(R.id.btn_checkin).setOnClickListener(v ->
                startActivity(new Intent(this, CheckInActivity.class)));

        findViewById(R.id.btn_faq).setOnClickListener(v ->
                startActivity(new Intent(this, FaqActivity.class)));

        findViewById(R.id.btn_localizacao).setOnClickListener(v ->
                startActivity(new Intent(this, LocalizacaoActivity.class)));

        findViewById(R.id.btn_admin).setOnClickListener(v ->
                startActivity(new Intent(this, AdminActivity.class)));
    }
}