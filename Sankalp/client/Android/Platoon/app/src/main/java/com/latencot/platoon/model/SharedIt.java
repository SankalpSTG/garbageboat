package com.latencot.platoon.model;

import android.content.Context;
import android.content.SharedPreferences;

import java.math.BigInteger;

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
    public void saveCompanyLoginData(CompanyLoginData data){
        deleteLoginData();
        sharedPref = shr.getSharedPreferences("platoon", Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        editor.putString(SharedItHelper.credential_id, data.serial_id.toString());
        editor.putString(SharedItHelper.verification_level, String.valueOf(data.verification_level));
        editor.putString(SharedItHelper.account_level, String.valueOf(data.account_level));
        editor.putString(SharedItHelper.company_login_data, "1");
        editor.apply();
    }
    public CompanyLoginData getCompanyLoginData(){
        if(extractpreference(SharedItHelper.company_login_data) != null){
            CompanyLoginData data;
            BigInteger serial_id = new BigInteger(extractpreference(SharedItHelper.credential_id));
            int verification_level = Integer.parseInt(extractpreference(SharedItHelper.verification_level));
            int account_level = Integer.parseInt(extractpreference(SharedItHelper.account_level));
            data = new CompanyLoginData(serial_id, verification_level, account_level);
            return data;
        }else{
            return null;
        }
    }
    public void deleteLoginData(){
        removepreference(SharedItHelper.company_login_data);
        removepreference(SharedItHelper.temporary_login_data);
    }
    public void saveTemporaryLoginData(CompanyLoginData data){
        deleteLoginData();
        sharedPref = shr.getSharedPreferences("platoon", Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        editor.putString(SharedItHelper.credential_id, data.serial_id.toString());
        editor.putString(SharedItHelper.verification_level, String.valueOf(data.verification_level));
        editor.putString(SharedItHelper.account_level, String.valueOf(data.account_level));
        editor.putString(SharedItHelper.temporary_login_data, "1");
        editor.apply();
    }
    public CompanyLoginData getTemporaryLoginData(){
        if(extractpreference(SharedItHelper.temporary_login_data) != null){
            CompanyLoginData data;
            BigInteger serial_id = new BigInteger(extractpreference(SharedItHelper.credential_id));
            int verification_level = Integer.parseInt(extractpreference(SharedItHelper.verification_level));
            int account_level = Integer.parseInt(extractpreference(SharedItHelper.account_level));
            data = new CompanyLoginData(serial_id, verification_level, account_level);
            return data;
        }else{
            return null;
        }
    }
}