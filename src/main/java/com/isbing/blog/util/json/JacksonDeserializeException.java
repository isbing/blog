package com.isbing.blog.util.json;

/**
 * Created by songbing on 2018/10/25 20:53
 */
public class JacksonDeserializeException extends RuntimeException {
    public JacksonDeserializeException() {
    }

    public JacksonDeserializeException(String message) {
        super(message);
    }

    public JacksonDeserializeException(String message, Throwable cause) {
        super(message, cause);
    }

    public JacksonDeserializeException(Throwable cause) {
        super(cause);
    }

    public JacksonDeserializeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
