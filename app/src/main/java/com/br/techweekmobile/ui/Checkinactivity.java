package com.br.techweekmobile.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.br.techweekmobile.R;
import com.br.techweekmobile.ui.Checkinmanager;
import com.br.techweekmobile.ui.ValidacaoUtils;


public class CheckInActivity extends AppCompatActivity {

    private TextInputLayout tilRa;
    private EditText etRa;
    private Button btnConfirmar;
    private ProgressBar progressBar;
    private TextView tvStatus;

    private CheckInManager checkInManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);

        checkInManager = new CheckInManager(this);

        bindViews();
        configurarBotao();
    }

    private void bindViews() {
        tilRa = findViewById(R.id.til_ra_checkin);
        etRa = findViewById(R.id.et_ra_checkin);
        btnConfirmar = findViewById(R.id.btn_confirmar_checkin);
        progressBar = findViewById(R.id.progress_checkin);
        tvStatus = findViewById(R.id.tv_status_checkin);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Confirmar Presença");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void configurarBotao() {
        btnConfirmar.setOnClickListener(v -> {
            String ra = etRa.getText().toString().trim();


            String erroRa = ValidacaoUtils.mensagemErroRA(ra);
            if (erroRa != null) {
                tilRa.setError(erroRa);
                return;
            }

            tilRa.setError(null);
            iniciarCheckIn(ra);
        });


        etRa.addTextChangedListener(new android.text.TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void afterTextChanged(android.text.Editable s) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tilRa.setError(null);
            }
        });
    }

    private void iniciarCheckIn(String ra) {
        setCarregando(true);
        tvStatus.setVisibility(View.GONE);

        checkInManager.realizarCheckIn(ra, new CheckInManager.CheckInCallback() {
            @Override
            public void onSucesso(String mensagem) {
                runOnUiThread(() -> {
                    setCarregando(false);
                    exibirStatus(mensagem, true);
                    etRa.setText("");
                    Snackbar.make(btnConfirmar, mensagem, Snackbar.LENGTH_LONG).show();
                });
            }

            @Override
            public void onErro(String mensagem) {
                runOnUiThread(() -> {
                    setCarregando(false);
                    exibirStatus(mensagem, false);
                    Snackbar.make(btnConfirmar, mensagem, Snackbar.LENGTH_LONG).show();
                });
            }
        });
    }

    private void setCarregando(boolean carregando) {
        progressBar.setVisibility(carregando ? View.VISIBLE : View.GONE);
        btnConfirmar.setEnabled(!carregando);
    }

    private void exibirStatus(String mensagem, boolean sucesso) {
        tvStatus.setVisibility(View.VISIBLE);
        tvStatus.setText(mensagem);
        int cor = sucesso
                ? ContextCompat.getColor(this, R.color.verde_sucesso)
                : ContextCompat.getColor(this, R.color.vermelho_erro);
        tvStatus.setTextColor(cor);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        checkInManager.shutdown();
    }
}
