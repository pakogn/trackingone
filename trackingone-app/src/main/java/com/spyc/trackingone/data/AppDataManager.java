package com.spyc.trackingone.data;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.spyc.trackingone.data.db.DbHelper;
import com.spyc.trackingone.data.db.model.Option;
import com.spyc.trackingone.data.db.model.Question;
import com.spyc.trackingone.data.db.model.User;
import com.spyc.trackingone.data.network.ApiHeader;
import com.spyc.trackingone.data.network.ApiHelper;
import com.spyc.trackingone.data.network.model.CombosResponse;
import com.spyc.trackingone.data.network.model.CurrentUserResponse;
import com.spyc.trackingone.data.network.model.EmailRequest;
import com.spyc.trackingone.data.network.model.EmbarquesAsigadosRequest;
import com.spyc.trackingone.data.network.model.FilaEmbarqueResponse;
import com.spyc.trackingone.data.network.model.LoginRequest;
import com.spyc.trackingone.data.network.model.LoginResponse;
import com.spyc.trackingone.data.network.model.LogoutResponse;
import com.spyc.trackingone.data.prefs.PreferencesHelper;
import com.spyc.trackingone.di.ApplicationContext;
import com.spyc.trackingone.utils.AppConstants;
import com.spyc.trackingone.utils.CommonUtils;

import java.io.File;
import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }

    @Override
    public String getAccessToken() {
        return mPreferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPreferencesHelper.setAccessToken(accessToken);
        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }

    @Override
    public String getRefreshToken() {
        return mPreferencesHelper.getRefreshToken();
    }

    @Override
    public void setRefreshToken(String refreshToken) {
        mPreferencesHelper.setRefreshToken(refreshToken);
    }

    @Override
    public Observable<Long> insertUser(User user) {
        return mDbHelper.insertUser(user);
    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return mDbHelper.getAllUsers();
    }

    @Override
    public Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest
                                                              request) {
        return mApiHelper.doGoogleLoginApiCall(request);
    }

    @Override
    public Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest
                                                                request) {
        return mApiHelper.doFacebookLoginApiCall(request);
    }

    @Override
    public Single<CurrentUserResponse> getCurrentUserApiCall() {
        return mApiHelper.getCurrentUserApiCall();
    }

    @Override
    public Single<List<FilaEmbarqueResponse>> getEmbarqueApiCall(String id) {
        return mApiHelper.getEmbarqueApiCall(id);
    }

    @Override
    public Single postInRamp(String id) {
        return mApiHelper.postInRamp(id);
    }

    @Override
    public Single postDetails(String id, EmbarquesAsigadosRequest request) {
        return mApiHelper.postDetails(id,request);
    }

    @Override
    public Single postFromRamp(String id) {
        return mApiHelper.postFromRamp(id);
    }

    @Override
    public Single postInParkingSpace(String id) {
        return mApiHelper.postInParkingSpace(id);
    }

    @Override
    public Single postFromParkingSpace(String id) {
        return mApiHelper.postFromParkingSpace(id);
    }

    @Override
    public Single<List<CombosResponse>> getCombos() {
        return mApiHelper.getCombos();
    }

    @Override
    public Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest
                                                              request) {
        return mApiHelper.doServerLoginApiCall(request);
    }

    @Override
    public Single<LogoutResponse> doLogoutApiCall() {
        return mApiHelper.doLogoutApiCall();
    }

    @Override
    public Single<String> doEmailApiCall(String id,EmailRequest request, String token) {
        return mApiHelper.doEmailApiCall(id,request, token);
    }


    @Override
    public int getCurrentUserLoggedInMode() {
        return mPreferencesHelper.getCurrentUserLoggedInMode();
    }

    @Override
    public void setCurrentUserLoggedInMode(LoggedInMode mode) {
        mPreferencesHelper.setCurrentUserLoggedInMode(mode);
    }

    @Override
    public Long getCurrentUserId() {
        return mPreferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(Long userId) {
        mPreferencesHelper.setCurrentUserId(userId);
    }

    @Override
    public Long getCurrentAuht() {
        return mPreferencesHelper.getCurrentAuht();
    }

    @Override
    public void setCurrentAuth(Long auth) {
        mPreferencesHelper.setCurrentAuth(auth);
    }

    @Override
    public String getCurrentUserName() {
        return mPreferencesHelper.getCurrentUserName();
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPreferencesHelper.setCurrentUserName(userName);
    }

    @Override
    public String getCurrentUserEmail() {
        return mPreferencesHelper.getCurrentUserEmail();
    }

    @Override
    public void setCurrentUserEmail(String email) {
        mPreferencesHelper.setCurrentUserEmail(email);
    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return mPreferencesHelper.getCurrentUserProfilePicUrl();
    }

    @Override
    public void setCurrentUserProfilePicUrl(String profilePicUrl) {
        mPreferencesHelper.setCurrentUserProfilePicUrl(profilePicUrl);
    }

    @Override
    public void updateApiHeader(String accessToken) {
        // mApiHelper.getApiHeader().getProtectedApiHeader().setUserId(userId);
        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }


    @Override
    public void updateUserInfo(
            Long userId,
            Long auth,
            LoggedInMode loggedInMode,
            String userName,
            String email) {

        setCurrentUserId(userId);
        setCurrentAuth(auth);
        setCurrentUserLoggedInMode(loggedInMode);
        setCurrentUserName(userName);
        setCurrentUserEmail(email);
    }

    @Override
    public void updateApiAccessInfo(Long id) {
        // setAccessToken(id);
    }


    /*
    @Override
    public void updateApiAccessInfo(String tokenType, Long expiresIn, String accessToken, String refreshToken) {

        setAccessToken(accessToken);
        // updateApiHeader(accessToken);
    }

    @Override
    public void updateUserInfo(
            Long userId,
            LoggedInMode loggedInMode,
            String userName,
            String email,
            String profilePicPath
    ) {

        // setAccessToken(accessToken);
        setCurrentUserId(userId);
        setCurrentUserLoggedInMode(loggedInMode);
        setCurrentUserName(userName);
        setCurrentUserEmail(email);
        setCurrentUserProfilePicUrl(profilePicPath);
        // updateApiHeader(userId, accessToken);
    }

     */



    @Override
    public void setUserAsLoggedOut() {
        updateUserInfo(
                null,
                null,
                DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT,
                null,
                null);
    }

    @Override
    public Observable<Boolean> isQuestionEmpty() {
        return mDbHelper.isQuestionEmpty();
    }

    @Override
    public Observable<Boolean> isOptionEmpty() {
        return mDbHelper.isOptionEmpty();
    }

    @Override
    public Observable<Boolean> saveQuestion(Question question) {
        return mDbHelper.saveQuestion(question);
    }

    @Override
    public Observable<Boolean> saveOption(Option option) {
        return mDbHelper.saveOption(option);
    }

    @Override
    public Observable<Boolean> saveQuestionList(List<Question> questionList) {
        return mDbHelper.saveQuestionList(questionList);
    }

    @Override
    public Observable<Boolean> saveOptionList(List<Option> optionList) {
        return mDbHelper.saveOptionList(optionList);
    }

    @Override
    public Observable<List<Question>> getAllQuestions() {
        return mDbHelper.getAllQuestions();
    }

    @Override
    public Observable<Boolean> seedDatabaseQuestions() {
        GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();

        return mDbHelper.isQuestionEmpty()
                .concatMap(new Function<Boolean, ObservableSource<? extends Boolean>>() {
                    @Override
                    public ObservableSource<? extends Boolean> apply(Boolean isEmpty)
                            throws Exception {
                        if (isEmpty) {
                            Type type = $Gson$Types
                                    .newParameterizedTypeWithOwner(null, List.class,
                                            Question.class);
                            List<Question> questionList = gson.fromJson(
                                    CommonUtils.loadJSONFromAsset(mContext,
                                            AppConstants.SEED_DATABASE_QUESTIONS),
                                    type);

                            return saveQuestionList(questionList);
                        }
                        return Observable.just(false);
                    }
                });
    }

    @Override
    public Observable<Boolean> seedDatabaseOptions() {

        GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();

        return mDbHelper.isOptionEmpty()
                .concatMap(new Function<Boolean, ObservableSource<? extends Boolean>>() {
                    @Override
                    public ObservableSource<? extends Boolean> apply(Boolean isEmpty)
                            throws Exception {
                        if (isEmpty) {
                            Type type = new TypeToken<List<Option>>() {
                            }
                                    .getType();
                            List<Option> optionList = gson.fromJson(
                                    CommonUtils.loadJSONFromAsset(mContext,
                                            AppConstants.SEED_DATABASE_OPTIONS),
                                    type);

                            return saveOptionList(optionList);
                        }
                        return Observable.just(false);
                    }
                });
    }



}
