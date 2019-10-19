package com.aya.footballleague.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.aya.footballleague.di.PreferenceInfo;

import javax.inject.Inject;



/**
 * Created by aya mohamed on 08/02/18.
 */

public class AppPreferencesHelper implements PreferencesHelper {

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(Context context, @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

}
