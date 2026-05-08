package com.br.techweekmobile.ui;

import android.content.Context;

import com.br.techweekmobile.database.AppDatabase;
import com.br.techweekmobile.model.Checkin;
import com.br.techweekmobile.model.Participant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CheckInManager {

    private final Context appContext;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public interface CheckInCallback {
        void onSucesso(String mensagem);

        void onErro(String mensagem);
    }

    public CheckInManager(Context context) {
        this.appContext = context.getApplicationContext();
    }

    public void realizarCheckIn(String ra, CheckInCallback callback) {
        executor.execute(() -> {
            try {
                Participant p = AppDatabase.getInstance(appContext)
                        .participantDao()
                        .findByRa(ra);
                if (p == null) {
                    callback.onErro("RA não encontrado. Faça o cadastro primeiro.");
                    return;
                }
                Checkin existente = AppDatabase.getInstance(appContext)
                        .checkInDao()
                        .findAnyByParticipantId(p.getId());
                if (existente != null) {
                    callback.onSucesso("Check-in já registrado anteriormente.");
                    return;
                }
                Checkin c = new Checkin();
                c.setParticipantId(p.getId());
                c.setTalkId(null);
                c.setTimestamp(System.currentTimeMillis());
                AppDatabase.getInstance(appContext).checkInDao().insert(c);
                callback.onSucesso("Presença confirmada. Bem-vindo(a), " + p.getNome() + "!");
            } catch (Exception e) {
                callback.onErro("Não foi possível concluir o check-in. Tente novamente.");
            }
        });
    }

    public void shutdown() {
        executor.shutdown();
    }
}
