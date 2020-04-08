package com.spyc.trackingone.ui.embarquesMulero;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
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
import com.spyc.trackingone.ui.embarqueStatus.EmbarqueStatusActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EmbarquesMuleroAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    Gson gson;

    private Callback mCallback;
    private List<FilaEmbarqueResponse> filaEmbarqueResponse;

    public EmbarquesMuleroAdapter(List<FilaEmbarqueResponse> embarqueResponseList) {
        filaEmbarqueResponse = embarqueResponseList;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new EmbarquesMuleroAdapter.ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.row_embarque_mulero, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmbarquesMuleroAdapter.EmptyViewHolder(
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

    public interface Callback {
        void onBlogEmptyViewRetryClick();
    }

    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.embarque_btn)
        ImageButton embarque_btnImageButton;

        @BindView(R.id.mu_embarque)
        TextView muEmbarqueTextView;

        @BindView(R.id.mu_fecha)
        TextView muFechaTextView;

        @BindView(R.id.mu_transportista)
        TextView muTransportistaTextView;

        @BindView(R.id.mu_no_caja)
        TextView muNoCajaTextView;

        @BindView(R.id.mu_no_embarque)
        TextView muNoRemolqueTextView;

        @BindView(R.id.mu_no_remolque)
        TextView muNoEmbarqueTextView;

        @BindView(R.id.mu_no_tractor)
        TextView muNoTractorTextView;

        @BindView(R.id.mu_tipo_movimiento)
        TextView muTipoMovTextView;

        @BindView(R.id.mu_cajon)
        TextView muCajonTextView;

        @BindView(R.id.mu_rampa)
        TextView muRampaTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected void clear() {
            muEmbarqueTextView.setText("");
            muFechaTextView.setText("");
            muTransportistaTextView.setText("");
            muNoCajaTextView.setText("");
            muNoEmbarqueTextView.setText("");
            muNoRemolqueTextView.setText("");
            muNoTractorTextView.setText("");
            muTipoMovTextView.setText("");
            muCajonTextView.setText("");
            muRampaTextView.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);

            final FilaEmbarqueResponse fila = filaEmbarqueResponse.get(position);

            if(fila.getShipping_number() != null) {
                muEmbarqueTextView.setText(fila.getShipping_number());
            }

            if(fila.getScheduled_date() != null) {
                muFechaTextView.setText(fila.getScheduled_date());
            }
            if(fila.getCarrier_id() != null) {
                muTransportistaTextView.setText(fila.getCarrier().getName());
            }
            if (fila.getContainer() != null) {
                muNoCajaTextView.setText(fila.getContainer());
            }
            if (fila.getShipping_number() != null) {
                muNoEmbarqueTextView.setText(fila.getShipping_number());
            }
            if (fila.getTrailer_number() != null) {
                muNoRemolqueTextView.setText(fila.getTrailer_number());
            }
            if (fila.getTruck_number() != null) {
                muNoTractorTextView.setText(fila.getTruck_number());
            }
            if (fila.getShipping_status_id() != null) {
                muTipoMovTextView.setText(fila.getShipping_status().getLabel());
            }
            if (fila.getInitial_parking_space() != null) {
                muCajonTextView.setText(fila.getInitial_parking_space());
            }
            if (fila.getRamp() != null) {
                muRampaTextView.setText(fila.getRamp());
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gson = new Gson();
                    String fEmbarquesJSON = gson.toJson(fila);

                    Intent intent = new Intent(itemView.getContext(), EmbarqueStatusActivity.class);
                    intent.putExtra("idMulero", fEmbarquesJSON);
                    itemView.getContext().startActivity(intent);
                }
            });

            embarque_btnImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gson = new Gson();
                    String fEmbarquesJSON = gson.toJson(fila);

                    Intent intent = new Intent(itemView.getContext(), EmbarqueStatusActivity.class);
                    intent.putExtra("idMulero", fEmbarquesJSON);
                    itemView.getContext().startActivity(intent);
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gson = new Gson();
                    String fEmbarquesJSON = gson.toJson(fila);

                    Intent intent = new Intent(itemView.getContext(), EmbarqueStatusActivity.class);
                    intent.putExtra("idMulero", fEmbarquesJSON);
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
