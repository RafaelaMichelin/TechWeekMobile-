package com.br.techweekmobile.ui;

import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.concurrent.ExecutorService;

public class CadastroActivity extends AppCompatActivity {

    private TextInputLayout tilNome, tilRa, tilCurso, tilSerie;
    private TextInputEditText etNome, etRa;
    private AutoCompleteTextView acCurso, acSerie;
    private CheckBox cbCoffeeBreak;
    private Button btnCadastrar;
    private ProgressBar progressBar;

    private ExecutorService executor;