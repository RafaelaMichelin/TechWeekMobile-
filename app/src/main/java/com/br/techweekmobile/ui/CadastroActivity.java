package com.br.techweekmobile.ui;

import android.os.Bundle;
import android.text.TextWatcher;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.br.techweekmobile.R;
// import com.techweekmobile.mvp.data.database.AppDatabase;
// import com.techweekmobile.mvp.data.entity.Participante;
// import com.techweekmobile.mvp.logic.ValidacaoUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CadastroActivity extends AppCompatActivity {

    private TextInputLayout tilNome, tilRa, tilCurso, tilSerie;
    private TextInputEditText etNome, etRa;
    private AutoCompleteTextView acCurso, acSerie;
    private CheckBox cbCoffeeBreak;
    private Button btnCadastrar;
    private ProgressBar progressBar;

    private ExecutorService executor;

    private static final String[] CURSOS = {
            "ADS - Análise e Desenvolvimento de Sistemas",
            "SI - Sistemas de Informação",
            "CC - Ciência da Computação",
            "BD - Banco de Dados",
            "GE - Gestão Empresarial",
            "Outro"
    };

    private static final String[] SERIES = {
            "1º Semestre", "2º Semestre",
            "3º Semestre", "4º Semestre",
            "5º Semestre", "6º Semestre"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        executor = Executors.newSingleThreadExecutor();

        bindViews();
        configurarDropdowns();
        configurarValidacaoEmTempoReal();
        configurarBotaoCadastrar();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Cadastro");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

