package com.stg.bonker.customutilities;

import android.content.Context;
import android.content.SharedPreferences;

public class sharedit {
    Context shr;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    public sharedit(Context shr){
        this.shr = shr;

    }
    public void addpreference(String preference, String key){
        sharedPref = shr.getSharedPreferences("bonker", Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        editor.putString(key, preference);
        editor.apply();
    }

    public String extractpreference(String preference){
        sharedPref = shr.getSharedPreferences("bonker", Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        String extracted_preference = sharedPref.getString(preference, null);
        return extracted_preference;
    }

    public void removepreference(String preference){
        sharedPref = shr.getSharedPreferences("bonker", Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        editor.remove(preference);
        editor.apply();
    }

}
