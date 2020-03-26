package com.spyc.trackingone.ui.Embarques;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.gson.Gson;
import com.spyc.trackingone.R;
import com.spyc.trackingone.data.network.model.FilaEmbarqueResponse;
import com.spyc.trackingone.ui.base.BaseViewHolder;
import com.spyc.trackingone.ui.detalleEmbarque.DetalleEmbarque;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EmbarquesAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private Callback mCallback;
    private List<FilaEmbarqueResponse> filaEmbarqueResponse;
    private List<FilaEmbarqueResponse> allData;

    Gson gson;

    public EmbarquesAdapter(List<FilaEmbarqueResponse> embarqueResponseList) {
        filaEmbarqueResponse = embarqueResponseList;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    public List<FilaEmbarqueResponse> getAllData() {
        return allData;
    }

    public void setAllData(List<FilaEmbarqueResponse> allData) {
        this.allData = allData;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.row_embarque, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                       LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false));
        }
    }


    @Override
    public int getItemViewType(int position) {
        if (filaEmbarqueResponse != null && filaEmbarqueResponse.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        if (filaEmbarqueResponse != null && filaEmbarqueResponse.size() > 0) {
            return filaEmbarqueResponse.size();
        } else {
            return 1;
        }
    }

    public void addItems(List<FilaEmbarqueResponse> embarqueList) {
        filaEmbarqueResponse.addAll(embarqueList);
        notifyDataSetChanged();
    }
    public void addItemsOne(FilaEmbarqueResponse embarqueList) {
        filaEmbarqueResponse.add(embarqueList);
        notifyDataSetChanged();
    }
    public void clearData() {
        filaEmbarqueResponse.clear();
        notifyDataSetChanged();
    }

    public interface Callback {
        void onBlogEmptyViewRetryClick();
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.embarque_btn)
        ImageButton embarque_btnImageButton;

        @BindView(R.id.fecha)
        TextView fechaTextView;

        @BindView(R.id.operador)
        TextView operadorTextView;

        @BindView(R.id.no_embarque)
        TextView no_embarqueTextView;

        @BindView(R.id.transportista)
        TextView transportistaTextView;

        @BindView(R.id.no_remolque)
        TextView no_remolqueTextView;

        @BindView(R.id.no_tractor)
        TextView no_tractorTextView;

        @BindView(R.id.caja)
        TextView cajaTextView;

        @BindView(R.id.placas)
        TextView placasTextView;

        @BindView(R.id.status)
        TextView status;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected void clear() {
            fechaTextView.setText("");
            operadorTextView.setText("");
            no_embarqueTextView.setText("");
            transportistaTextView.setText("");
            no_remolqueTextView.setText("");
            no_tractorTextView.setText("");
            cajaTextView.setText("");
            placasTextView.setText("");
            status.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);

            final FilaEmbarqueResponse fila = filaEmbarqueResponse.get(position);

            if(fila.getScheduled_date() != null) {
                fechaTextView.setText(fila.getScheduled_date());
            }
            if(fila.getDriver_id() != null) {
                operadorTextView.setText(fila.getDriver_id().toString());
            }
            if (fila.getShipping_number() != null) {
                no_embarqueTextView.setText(fila.getShipping_number());
            }
            if (fila.getCarrier_id() != null) {
                transportistaTextView.setText(fila.getCarrier_id().toString());
            }
            if (fila.getTrailer_number() != null) {
                no_remolqueTextView.setText(fila.getTrailer_number());
            }
            if (fila.getTruck_number() != null) {
                no_tractorTextView.setText(fila.getTruck_number());
            }
            if (fila.getContainer() != null) {
                cajaTextView.setText(fila.getContainer());
            }
            if (fila.getLicense_plate() != null) {
                placasTextView.setText(fila.getLicense_plate());
            }
            if(fila.getShipping_status() != null) {
                status.setText(fila.getShipping_status().getLabel());
            }

            embarque_btnImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gson = new Gson();
                    String fEmbarquesJSON = gson.toJson(fila);
                    String allJsonList = gson.toJson(getAllData());
                    Intent intent = new Intent(itemView.getContext(), DetalleEmbarque.class);
                    intent.putExtra("embarque", fEmbarquesJSON);
                    intent.putExtra("AllList", allJsonList);
                    itemView.getContext().startActivity(intent);
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gson = new Gson();
                    String fEmbarquesJSON = gson.toJson(fila);
                    String allJsonList = gson.toJson(getAllData());
                    Intent intent = new Intent(itemView.getContext(), DetalleEmbarque.class);
                    intent.putExtra("idMulero", fEmbarquesJSON);
                    intent.putExtra("AllList", allJsonList);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }

    public class EmptyViewHolder extends BaseViewHolder {

        @BindView(R.id.btn_retry)
        Button retryButton;

        @BindView(R.id.tv_message)
        TextView messageTextView;

        public EmptyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {

        }

        @OnClick(R.id.btn_retry)
        void onRetryClick() {
            if (mCallback != null)
                mCallback.onBlogEmptyViewRetryClick();
        }
    }

    public List<FilaEmbarqueResponse> getData(){
        return filaEmbarqueResponse;
    }

    public void setFilter(List<FilaEmbarqueResponse> newList){
        filaEmbarqueResponse = new ArrayList<>();
        filaEmbarqueResponse.addAll(newList);
        notifyDataSetChanged();
    }

}