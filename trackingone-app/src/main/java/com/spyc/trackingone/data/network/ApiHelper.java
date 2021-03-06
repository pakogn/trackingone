package com.spyc.trackingone.data.network;

import com.spyc.trackingone.data.network.model.CombosResponse;
import com.spyc.trackingone.data.network.model.ComentariosMuleroRequest;
import com.spyc.trackingone.data.network.model.CurrentUserResponse;
import com.spyc.trackingone.data.network.model.EmailRequest;
import com.spyc.trackingone.data.network.model.EmbarquesAsigadosRequest;
import com.spyc.trackingone.data.network.model.EmbarquesAsigadosResponse;
import com.spyc.trackingone.data.network.model.FilaEmbarqueResponse;
import com.spyc.trackingone.data.network.model.LoginRequest;
import com.spyc.trackingone.data.network.model.LoginResponse;
import com.spyc.trackingone.data.network.model.LogoutResponse;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Jorge Namitle on 24/03/2018.
 */

public interface ApiHelper {

    ApiHeader getApiHeader();

    Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);

    Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    Single<LogoutResponse> doLogoutApiCall();

    Single<String> doEmailApiCall (String id, EmailRequest request, String token);

    Single<CurrentUserResponse> getCurrentUserApiCall();

    Single<List<FilaEmbarqueResponse>> getEmbarqueApiCall(String id);

    Single postInRamp(String id);
    Single<EmbarquesAsigadosResponse> postDetails(String id, EmbarquesAsigadosRequest request);

    Single postFromRamp(String id);

    Single postInParkingSpace(String id);

    Single postFromParkingSpace(String id);

    Single<List<CombosResponse>> getCombos();

    Single postComentariosMulero(ComentariosMuleroRequest request);

}
