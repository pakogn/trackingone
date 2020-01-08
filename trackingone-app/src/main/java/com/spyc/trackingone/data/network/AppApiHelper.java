package com.spyc.trackingone.data.network;

import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.spyc.trackingone.data.network.model.CombosResponse;
import com.spyc.trackingone.data.network.model.CurrentUserResponse;
import com.spyc.trackingone.data.network.model.EmailRequest;
import com.spyc.trackingone.data.network.model.FilaEmbarqueResponse;
import com.spyc.trackingone.data.network.model.LoginRequest;
import com.spyc.trackingone.data.network.model.LoginResponse;
import com.spyc.trackingone.data.network.model.LogoutResponse;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Jorge Namitle on 24/03/2018.
 */

public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_GOOGLE_LOGIN)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest
                                                                request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_FACEBOOK_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<LogoutResponse> doLogoutApiCall() {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGOUT)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectSingle(LogoutResponse.class);
    }


    @Override
    public Single<String> doEmailApiCall(String id, EmailRequest request, String token) {
        return Rx2AndroidNetworking.post(ApiEndPoint.POST_SENDEMAIL.replace("{penalty}", id))
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addHeaders("Authorization", "Bearer " + token)
                .addBodyParameter(request)
                .build()
                .getStringSingle();
                //.getObjectSingle(EmailResponse.class);
    }

    @Override
    public Single<CurrentUserResponse> getCurrentUserApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_CURRENT_USER)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectSingle(CurrentUserResponse.class);
    }

    @Override
    public Single<List<FilaEmbarqueResponse>> getEmbarqueApiCall(String id) {
        return Rx2AndroidNetworking.get(ApiEndPoint.URL_EMBARQUES)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .addHeaders("Authorization", id)
                .build()
                .getObjectListSingle(FilaEmbarqueResponse.class);
    }

    @Override
    public Single postInRamp(String id) {
        return  Rx2AndroidNetworking.post(ApiEndPoint.IN_RAMP.replace("{shipping-schedules}", id))
                .addHeaders(mApiHeader.getPublicApiHeader())
                .build()
                .getObjectSingle(null);
    }

    @Override
    public Single postFromRamp(String id) {
        return  Rx2AndroidNetworking.post(ApiEndPoint.FROM_RAMP.replace("{shipping-schedules}", id))
                .addHeaders(mApiHeader.getPublicApiHeader())
                .build()
                .getObjectSingle(null);
    }

    @Override
    public Single postInParkingSpace(String id) {
        return  Rx2AndroidNetworking.post(ApiEndPoint.IN_PARKING_SPACE.replace("{shipping-schedules}", id))
                .addHeaders(mApiHeader.getPublicApiHeader())
                .build()
                .getObjectSingle(null);
    }

    @Override
    public Single postFromParkingSpace(String id) {
        return  Rx2AndroidNetworking.post(ApiEndPoint.FROM_PARKING_SPACE.replace("{shipping-schedules}", id))
                .addHeaders(mApiHeader.getPublicApiHeader())
                .build()
                .getObjectSingle(null);
    }

    @Override
    public Single<List<CombosResponse>> getCombos() {
        return Rx2AndroidNetworking.get(ApiEndPoint.GET_COMBOS)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectListSingle(CombosResponse.class);
    }

}
