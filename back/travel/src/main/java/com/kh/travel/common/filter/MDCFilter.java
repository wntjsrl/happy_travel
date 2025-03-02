package com.kh.travel.common.filter;

import com.kh.travel.common.errorCode.CommonErrorCode;
import com.kh.travel.common.exception.CommonException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Component
@WebFilter(filterName = "MDCFilter", urlPatterns = "/*")
public class MDCFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        StopWatch stopWatch = null;

        try {
            // 요청 처리 시간 측정 시작
            stopWatch = new StopWatch();
            stopWatch.start();

            // 랜덤 값으로 uuid 값 할당해서 로깅
            final UUID uuid = UUID.randomUUID();
            MDC.put("request_id", uuid.toString());

            filterChain.doFilter(request, response);
        } catch (Exception e) {
            log.error(CommonErrorCode.COMMON_ERROR_CODE_MDC_FILTER_ERROR.getMessage(), e);
            throw new CommonException(CommonErrorCode.COMMON_ERROR_CODE_MDC_FILTER_ERROR);
        } finally {
            // 요청 처리 시간 측정 종료 및 response 정보 로깅
            stopWatch.stop();
            log.info("response time = {} s", String.valueOf(stopWatch.getTotalTimeSeconds()));

            // MDC 비우기
            MDC.clear();
        }
    } // doFilterInternal
} // class
