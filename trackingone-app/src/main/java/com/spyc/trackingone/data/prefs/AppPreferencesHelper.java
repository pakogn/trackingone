package com.spyc.trackingone.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.spyc.trackingone.data.DataManager;
import com.spyc.trackingone.di.ApplicationContext;
import com.spyc.trackingone.di.PreferenceInfo;
import com.spyc.trackingone.utils.AppConstants;

import javax.inject.Inject;

/**
 * Created by Jorge Namitle on 24/03/2018.
 */

public class AppPreferencesHelper implements PreferencesHelper{

    private static final String PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE";
    private static final String PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID";
    private static final String PREF_KEY_USER_AUHT_IN_MODE = "PREF_KEY_AUHT_LOGGED_IN_MODE";
    private static final String PREF_KEY_CURRENT_USER_AUHT = "PREF_KEY_CURRENT_USER_AUHT";
    private static final String PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME";
    private static final String PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL";
    private static final String PREF_KEY_CURRENT_USER_PROFILE_PIC_URL
            = "PREF_KEY_CURRENT_USER_PROFILE_PIC_URL";
    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";
    private static final String PREF_KEY_REFRESH_TOKEN = "PREF_KEY_REFRESH_TOKEN";
    private static final String PREF_KEY_CURRENT_ACTIVITY_LOG_ID = "PREF_KEY_CURRENT_ACTIVITY_LOG_ID";

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context,
                                @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public Long getCurrentUserId() {
        long userId = mPrefs.getLong(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX);
        return userId == AppConstants.NULL_INDEX ? null : userId;
    }

    @Override
    public void setCurrentUserId(Long userId) {
        long id = userId == null ? AppConstants.NULL_INDEX : userId;
        mPrefs.edit().putLong(PREF_KEY_CURRENT_USER_ID, id).apply();
    }

    @Override
    public Long getCurrentAuht() {
        Long auth = mPrefs.getLong(PREF_KEY_CURRENT_USER_AUHT, AppConstants.NULL_INDEX);
        return auth == AppConstants.NULL_INDEX ? null : auth;
    }

    @Override
    public void setCurrentAuth(Long userAuth) {
        long auth = userAuth == null ? AppConstants.NULL_INDEX : userAuth;
        mPrefs.edit().putLong(PREF_KEY_CURRENT_USER_AUHT, auth).apply();
    }

    @Override
    public String getCurrentUserName() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_NAME, null);
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_NAME, userName).apply();
    }

    @Override
    public String getCurrentUserEmail() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_EMAIL, null);
    }

    @Override
    public void setCurrentUserEmail(String email) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_EMAIL, email).apply();
    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_PROFILE_PIC_URL, null);
    }

    @Override
    public void setCurrentUserProfilePicUrl(String profilePicUrl) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_PROFILE_PIC_URL, profilePicUrl).apply();
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return mPrefs.getInt(PREF_KEY_USER_LOGGED_IN_MODE,
                DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType());
    }

    @Override
    public void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode) {
        mPrefs.edit().putInt(PREF_KEY_USER_LOGGED_IN_MODE, mode.getType()).apply();
    }

    @Override
    public String getAccessToken() {
        return mPrefs.getString(PREF_KEY_ACCESS_TOKEN, null);
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply();
    }

    @Override
    public String getRefreshToken() {
        return mPrefs.getString(PREF_KEY_REFRESH_TOKEN, null);
    }

    @Override
    public void setRefreshToken(String refreshToken) {
        mPrefs.edit().putString(PREF_KEY_REFRESH_TOKEN, refreshToken).apply();
    }

    @Override
    public Long getCurrentActivityLogId() {
        long userId = mPrefs.getLong(PREF_KEY_CURRENT_ACTIVITY_LOG_ID, AppConstants.NULL_INDEX);
        return userId == AppConstants.NULL_INDEX ? null : userId;
    }

    @Override
    public void setCurrentActivityLogId(Long activityLogId) {
        long id = activityLogId == null ? AppConstants.NULL_INDEX : activityLogId;
        mPrefs.edit().putLong(PREF_KEY_CURRENT_ACTIVITY_LOG_ID, id).apply();
    }

}
