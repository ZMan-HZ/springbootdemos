package com.zzm.applications.exception;

/**
 * <b>Description</b>  UserNonExistException
 *
 * @Author Zhenzhen
 * @Since 2020-06-25 周四 09:16
 * @Info UserNonExistException
 */


public class UserNonExistException extends RuntimeException {

    public UserNonExistException() {
        super("User Is Not Exist!");
    }

    public UserNonExistException(String message) {
        super(message);
    }

    public UserNonExistException(String message, Throwable ex) {
        super(message, ex);
    }
}
