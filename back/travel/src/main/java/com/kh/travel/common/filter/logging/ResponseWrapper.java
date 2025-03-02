package com.kh.travel.common.filter.logging;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.util.ContentCachingResponseWrapper;

public class ResponseWrapper extends ContentCachingResponseWrapper {
    
    // 생성자
    public ResponseWrapper(HttpServletResponse response) {
        super(response);
    } // constructor
} // class
