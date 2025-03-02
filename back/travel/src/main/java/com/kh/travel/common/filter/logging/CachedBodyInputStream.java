package com.kh.travel.common.filter.logging;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CachedBodyInputStream extends ServletInputStream {

    private InputStream cachedBodyInputStream;

    // 생성자
    public CachedBodyInputStream(byte[] cachedBody){
        this.cachedBodyInputStream = new ByteArrayInputStream(cachedBody);
    } // constructor

    @Override
    public void setReadListener(ReadListener readListener) {
        throw new UnsupportedOperationException();
    } // setReadListener

    @Override
    public boolean isReady() {
        return true;
    } // isReady

    @Override
    public int read() throws IOException {
        return cachedBodyInputStream.read();
    } // read

    @Override
    public boolean isFinished() {
        try {
            return cachedBodyInputStream.available() == 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    } // isFinished
} // class
