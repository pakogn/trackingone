package com.spyc.trackingone.data.prefs;

import com.spyc.trackingone.data.DataManager;

/**
 * Created by Jorge Namitle on 24/03/2018.
 */

public interface PreferencesHelper {
    int getCurrentUserLoggedInMode();

    void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode);

    Long getCurrentUserId();

    void setCurrentUserId(Long userId);

    Long getCurrentAuht();

    void setCurrentAuth(Long auth);

    String getCurrentUserName();

    void setCurrentUserName(String userName);

    String getCurrentUserEmail();

    void setCurrentUserEmail(String email);

    String getCurrentUserProfilePicUrl();

    void setCurrentUserProfilePicUrl(String profilePicUrl);

    String getAccessToken();

    void setAccessToken(String accessToken);

    String getRefreshToken();

    void setRefreshToken(String refreshToken);

    Long getCurrentActivityLogId();

    void setCurrentActivityLogId(Long activityLogId);
}
