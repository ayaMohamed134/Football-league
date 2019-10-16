package com.aya.footballleague.utils;

/**
 * Created by aya mohamed on 08/02/18.
 */

public final class AppConstants {

    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";
    public static final String PREF_NAME = "app_prefs";
    public static final boolean NULL_INDEX = false;
    public static final String STRING_NULL_INDEX = "null";
    // codes
    public static final String POST_METHOD = "POST";
    public static final String GET_METHOD = "GET";
    //TODO: add app db name
    public static final String DB_NAME = "local.db";
    public static final String ERROR_MESSAGE = "error";
    public static final String SUCCESS_MESSAGE = "success";
    public static final String REGISTER = "register";
    public static final String LOGIN = "login";
    public static final String PATCH_METHOD = "PATCH";
    public static final String DELETE_METHOD = "DELETE";
    public static final String PAY_TYPE = "0";

    // broadcast receiver intent filters
    public static final String REGISTRATION_COMPLETE = "registrationComplete";
    public static final String PUSH_NOTIFICATION = "pushNotification";
    // global topic to receive app wide push notifications
    public static final String TOPIC_GLOBAL = "global";
    // id to handle the notification in the notification tray
    public static final int NOTIFICATION_ID = 100;
    public static final int NOTIFICATION_ID_BIG_IMAGE = 101;
    public static final String SHARED_PREF = "firebase";
    public static final String FIREBASE_ID = "fcm_token";
    public static final String NOTIFICATION_COUNT = "notification_count";
    public static final int INT_NULL_INDEX = 0;
    public static final String AR = "ar";
    public static final String EN = "en";
    public static final String UR = "ur";
    public static final boolean BOOLEAN_NULL_INDEX = false;
    public static final String GUEST = "guest";
    public static final double FLOAT_NULL_INDEX = 0.0f;
    public static final String REFRESH = "refresh";
    public static final String LOAD = "load";
    public static final String TERMS = "terms";
    public static final String ABOUT = "about";
    public static final String DEFAULT_CAT_ID = "-1";
    public static final int VERTICAL = 0;
    public static final int GRID = 1;
    public static final String ADD_AD = "add_ad";
    public static final String SEARCH = "search";
    public static final String SUB_CAT = "sub_cat";
    public static final String SUB_CAT_ID = "sub_cat_id";
    public static final String CAT_ID = "cat_id";
    public static final String SUB_SUB_CAT_ID = "sub_sub_cat_id";
    public static final String BUY_COUPON = "buy_coupon";
    public static final String ACTIVE_COUPON = "active_coupon";
    public static final String ACTIVE_COUPON_ERROR = "active_coupon_error";
    public static final String ACTIVE_COUPON_DONE = "active_coupon_done";
    public static final String CLIENT_FILES_NAME = "client_files_";
    public static final String PROVIDER_FILES_NAME = "cv";
    public static final String FSH_WEBSITE = "https://signup.fasah.sa/register/";
    public static final int FILE_REQUEST_CODE = 205;
    public static final int CALL_PERMISSION = 5, DOWNLOAD_PERMISSION = 4, LOCATION_PERMISSION = 3;
    public static final String CV_FILE = "attach_cv";



    private AppConstants() {
        // This utility class is not publicly instantiable
    }
}
