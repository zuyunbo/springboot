package com.bobo.springboot.exception;

/**
 * 自己定义的异常 需实现RuntimeException 在Impl中会用到
 */
public class IllegalParameterException extends RuntimeException {

    public IllegalParameterException(String exception) {
        super(exception);
    }
}
