package com.br.techweekmobile.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.br.techweekmobile.R;
import com.google.android.material.textfield.TextInputLayout;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btn_cadastro).setOnClickListener(v ->
                startActivity(new Intent(this, CadastroActivity.class)));



        findViewById(R.id.btn_admin).setOnClickListener(v ->
                mostrarDialogoSenhaAdmin());

        // BOTÃO LOCALIZAÇÃO
        findViewById(R.id.btn_localizacao).setOnClickListener(v -> {

            String link = "https://maps.app.goo.gl/m58EQXCaRk3xrkPz5";

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
            startActivity(intent);
        });
    }

    private void mostrarDialogoSenhaAdmin() {
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_admin_password, null);
        TextInputLayout tilPassword = view.findViewById(R.id.til_admin_password);
        EditText etPassword = view.findViewById(R.id.et_admin_password);

        new AlertDialog.Builder(this)
                .setTitle("Acesso Restrito")
                .setMessage("Digite a chave de acesso administrativa:")
                .setView(view)
                .setPositiveButton("Entrar", (dialog, which) -> {
                    String password = etPassword.getText().toString();
                    if ("admin123".equals(password)) { // Chave de acesso definida como 'admin123'
                        startActivity(new Intent(this, AdminActivity.class));
                    } else {
                        Toast.makeText(this, "Chave incorreta!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancelar", null)
                .show();
    }
}