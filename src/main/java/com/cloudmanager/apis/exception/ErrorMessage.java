package com.cloudmanager.apis.exception;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ErrorMessage {

    private String ErrorMessage;
    private int ErrorCode;
    private String documentation;

    public ErrorMessage() {
    }

    public ErrorMessage(String errorMessage, int errorCode, String documentation) {
        super();
        this.ErrorMessage = errorMessage;
        this.ErrorCode = errorCode;
        this.documentation = documentation;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public int getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(int errorCode) {
        ErrorCode = errorCode;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    @Override
    public String toString() {
        return "{" +
                "\"ErrorMessage\"" + ":"+  "\"" + ErrorMessage +  "\"" +',' +
                "\"ErrorCode\"" + ":"+  "\"" + ErrorCode + "\"" + ',' +
                "\"documentation\"" + ":"+  "\"" + documentation + "\"" +
                "}";
    }
}