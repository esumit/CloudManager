package com.cloudmanager.apis.ormhelper.ormmodel;

public class UsersToken {

    String authorizeTokenUser;
    String tokenCreatedAt;
    String tokenStatus;
    String tokenValidFrom;
    String tokenValidTo;
    String tokenValue;
    String dateAndTime;

    public String getAuthorizeTokenUser() {
        return authorizeTokenUser;
    }

    public void setAuthorizeTokenUser(String authorizeTokenUser) {
        this.authorizeTokenUser = authorizeTokenUser;
    }

    public String getTokenCreatedAt() {
        return tokenCreatedAt;
    }

    public void setTokenCreatedAt(String tokenCreatedAt) {
        this.tokenCreatedAt = tokenCreatedAt;
    }

    public String getTokenStatus() {
        return tokenStatus;
    }

    public void setTokenStatus(String tokenStatus) {
        this.tokenStatus = tokenStatus;
    }

    public String getTokenValidFrom() {
        return tokenValidFrom;
    }

    public void setTokenValidFrom(String tokenValidFrom) {
        this.tokenValidFrom = tokenValidFrom;
    }

    public String getTokenValidTo() {
        return tokenValidTo;
    }

    public void setTokenValidTo(String tokenValidTo) {
        this.tokenValidTo = tokenValidTo;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

}
