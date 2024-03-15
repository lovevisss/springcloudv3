package com.atguigu.cloud.exp;

import com.atguigu.cloud.resp.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> handlerException(Exception e) {
        log.error("GlobalExceptionHandler.handlerException", e);
        return ResultData.fail("500", e.getMessage());
    }
}
