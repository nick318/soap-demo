package com.nick318.soap.demo;

import java.util.Objects;

public class ErrorHandler {

    public static void requireNotNull(Object object) {
        requireNotNull(object, "Null was set to not null field");
    }

    public static void requireNotNull(Object object, String message) {
        if (Objects.isNull(object)) {
            throw new IllegalArgumentException(message);
        }
    }
}
