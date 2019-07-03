package com.dreamaple.spbdemo.utils;

public class ReturnHelper<T> {

    /**
     * {@link #S_SUCCESSED 成功}
     */
    public static String S_SUCCESSED = "1";

    /**
     * {@link #S_NULL {@link #t}对象为空 失败}
     */
    public static String S_NULL = "400";

    /**
     * {@link #status 状态值}
     */
    private String status;

    /**
     * {@link #t 返回对象}
     */
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
