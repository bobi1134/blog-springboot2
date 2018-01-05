package cn.mrx.blog.server;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.io.Serializable;

/**
 * Author：Mr.X
 * Date：2017/10/23 17:34
 * Description：
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class ServerResponse<T> implements Serializable {

    private int status;
    private String msg;
    private T data;

    /** 私有构造器 #################################################### */
    private ServerResponse(int status) {
        this.status = status;
    }

    private ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }


    /** 静态方法 #################################################### */
    @JsonIgnore
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public static <T> ServerResponse<T> success() {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> success(String msg) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> ServerResponse<T> success(T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> ServerResponse<T> success(String msg, T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg, data);
    }


    public static <T> ServerResponse<T> error() {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }

    public static <T> ServerResponse<T> error(String errorMessage) {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), errorMessage);
    }

    public static <T> ServerResponse<T> error(int errorCode, String errorMessage) {
        return new ServerResponse<T>(errorCode, errorMessage);
    }
}
