package com.example.wxqserver_sb.exception;

import com.example.wxqserver_sb.enums.ResultEnum;

public class PoiException extends RuntimeException{
    private PoiException(String msg) {
        super(msg);
    }

    public static PoiException NotFound() {
        return new PoiException(ResultEnum.ERROR_NOT_FOUND.getMsg());
    }

    public static PoiException OperateFail() {
        return new PoiException(ResultEnum.ERROR_OPERATION.getMsg());
    }

    public static PoiException Unknown() {
        return new PoiException(ResultEnum.ERROR_UNKNOWN.getMsg());
    }
}
