package com.br.techweekmobile.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.br.techweekmobile.R;
import com.br.techweekmobile.model.Participant;

import java.util.ArrayList;
import java.util.List;

public class CoffeeParticipantAdapter extends RecyclerView.Adapter<CoffeeParticipantAdapter.ViewHolder> {

    private List<Participant> participants = new ArrayList<>();
    private OnDeleteClickListener deleteClickListener;

    public interface OnDeleteClickListener {
        void onDeleteClick(Participant participant);
    }

    public void setOnDeleteClickListener(OnDeleteClickListener listener) {
        this.deleteClickListener = listener;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_participant_coffee, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Participant p = participants.get(position);
        holder.tvNome.setText(p.getNome());
        holder.tvRa.setText("RA: " + p.getRa());
        holder.tvCurso.setText(p.getCurso() + " - " + p.getSerie());

        holder.btnDelete.setOnClickListener(v -> {
            if (deleteClickListener != null) {
                deleteClickListener.onDeleteClick(p);
            }
        });
    }

    @Override
    public int getItemCount() {
        return participants.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNome, tvRa, tvCurso;
        ImageButton btnDelete;

        ViewHolder(View itemView) {
            super(itemView);
            tvNome = itemView.findViewById(R.id.tv_nome_participant);
            tvRa = itemView.findViewById(R.id.tv_ra_participant);
            tvCurso = itemView.findViewById(R.id.tv_curso_participant);
            btnDelete = itemView.findViewById(R.id.btn_delete_participant);
        }
    }
}
