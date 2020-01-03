package com.spyc.trackingone.ui.embarqueStatus;

import com.spyc.trackingone.ui.base.MvpPresenter;

public interface EmbarqueStatusMvpPresenter<V extends EmbarqueStatusContract> extends MvpPresenter<V> {
    void InRamp(String id);

    void fromRamp(String id);

    void inParkingSpace(String id);

    void fromParkingSpace(String id);

    void showMessage(String msg);
}
