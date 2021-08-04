package com.botscrew.university.exception;

public class NoSuchDepartmentException extends RuntimeException {

    public NoSuchDepartmentException() {
        super();
    }

    public NoSuchDepartmentException(String s) {
        super(s);
    }

    public NoSuchDepartmentException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NoSuchDepartmentException(Throwable throwable) {
        super(throwable);
    }

    protected NoSuchDepartmentException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
