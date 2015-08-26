package com.emythmakers.ashik.bitmemployee.sharepreference;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ashik on 8/25/15.
 */
public class Preference {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    static final String NAME="employeeLogin";
    static final String NAME_KEY="name";
    static final String PASS_KEY="pass";



    public Preference(Context context) {
        this.sharedPreferences=context.getSharedPreferences(NAME, 0);
        this.editor=sharedPreferences.edit();
    }

    public void Save(String userName, String Password){
        editor.putString(NAME_KEY, userName);
        editor.putString(PASS_KEY, Password);
        editor.commit();
    }

    public String RetrieveUser(){
        String userName=sharedPreferences.getString(NAME_KEY, null);
        return userName;
    }

    public String RetrievePass(){
        String password=sharedPreferences.getString(PASS_KEY, null);
        return password;
    }

    public Boolean Check(String userName, String Password){
        String sUserName=RetrieveUser();
        String sPassword=RetrievePass();
        if(sUserName!=null && sPassword!=null && sUserName.length()>0 && sPassword.length()>0 && sUserName.equalsIgnoreCase(userName) && sPassword.equals(Password)){
            return true;
        }else{
            return false;
        }
    }

}
