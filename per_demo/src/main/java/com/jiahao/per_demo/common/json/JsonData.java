package com.jiahao.per_demo.common.json;

import java.util.List;

import lombok.Data;

@Data
public class JsonData<T> {

    private final static Integer CODE_SUCCESS = 200;
    private final static String msgSuccess = "success";

    public final static Integer CODE_FAILURE = -1;

    private Integer code;
    private String msg;
    private T data;
    private Long timestamp;


    public JsonData(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        timestamp = System.currentTimeMillis();
    }

    public JsonData(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        timestamp = System.currentTimeMillis();
    }

    public static <T> JsonData<T> ok(T data) {
        return new JsonData<>(CODE_SUCCESS, msgSuccess, data);
    }


    public static <T> JsonData ok(List<T> data,boolean isPage) {
        if(isPage){
           //TODO
        }
        return new JsonData<>(CODE_SUCCESS, msgSuccess, data);
    }

    public static JsonData ok() {
        return new JsonData(CODE_SUCCESS, msgSuccess);
    }

    public static JsonData error(Integer errorCode, String msg) {
        return new JsonData(errorCode, msg);
    }

    public JsonData() {
    }
}
