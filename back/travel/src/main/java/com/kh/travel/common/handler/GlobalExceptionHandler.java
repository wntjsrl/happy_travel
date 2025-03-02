package com.kh.travel.common.handler;

import com.kh.travel.common.errorCode.CommonErrorCode;
import com.kh.travel.common.exception.CommonException;
import com.kh.travel.common.response.CommonResp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    // request 정보 유효성 검사 예외 처리
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<CommonResp> handleUserSignUpValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
        FieldError firstFieldError = fieldErrorList.get(0);
        String errorCode = firstFieldError.getDefaultMessage();

        // CommonErrorCode의 code와 유효하지 않은 필드의 message와 매핑하는 메서드 호출
        CommonErrorCode error = CommonErrorCode.findErrorCode(errorCode);

        CommonResp commonResp = CommonResp.builder()
                .status(error.getStatus())
                .code(error.getCode())
                .message(error.getMessage())
                .build();

        return commonResp.createResponseEntity(commonResp);
    } // handleUserSignUpValidationExceptions

    // 전반적인 예외 처리
    @ExceptionHandler(value = {CommonException.class})
    public ResponseEntity<CommonResp> handleCommonException(CommonException ex){
        // CommonErrorCode의 code와 발생한 예외의 code 매핑하는 메서드 호출
        CommonErrorCode error = CommonErrorCode.findErrorCode(ex.getMessage());

        CommonResp commonResp = CommonResp.builder()
                .status(error.getStatus())
                .code(error.getCode())
                .message(error.getMessage())
                .build();

        return commonResp.createResponseEntity(commonResp);
    } // handleCommonException

    // 예기치 못한 예외 처리
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<CommonResp> handleUnexpectedException(){
        // CommonErrorCode의 code와 발생한 예외의 code 매핑하는 메서드 호출
        CommonResp commonResp = CommonResp.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .code("5000")
                .message("식별되지 않은 예외")
                .build();

        return commonResp.createResponseEntity(commonResp);
    } // handleUnexpectedException
} // class
