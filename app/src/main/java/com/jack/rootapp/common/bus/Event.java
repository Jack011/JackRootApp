package com.jack.rootapp.common.bus;

/**
 * Created by Administrator on 2017-07-12.
 */

public class Event<T> {
    private int code;//事件码
    private T data;//<T>指定事件通信过程中的数据类型

    public Event(int code) {
        this.code = code;
    }

    public Event(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
