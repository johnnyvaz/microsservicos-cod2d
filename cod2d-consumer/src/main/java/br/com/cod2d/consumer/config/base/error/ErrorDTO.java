package br.com.cod2d.consumer.config.base.error;

import java.io.Serializable;

public class ErrorDTO implements Serializable {

    private static final long serialVersionUID = -5300005787375927621L;
    private String developerMessage;
    private String userMessage;
    private String moreInfo;
    private long errorCode = 10000L;

    public ErrorDTO() {

    }

    public ErrorDTO(final String developerMessage, final String userMessage) {
        this.developerMessage = developerMessage;
        this.userMessage = userMessage;
    }

    public ErrorDTO(final String developerMessage, final String userMessage, final Long errorCode) {
        this.developerMessage = developerMessage;
        this.userMessage = userMessage;
        this.errorCode = errorCode;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(final String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(final String userMessage) {
        this.userMessage = userMessage;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(final String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(final long errorCode) {
        this.errorCode = errorCode;
    }

}
