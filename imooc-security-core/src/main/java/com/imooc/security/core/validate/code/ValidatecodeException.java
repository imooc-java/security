package com.imooc.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

public class ValidatecodeException extends AuthenticationException {

    public ValidatecodeException(String msg) {
        super(msg);
    }

}
