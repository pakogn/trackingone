package com.spyc.trackingone.ui.detalleEmbarque;

import com.spyc.trackingone.data.network.model.CombosResponse;
import com.spyc.trackingone.data.network.model.EmbarquesAsigadosResponse;
import com.spyc.trackingone.data.network.model.FilaEmbarqueResponse;
import com.spyc.trackingone.ui.base.MvpViewContract;

import java.util.List;

public interface DetalleEmbarqueContract extends MvpViewContract {

    void showCombosView(List<CombosResponse> response);
    void saveCorrect(EmbarquesAsigadosResponse res);

}
