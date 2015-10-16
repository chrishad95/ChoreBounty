package com.taylorbest.chorereward.models;

/**
 * Created by chadley on 10/16/2015.
 */
public class Security {
    private static String securityKey;
    private static String authKey;

    public static String getSecurityKey() {
        return securityKey;
    }

    public static void setSecurityKey(String securityKey) {
        Security.securityKey = securityKey;
    }

    public static String getAuthKey() {
        return authKey;
    }

    public static void setAuthKey(String authKey) {
        Security.authKey = authKey;
    }
}
