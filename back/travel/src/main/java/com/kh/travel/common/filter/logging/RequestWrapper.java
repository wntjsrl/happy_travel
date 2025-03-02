package com.kh.travel.common.filter.logging;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;

public class RequestWrapper extends HttpServletRequestWrapper {

    private byte[] cachedBody;

    // 생성자
    public RequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        InputStream requestInputStream = request.getInputStream();
        this.cachedBody = StreamUtils.copyToByteArray(requestInputStream);
    } // constructor

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new CachedBodyInputStream(this.cachedBody);
    } // getInputStream
} // class
