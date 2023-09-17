package com.example.wxqserver_sb.vo;

import com.example.wxqserver_sb.enums.ResultEnum;

public class Result<T> {
    public int code;
    public String msg;
    public T data;

    // 默认成功回调 静态函数
    public static <T> Result success() {
        return new Result(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), null);
    }

    // 成功数据回调 静态函数
    public static <T> Result success(T data) {
        return new Result(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), data);
    }

    // 失败数据回调 静态函数
    public static <T> Result fail() {
        return new Result(ResultEnum.ERROR_UNKNOWN.getCode(), ResultEnum.ERROR_UNKNOWN.getMsg(), null);
    }

    // 失败数据回调 静态函数
    public static <T> Result fail(ResultEnum rEnum) {
        return new Result(rEnum.getCode(), rEnum.getMsg(), null);
    }

    // 构造函数
    private Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
