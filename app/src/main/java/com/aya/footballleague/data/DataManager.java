package com.aya.footballleague.data;


import com.aya.footballleague.data.remote.ApiHelper;
import com.aya.footballleague.data.prefs.PreferencesHelper;

/**
 * Created by aya mohamed on 08/02/18.
 */

public interface DataManager extends PreferencesHelper, ApiHelper {

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_CLIENT_LOGIN(1);

        private final int mType;

        LoggedInMode(int mType) {
            this.mType = mType;
        }

        public int getType() {
            return mType;
        }

    }
}
