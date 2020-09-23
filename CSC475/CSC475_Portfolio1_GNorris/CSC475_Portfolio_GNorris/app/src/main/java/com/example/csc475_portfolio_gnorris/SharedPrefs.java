package com.example.csc475_portfolio_gnorris;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import java.util.Set;


//Will store preferences and game information to make it accessable between activities.
//Stores locations set. Will also store username.

public class SharedPrefs {

    private SharedPreferences preferences;
    private SharedPreferences.Editor preferences_edit;
    private static SharedPrefs instance;

    public SharedPrefs(Context context)
    {
        initialize(context);
    }

    private void initialize(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        preferences_edit = preferences.edit();
    }

    public static SharedPrefs getInstance (Context context)
    {
        if (instance == null)
        {
            instance = new SharedPrefs(context);
        }
        return instance;
    }

    public void setLocationsSet(Set<String> locationsSet)
    {
        preferences_edit.putStringSet("locationsSet",locationsSet);
        clear();
        preferences_edit.commit();

    }

    public Set<String> getLocationsSet()
    {
        return preferences.getStringSet("locationsSet",null);
    }

    public void clear()
    {
        preferences_edit.clear();
        preferences_edit.commit();
    }

}
