package com.reportportal.util;

import java.util.Random;

public class StringUtils {
    private static final String ALFA_NUMERICAL_ALL_LOWER_CASE = "0123456789abcdefghijklmnopqrstuvwxyz";
    private static final Random random = new Random();


    private static String getRandomString(int stringLength){
        StringBuilder stringBuilder = new StringBuilder(stringLength);
        for (int i = 0; i < stringLength; ++i){
            stringBuilder.append(ALFA_NUMERICAL_ALL_LOWER_CASE.charAt(random.nextInt(ALFA_NUMERICAL_ALL_LOWER_CASE.length())));
        }
        return stringBuilder.toString();
    }

    public static String generateRandomUsername(int postfixLength){
        return "User".concat(getRandomString(postfixLength));
    }
    public static String generateRandomPassword(int postfixLength){
        return "Password".concat(getRandomString(postfixLength));
    }
    public static String generateRandomNameOfDashboard(int postfixLength){
        return "TestName".concat(getRandomString(postfixLength));
    }
    public static String generateRandomDescriptionOfDashboard(int postfixLength){
        return "TestDescription".concat(getRandomString(postfixLength));
    }
}
