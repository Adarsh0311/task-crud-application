package com.example.crudapp.util;

public class StringUtils {
    private StringUtils(){}

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
