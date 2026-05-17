package com.br.techweekmobile.ui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.br.techweekmobile.R;
import com.google.android.material.textfield.TextInputLayout;


public class MainActivity extends AppCompatActivity {

    private LinearLayout containerDia1, containerDia2, containerDia3;
    private Button btnDia1, btnDia2, btnDia3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar containers
        containerDia1 = findViewById(R.id.container_dia1);
        containerDia2 = findViewById(R.id.container_dia2);
        containerDia3 = findViewById(R.id.container_dia3);

        // Inicializar botões de dias
        btnDia1 = findViewById(R.id.btn_dia1);
        btnDia2 = findViewById(R.id.btn_dia2);
        btnDia3 = findViewById(R.id.btn_dia3);

        // Configurar cliques nos botões de dias
        btnDia1.setOnClickListener(v -> selecionarDia(1));
        btnDia2.setOnClickListener(v -> selecionarDia(2));
        btnDia3.setOnClickListener(v -> selecionarDia(3));

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

        // Inicializar com Dia 1 selecionado
        selecionarDia(1);
    }

    private void selecionarDia(int dia) {
        // Resetar visibilidade
        containerDia1.setVisibility(View.GONE);
        containerDia2.setVisibility(View.GONE);
        containerDia3.setVisibility(View.GONE);

        // Resetar estilo dos botões
        resetarEstiloBotao(btnDia1);
        resetarEstiloBotao(btnDia2);
        resetarEstiloBotao(btnDia3);

        // Ativar o dia selecionado
        if (dia == 1) {
            containerDia1.setVisibility(View.VISIBLE);
            ativarEstiloBotao(btnDia1);
        } else if (dia == 2) {
            containerDia2.setVisibility(View.VISIBLE);
            ativarEstiloBotao(btnDia2);
        } else if (dia == 3) {
            containerDia3.setVisibility(View.VISIBLE);
            ativarEstiloBotao(btnDia3);
        }
    }

    private void resetarEstiloBotao(Button btn) {
        btn.setTextColor(Color.parseColor("#666666"));
        btn.setTypeface(null, Typeface.NORMAL);
    }

    private void ativarEstiloBotao(Button btn) {
        btn.setTextColor(Color.parseColor("#1A0DAB"));
        btn.setTypeface(null, Typeface.BOLD);
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