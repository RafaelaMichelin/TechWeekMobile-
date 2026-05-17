package com.br.techweekmobile.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.br.techweekmobile.R;
import com.br.techweekmobile.database.AppDatabase;
import com.br.techweekmobile.model.Participant;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AdminActivity extends AppCompatActivity {

    private RecyclerView rvParticipants;
    private CoffeeParticipantAdapter adapter;
    private Button btnVoltar;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Admin - Coffee Break");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        rvParticipants = findViewById(R.id.rv_participants_coffee);
        rvParticipants.setLayoutManager(new LinearLayoutManager(this));
        
        adapter = new CoffeeParticipantAdapter();
        adapter.setOnDeleteClickListener(this::confirmarExclusao);
        rvParticipants.setAdapter(adapter);

        btnVoltar = findViewById(R.id.btn_voltar_admin);
        btnVoltar.setOnClickListener(v -> finish());

        carregarParticipantesCoffee();
    }

    private void carregarParticipantesCoffee() {
        executor.execute(() -> {
            List<Participant> lista = AppDatabase.getInstance(this)
                    .participantDao()
                    .getCoffeeBreakParticipants();
            
            runOnUiThread(() -> adapter.setParticipants(lista));
        });
    }

    private void confirmarExclusao(Participant participant) {
        new AlertDialog.Builder(this)
                .setTitle("Confirmar Exclusão")
                .setMessage("Deseja realmente remover " + participant.getNome() + " da lista?")
                .setPositiveButton("Sim", (dialog, which) -> deletarParticipante(participant))
                .setNegativeButton("Não", null)
                .show();
    }

    private void deletarParticipante(Participant participant) {
        executor.execute(() -> {
            AppDatabase.getInstance(this).participantDao().delete(participant);
            runOnUiThread(() -> {
                Toast.makeText(this, "Participante removido!", Toast.LENGTH_SHORT).show();
                carregarParticipantesCoffee();
            });
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        executor.shutdown();
    }
}
