package com.cloudmanager.apis.model.user;


public class UserActivities {

    String userEmailIdAndUniquePrefix;
    String ActivityCode;
    String ActivityTime;
    String UserEmailId;

    public String getUserEmailIdAndUniquePrefix() {
        return userEmailIdAndUniquePrefix;
    }

    public void setUserEmailIdAndUniquePrefix(String userEmailIdAndUniquePrefix) {
        this.userEmailIdAndUniquePrefix = userEmailIdAndUniquePrefix;
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
