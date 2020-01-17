package com.spyc.trackingone.ui.detalleEmbarque;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.spyc.trackingone.R;
import com.spyc.trackingone.data.network.model.FilaEmbarqueResponse;

import java.util.List;

public class TableViewAdapter extends RecyclerView.Adapter
{

    List<FilaEmbarqueResponse> embargueList;

    public TableViewAdapter(List<FilaEmbarqueResponse> movieList) {
        this.embargueList = movieList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.table_embargue_list_item, parent, false);

        return new RowViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RowViewHolder rowViewHolder = (RowViewHolder) holder;

        int rowPos = rowViewHolder.getAdapterPosition();
        if (rowPos == 0) {
            rowViewHolder.txtembargue.setText("Embarque");
            rowViewHolder.txtcaja.setText("Caja");
        }
        else {

            FilaEmbarqueResponse modal = embargueList.get(rowPos-1);
            rowViewHolder.txtembargue.setText(modal.getShipping_number()==null?"":modal.getShipping_number()+"");
            rowViewHolder.txtcaja.setText(modal.getContainer()==null?"":modal.getContainer()+"");
        }
    }

    @Override
    public int getItemCount() {
        return embargueList.size()+1; // one more to add header row
    }

    public class RowViewHolder extends RecyclerView.ViewHolder {
        protected TextView txtcaja;
        protected TextView txtembargue;
        public RowViewHolder(View itemView) {
            super(itemView);
            txtembargue = itemView.findViewById(R.id.txtembarque);
            txtcaja = itemView.findViewById(R.id.txtcaja);

        }
    }
}