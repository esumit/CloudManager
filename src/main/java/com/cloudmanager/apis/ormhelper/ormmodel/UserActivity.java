package com.cloudmanager.apis.ormhelper.ormmodel;

public class UserActivity {

    public static final String SIGN_UP_RETRY = "SIGN_UP_RETRY";

    String UserEmailIdAndUniquePrefix;
    String ActivityCode;
    String ActivityTime;
    String UserEmailId;

    public String getUserEmailIdAndUniquePrefix() {
        return UserEmailIdAndUniquePrefix;
    }

    public void setUserEmailIdAndUniquePrefix(String userEmailIdAndUniquePrefix) {
        UserEmailIdAndUniquePrefix = userEmailIdAndUniquePrefix;
    }

    public String getActivityCode() {
        return ActivityCode;
    }

    public void setActivityCode(String activityCode) {
        ActivityCode = activityCode;
    }

    public String getActivityTime() {
        return ActivityTime;
    }

    public void setActivityTime(String activityTime) {
        ActivityTime = activityTime;
    }

    public String getUserEmailId() {
        return UserEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        UserEmailId = userEmailId;
    }

}
