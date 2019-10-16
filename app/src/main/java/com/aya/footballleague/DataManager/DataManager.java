package com.aya.footballleague.DataManager;


import com.aya.footballleague.DataManager.Remote.ApiHelper;
import com.aya.footballleague.DataManager.prefs.PreferencesHelper;

/**
 * Created by aya mohamed on 08/02/18.
 */

public interface DataManager extends PreferencesHelper, ApiHelper {

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_CLIENT_LOGIN(1),
        LOGGED_IN_MODE_PROVIDER_LOGIN(2),
        LOGGED_IN_MODE_PROVIDER_2IN1_LOGIN(3);

        private final int mType;

        LoggedInMode(int mType) {
            this.mType = mType;
        }

        public int getType() {
            return mType;
        }

    }
    

}
