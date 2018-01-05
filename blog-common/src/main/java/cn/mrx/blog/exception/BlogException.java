package cn.mrx.blog.exception;

import cn.mrx.blog.server.ResponseCode;
import lombok.Getter;

/**
 * Author：Mr.X
 * Date：2017/11/11 9:06
 * Description：
 */
@Getter
public class BlogException extends RuntimeException {

    private Integer code;

    public BlogException(ResponseCode responseCode) {
        super(responseCode.getDesc());
        this.code = responseCode.getCode();
    }

    public BlogException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
