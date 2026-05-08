package com.br.techweekmobile.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.br.techweekmobile.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btn_cadastro).setOnClickListener(v ->
                startActivity(new Intent(this, CadastroActivity.class)));



        findViewById(R.id.btn_admin).setOnClickListener(v ->
                startActivity(new Intent(this, AdminActivity.class)));

        // BOTÃO LOCALIZAÇÃO
        findViewById(R.id.btn_localizacao).setOnClickListener(v -> {

            String link = "https://maps.app.goo.gl/m58EQXCaRk3xrkPz5";

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
            startActivity(intent);
        });
    }
}