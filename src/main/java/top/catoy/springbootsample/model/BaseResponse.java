package top.catoy.springbootsample.model;

import org.springframework.http.HttpStatus;

public class BaseResponse<T> {

    private int code;

    private T data;

    private String message;

    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static <T> BaseResponse<T> ok(String message, T data) {
        return new BaseResponse<>(HttpStatus.OK.value(), data, message);
    }

    public static <T> BaseResponse<T> ok(String message) {
        return ok(message, null);
    }

    public static <T> BaseResponse<T> ok(T data) {
        return new BaseResponse<>(HttpStatus.OK.value(), data, HttpStatus.OK.getReasonPhrase());
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
