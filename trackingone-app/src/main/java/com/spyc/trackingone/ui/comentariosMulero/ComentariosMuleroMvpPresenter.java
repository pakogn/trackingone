package com.spyc.trackingone.ui.comentariosMulero;

import com.spyc.trackingone.ui.base.MvpPresenter;

/**
 * Created by Jorge Namitle on 21/03/2018.
 */

public interface ComentariosMuleroMvpPresenter<V extends ComentariosMuleroContract> extends MvpPresenter<V> {

    void onComentariosMuleroClick(String comentarios);

}
