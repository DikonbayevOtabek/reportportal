package com.reportportal.model;

import com.reportportal.util.StringUtils;

public class User {
    private static String username;
    private static String password;
    private static final String DEFAULT_USERNAME = "default";
    private static final String DEFAULT_PASSWORD = "1q2w3e";
    private static final int lengthOfGeneratedUsername = 6;
    private static final int lengthOfGeneratedPassword = 6;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static User createUserWithCorrectValues(){
        return new User(DEFAULT_USERNAME, DEFAULT_PASSWORD);
    }
    public static User createUserWithIncorrectUsername(){
        return new User(StringUtils.generateRandomUsername(lengthOfGeneratedUsername), DEFAULT_PASSWORD);
    }
    public static User createUserWithIncorrectPassword(){
        return new User(DEFAULT_USERNAME, StringUtils.generateRandomPassword(lengthOfGeneratedPassword));
    }
    public static User createUserWithEmptyUsername(){
        return new User("", StringUtils.generateRandomPassword(lengthOfGeneratedPassword));
    }
    public static User createUserWithEmptyPassword(){
        return new User(StringUtils.generateRandomUsername(lengthOfGeneratedUsername), "");
    }

}
