package com.taylorbest.chorereward.models;

/**
 * Created by chadley on 10/16/2015.
 */
public class Security {
    private static String securityKey;
    private static String userKey;

    public static String getSecurityKey() {
        return securityKey;
    }

    public static void setSecurityKey(String securityKey) {
        Security.securityKey = securityKey;
    }

    public static String getUserKey() {
        return userKey;
    }

    public static void setUserKey(String userKey) {
        Security.userKey = userKey;
    }
}
