package com.spyc.trackingone.ui.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Jorge Namitle on 18/03/2018.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    private int currentPosition;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    protected abstract void clear();

    public void onBind(int position){
        currentPosition = position;
        clear();
    }

    public int getCurrentPosition() {return currentPosition;}
}
