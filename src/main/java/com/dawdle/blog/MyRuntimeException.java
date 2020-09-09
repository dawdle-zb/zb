package com.dawdle.blog;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author zhoubin
 * @create 2020/8/2  10:22
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyRuntimeException extends RuntimeException {
    static final long serialVersionUID = -70348971907669L;
    public MyRuntimeException() {
        super();
    }

    public MyRuntimeException(String message) {
        super(message);
    }

    public MyRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
