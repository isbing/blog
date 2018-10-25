package com.isbing.blog.util.json;

/**
 * Created by songbing on 2018/10/25 20:53
 */
public class JacksonSerializeException extends RuntimeException {
    public JacksonSerializeException() {
    }

    public JacksonSerializeException(String message) {
        super(message);
    }

    public JacksonSerializeException(String message, Throwable cause) {
        super(message, cause);
    }

    public JacksonSerializeException(Throwable cause) {
        super(cause);
    }

    public JacksonSerializeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
