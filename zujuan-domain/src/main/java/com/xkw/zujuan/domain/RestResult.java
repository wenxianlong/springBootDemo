package com.xkw.zujuan.domain;

import lombok.Data;

/**
 * restfull 接口统一返回格式
 *
 * @author wenxianlong
 * @date 2019-08-16
 */
@Data
public class RestResult<T> {

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回分页信息
     */
    private Page page;

    /**
     * 返回内容
     */
    private T content;

    /**
     * 返回结果
     */
    private boolean success;

    /**
     * 错误信息
     *
     * @param code int
     * @param msg  String
     * @return T
     */
    public static <T> RestResult<T> createSimpleErrorResult(int code, String msg) {
        RestResult<T> rr = new RestResult<>();
        rr.setCode(code);
        rr.setSuccess(true);
        rr.setMsg(msg);
        rr.setContent(null);
        return rr;
    }

    /**
     * 创建一个简单的正确结果
     *
     * @param code   int
     * @param msg    String
     * @param entity T
     * @return T
     */
    public static <T> RestResult<T> createSimpleSuccessResult(int code, String msg, T entity) {
        RestResult<T> rr = new RestResult<>();
        rr.setCode(code);
        rr.setSuccess(false);
        rr.setMsg(msg);
        rr.setContent(entity);
        return rr;
    }


}