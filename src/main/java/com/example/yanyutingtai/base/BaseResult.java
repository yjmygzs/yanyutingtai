package com.example.yanyutingtai.base;

import lombok.Data;

import java.io.Serializable;
@Data
public class BaseResult implements Serializable {
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FALL = 500;
    /**
     * 返回状态码
     */
    private int status;

    /**
     * 返回提示信息
     */
    private String message;

    /**
     *返回数据
     */
    private Object result;

    /**
     * 返回时间
     */
    private long timestamp = System.currentTimeMillis();

    private static BaseResult createResult(int status,String message,Object result){
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        baseResult.setResult(result);
        return baseResult;
    }
    /**
     * 默认返回成功方法
     */
    public static BaseResult success(){
        return BaseResult.createResult(STATUS_SUCCESS,"成功",null);
    }
    /**
     * 返回成功带消息
     */
    public static BaseResult success(String message){
        return BaseResult.createResult(STATUS_SUCCESS,message,null);
    }
    /**
     * 返回成功带数据
     */
    public static BaseResult success(Object result){
        return BaseResult.createResult(STATUS_SUCCESS,"成功",result);
    }
    /**
     * 返回成功带消息和数据
     */
    public static BaseResult success(String message,Object result){
        return  BaseResult.createResult(STATUS_SUCCESS,message,result);
    }
    /**
     * 默认返回失败
     */
    public static BaseResult fail(){
        return BaseResult.createResult(STATUS_FALL,"失败",null);
    }
    /**
     * 默认返回失败带消息
     */
    public static BaseResult fail(String message){
        return BaseResult.createResult(STATUS_FALL,message,null);
    }
    /**
     * 默认返回失败带消息和数据
     */
    public static BaseResult fail(String message,Object result){
        return BaseResult.createResult(STATUS_FALL,message,result);
    }
}
