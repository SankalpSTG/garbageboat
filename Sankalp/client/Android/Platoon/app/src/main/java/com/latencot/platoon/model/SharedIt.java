package com.latencot.platoon.model;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedIt {
    Context shr;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    public SharedIt(Context shr){
        this.shr = shr;

    }
    public void addpreference(String preference, String key){
        sharedPref = shr.getSharedPreferences("platoon", Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        editor.putString(key, preference);
        editor.apply();
    }

    public String extractpreference(String preference){
        sharedPref = shr.getSharedPreferences("platoon", Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        String extracted_preference = sharedPref.getString(preference, null);
        return extracted_preference;
    }

    public void removepreference(String preference){
        sharedPref = shr.getSharedPreferences("platoon", Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        editor.remove(preference);
        editor.apply();
    }

}
