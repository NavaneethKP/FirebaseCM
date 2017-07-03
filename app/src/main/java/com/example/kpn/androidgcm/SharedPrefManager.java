package com.example.kpn.androidgcm;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by kpn on 3/7/17.
 */

public class SharedPrefManager {

    private static final String SHARED_PREF_KEY="fcmkey";
    private static final String TOKEN_KEY="token";

    private static Context mCtx;
    private static SharedPrefManager mInstance;

    private SharedPrefManager(Context context){
        mCtx=context;
    }

    public static synchronized SharedPrefManager getInstance(Context context){
        if(mInstance==null)
            return new SharedPrefManager(context);
        return mInstance;
    }

    public boolean storeToken(String token){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_KEY,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TOKEN_KEY,token);
        editor.apply();
        return true;

    }

    public String getToken(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_KEY,Context.MODE_PRIVATE);
        return sharedPreferences.getString(TOKEN_KEY,null);
    }


}
