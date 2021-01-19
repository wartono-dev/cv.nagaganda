//package com.wartono.my;
//
//import android.content.Context;
//import android.content.SharedPreferences;
//import android.preference.PreferenceManager;
//
//import java.util.HashMap;
//
//public class SessionManager<NAME, USERNAME> {
//
//
//    private final Context _context;
//    private Context context;
//    private SharedPreferences sharedPreferences;
//    private SharedPreferences.Editor editor;
//
//    private static final String IS_LOGGED_IN = "isLoggedIn";
//    private static final String USER_ID = "user_id";
//    private static final String USERNAME = "username";
//    private static final String NAME = "name";
//
//    public SessionManager (Context context){
//        this._context = context;
//        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        editor = sharedPreferences.edit();
//    }
//
//    public void createLoginSession (ModelLoginData user){
//        editor.putBoolean(IS_LOGGED_IN, true);
//        editor.putString(USER_ID, user.getUserId());
//        editor.putString(USERNAME, user.getUserName());
//        editor.putString(NAME, user.getName());
//        editor.commit();
//    }
//
//    public HashMap<String,String> getUserDetail(){
//        HashMap<String,String> user = new HashMap<>();
//        user.put(USER_ID, sharedPreferences.getString(USER_ID, null));
//        user.put(USERNAME, sharedPreferences.getString(USERNAME, null));
//        user.put(NAME, sharedPreferences.getString(NAME ,null));
//        return user;
//    }
//
//    public void LogoutSession(){
//        editor.clear();
//        editor.commit();
//    }
//
//    public boolean isLoggedId(){
//        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
//    }
//}
