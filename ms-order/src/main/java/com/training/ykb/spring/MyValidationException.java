package com.training.ykb.spring;


public class MyValidationException extends Exception {

    private static final long serialVersionUID = 5733962118563484912L;
    private String            message;
    private int               status;
    private String            timestamp;
    private String            error;
    private String            path;

    @Override
    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String messageParam) {
        this.message = messageParam;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(final int statusParam) {
        this.status = statusParam;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(final String timestampParam) {
        this.timestamp = timestampParam;
    }

    public String getError() {
        return this.error;
    }

    public void setError(final String errorParam) {
        this.error = errorParam;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(final String pathParam) {
        this.path = pathParam;
    }


}
