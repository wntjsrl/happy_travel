package com.kh.travel.common.exception;

import com.kh.travel.common.errorCode.CommonErrorCode;

public class CommonException extends RuntimeException{

    public CommonException(CommonErrorCode errorCode) {
        super(errorCode.getCode());
    } // constructor
} // class
