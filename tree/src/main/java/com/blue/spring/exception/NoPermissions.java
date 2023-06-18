package com.blue.spring.exception;

/**
 * @createDate 2018/12/7
 **/
public class NoPermissions extends Exception{

    public NoPermissions(String msg){
        super(msg);
    }
}
