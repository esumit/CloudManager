package com.cloudmanager.apis.model.user;

import java.nio.ByteBuffer;


public class MachinesUsers {

    String username;

    String firstname;

    String lastName;

    String tfaEnabled;

    String mfaScratchCodes;

    String mfaSecretKey;

    String mfaUserName;

    String mfaValidationCode;

    ByteBuffer password;

    ByteBuffer passwordSalt;

    String emailVerified;

    String mobileNoVerified;

    String emailId;

    String tcAccepted;

    String signUpDateTime;

    String status;

    String mobileNo;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getTfaEnabled() {
        return tfaEnabled;
    }

    public void setTfaEnabled(String tfaEnabled) {
        this.tfaEnabled = tfaEnabled;
    }

    public String getMfaScratchCodes() {
        return mfaScratchCodes;
    }

    public void setMfaScratchCodes(String mfaScratchCodes) {
        this.mfaScratchCodes = mfaScratchCodes;
    }

    public String getMfaSecretKey() {
        return mfaSecretKey;
    }

    public void setMfaSecretKey(String mfaSecretKey) {
        this.mfaSecretKey = mfaSecretKey;
    }

    public String getMfaUserName() {
        return mfaUserName;
    }

    public void setMfaUserName(String mfaUserName) {
        this.mfaUserName = mfaUserName;
    }

    public String getMfaValidationCode() {
        return mfaValidationCode;
    }

    public void setMfaValidationCode(String mfaValidationCode) {
        this.mfaValidationCode = mfaValidationCode;
    }

    public ByteBuffer getPassword() {
        return password;
    }

    public void setPassword(ByteBuffer password) {
        this.password = password;
    }

    public ByteBuffer getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(ByteBuffer passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(String emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getMobileNoVerified() {
        return mobileNoVerified;
    }

    public void setMobileNoVerified(String mobileNoVerified) {
        this.mobileNoVerified = mobileNoVerified;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getTcAccepted() {
        return tcAccepted;
    }

    public void setTcAccepted(String tcAccepted) {
        this.tcAccepted = tcAccepted;
    }

    public String getSignUpDateTime() {
        return signUpDateTime;
    }

    public void setSignUpDateTime(String signUpDateTime) {
        this.signUpDateTime = signUpDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }




}
