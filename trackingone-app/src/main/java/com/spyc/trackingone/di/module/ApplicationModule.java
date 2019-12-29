package com.spyc.trackingone.di.module;

import android.app.Application;
import android.content.Context;

import com.spyc.trackingone.data.AppDataManager;
import com.spyc.trackingone.data.DataManager;
import com.spyc.trackingone.data.db.AppDbHelper;
import com.spyc.trackingone.data.db.DbHelper;
import com.spyc.trackingone.data.network.ApiHeader;
import com.spyc.trackingone.data.network.ApiHelper;
import com.spyc.trackingone.data.network.AppApiHelper;
import com.spyc.trackingone.data.prefs.AppPreferencesHelper;
import com.spyc.trackingone.data.prefs.PreferencesHelper;
import com.spyc.trackingone.di.ApiInfo;
import com.spyc.trackingone.di.ApplicationContext;
import com.spyc.trackingone.di.DatabaseInfo;
import com.spyc.trackingone.di.PreferenceInfo;
import com.spyc.trackingone.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import com.spyc.trackingone.BuildConfig;
import com.spyc.trackingone.R;

/**
 * Created by JorgeNami on 17/03/2018.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }

}
