package com.training.ykb.spring;


public class MyResponse<T> {

    private boolean       errorOccurred;
    private MyErrorObject errorObject;
    private T             response;

    public boolean isErrorOccurred() {
        return this.errorOccurred;
    }

    public void setErrorOccurred(final boolean errorOccurredParam) {
        this.errorOccurred = errorOccurredParam;
    }

    public MyErrorObject getErrorObject() {
        return this.errorObject;
    }

    public void setErrorObject(final MyErrorObject errorObjectParam) {
        this.errorObject = errorObjectParam;
    }

    public T getResponse() {
        return this.response;
    }

    public void setResponse(final T responseParam) {
        this.response = responseParam;
    }


}
