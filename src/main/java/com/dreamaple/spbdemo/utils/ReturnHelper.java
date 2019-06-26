package com.dreamaple.spbdemo.utils;

public class ReturnHelper<T> {
    private String status;
    private T t;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
