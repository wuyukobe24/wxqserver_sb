package com.example.wxqserver_sb.exception;

import com.example.wxqserver_sb.enums.ResultEnum;
import com.example.wxqserver_sb.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class PoiExceptionHandler {

    @ExceptionHandler(PoiException.class)
    public Result poiExceptionHandler(Exception e) {
        log.info("poiExceptionHandler: ",e);
        if (e.getMessage().endsWith(ResultEnum.ERROR_NOT_FOUND.getMsg())) {
            return Result.fail(ResultEnum.ERROR_NOT_FOUND);
        } else if (e.getMessage().endsWith(ResultEnum.ERROR_OPERATION.getMsg())) {
            return Result.fail(ResultEnum.ERROR_OPERATION);
        }
        return Result.fail();
    }

    @ExceptionHandler(Exception.class)
    public Result serverErrorHandler(Exception e) {
        return Result.fail();
    }
}
