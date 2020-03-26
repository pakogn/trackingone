package com.spyc.trackingone.data.network;

import com.spyc.trackingone.BuildConfig;

/**
 * Created by Jorge Namitle on 24/03/2018.
 */

public final class ApiEndPoint {

    public static final String ENDPOINT_GOOGLE_LOGIN = BuildConfig.BASE_URL
            + "/588d14f4100000a9072d2943";

    public static final String ENDPOINT_FACEBOOK_LOGIN = BuildConfig.BASE_URL
            + "/588d15d3100000ae072d2944";

    public static final String ENDPOINT_LOGOUT = BuildConfig.BASE_URL
            + "/588d161c100000a9072d2946";

    public static final String ENDPOINT_CURRENT_USER = BuildConfig.VIAL_URL
            + "/api/v1/user";



    public static final String URL_EMBARQUES = BuildConfig.TRACKING_URL
            + "/me/shipping-schedules";

    public static final String ENDPOINT_SERVER_LOGIN = BuildConfig.TRACKING_URL
            + "/login";

    public static final String IN_PARKING_SPACE = BuildConfig.TRACKING_URL
            + "/shipping-schedules/{shipping-schedules}/leave-in-parking-space";

    public static final String IN_RAMP = BuildConfig.TRACKING_URL
            + "/shipping-schedules/{shipping-schedules}/leave-in-ramp";

    public static final String FROM_RAMP = BuildConfig.TRACKING_URL
            + "/shipping-schedules/{shipping-schedules}/move-from-ramp";

    public static final String FROM_PARKING_SPACE = BuildConfig.TRACKING_URL
            + "/shipping-schedules/{shipping-schedules}/move-from-parking-space";

    public static  final String POST_SENDEMAIL = BuildConfig.VIAL_URL
            + "/api/v1/penalties/{penalty}/emails/send";

    public static  final String GET_COMBOS = BuildConfig.TRACKING_URL
            + "/yard-mule-drivers/available";
    public static  final String POST_EMBARQUE_DETALLLES = BuildConfig.TRACKING_URL
            + "/shipping-schedules/{id}/assign";
    public static  final String POST_COMENTARIOS_LOGIN = BuildConfig.TRACKING_URL
            + "/me/login/comment";

}
