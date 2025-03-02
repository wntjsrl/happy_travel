package com.kh.travel.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommonResp<T> {

    final HttpStatus status;
    final String code;
    final String message;
    final T object;

    // code에 맞는 responseEntity 생성하는 메서드
    public ResponseEntity<CommonResp> createResponseEntity(CommonResp commonResp){
        return ResponseEntity.status(commonResp.getStatus()).body(commonResp);
    } // createResponseEntity
} // class
