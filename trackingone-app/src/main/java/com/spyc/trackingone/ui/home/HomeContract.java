package com.spyc.trackingone.ui.home;

import com.spyc.trackingone.ui.base.MvpViewContract;

/**
 * Created by Jorge Namitle on 21/03/2018.
 */

public interface HomeContract extends MvpViewContract{

    void openLoginActivity();

    void abrirEmbarques();

    void updateUserName(String currentUserName);

    void updateUserEmail(String currentUserEmail);

    void closeNavigationDrawer();

    void lockDrawer();

    void unlockDrawer();

}
