package com.spyc.trackingone.data;

import com.spyc.trackingone.data.db.DbHelper;
import com.spyc.trackingone.data.network.ApiHeader;
import com.spyc.trackingone.data.network.ApiHelper;
import com.spyc.trackingone.data.prefs.PreferencesHelper;

import java.io.File;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Jorge Namitle on 24/03/2018.
 */

public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper {

    ApiHeader getApiHeader();

    String getAccessToken();
    String getRefreshToken();

    void setAccessToken(String accessToken);
    void setRefreshToken(String refreshToken);

    void updateApiHeader(String accessToken);

    void setUserAsLoggedOut();

    Observable<Boolean> seedDatabaseQuestions();

    Observable<Boolean> seedDatabaseOptions();

    void updateUserInfo(
            Long userId,
            LoggedInMode loggedInMode,
            String userName,
            String email
            );

    void updateApiAccessInfo(
            Long id
    );

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}
