package com.spyc.trackingone.ui.detalleEmbarque;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.spyc.trackingone.R;
import com.spyc.trackingone.data.network.model.CombosResponse;

import java.util.List;



public class SpinnerAdapter extends ArrayAdapter<CombosResponse> {


    public SpinnerAdapter(@NonNull Context context, List<CombosResponse> data) {
        super(context,0,data);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CombosResponse actividad =getItem(position);
        if (convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.row_embarg,parent,false);
        }

        TextView txt = (TextView) convertView.findViewById(R.id.rEnbargueNombre);
        txt.setText(actividad.getFirst_name());
        return convertView;
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {
        CombosResponse embarque =getItem(position);
        if (convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.row_embarg,parent,false);
        }

        TextView txt = (TextView) convertView.findViewById(R.id.rEnbargueNombre);
        txt.setText(embarque.getFirst_name());

        return convertView;
    }
}
