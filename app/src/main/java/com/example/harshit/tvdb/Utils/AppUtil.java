package com.example.harshit.tvdb.Utils;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.harshit.tvdb.Activities.NonInternetorErrorActivity;

/**
 * Created by Harshit on 10/24/2017.
 */

public class AppUtil {


    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity =(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivity == null) {
            return false;
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static void openNonInternetActivity(Context context,String tag)
    {
        Intent noInternetIntent=new Intent(context, NonInternetorErrorActivity.class);
        noInternetIntent.putExtra("TAG",tag);
        context.startActivity(noInternetIntent);

    }



}
