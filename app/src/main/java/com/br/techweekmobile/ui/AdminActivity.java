package com.br.techweekmobile.ui;

import android.os.Bundle;

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
        rvParticipants.setAdapter(adapter);

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
