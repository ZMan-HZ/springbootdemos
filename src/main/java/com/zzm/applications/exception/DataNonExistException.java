package com.zzm.applications.exception;

/**
 * <b>Description</b>  DataNonExistException
 *
 * @Author Zhenzhen
 * @Since 2020-06-26 周五 22:26
 * @Info DataNonExistException
 */


public class DataNonExistException extends RuntimeException {


    public DataNonExistException(){
        super("Can not find any data!");
    }

    public DataNonExistException(String message){
        super(message);
    }

    public DataNonExistException(String message,Throwable ex){
        super(message,ex);
    }

}
