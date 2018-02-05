package com.cloudmanager.apis.model.user;


public class UserCredentials {

    String userId;
    String accessToken;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public String toString() {
        return "UserCredentials{" +
                "userId='" + userId + '\'' +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }

}
