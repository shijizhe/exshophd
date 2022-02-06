package com.jizhe.exshophd.util.returnresult;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReturnResult<T> {
    /**
     * 状态码
     */
    int code;
    /**
     * 描述信息
     */
    String message;
    /**
     * 接口返回的数据
     */
    T data;

    private ReturnResult() {
        this(200,"success");
    }
    private ReturnResult(int code,String message) {
        this.code=code;
        this.message=message;
    }

    private ReturnResult(ResultCodeEnum rescode) {
        this.code= rescode.getCode();
        this.message= rescode.getMessage();
    }

    private ReturnResult(int code,String message,T data) {
        this.code=code;
        this.message=message;
        this.data=data;
    }

    private ReturnResult (ResultCodeEnum rescode, T data) {
        this.code= rescode.getCode();
        this.message= rescode.getMessage();
        this.data=data;
    }

    /**
     *  成功
     */
    public static ReturnResult success() {
        return new ReturnResult();
    }

   /**
     附带data的返回
    */
    public static <T> ReturnResult success(T data) {
        return success(ResultCodeEnum.SUCCESS.getCode(),"success",data);
    }
    /**
     自定义code，message的返回
     */
    public static ReturnResult success(int code,String message) {
        return success(code,message,null);
    }

    public static ReturnResult success(ResultCodeEnum rescode) {
        return success(rescode.getCode(),rescode.getMessage(),null);
    }

    public static <T> ReturnResult success(ResultCodeEnum rescode,T data) {
        return success(rescode.getCode(),rescode.getMessage(),data);
    }

    public static <T> ReturnResult success(int code,String message,T data) {
        return new ReturnResult(code,message,data);
    }

    public static ReturnResult fail() {
        return fail(ResultCodeEnum.FAIL.getCode(),ResultCodeEnum.FAIL.getMessage());
    }

    public static ReturnResult fail(int code,String message) {
        return fail(code,message,null);
    }

    public static ReturnResult fail(ResultCodeEnum rescode) {
        return fail(rescode.getCode(),rescode.getMessage(),null);
    }

    public static <T> ReturnResult fail(T data) {
        return fail(data);
    }

    public static <T> ReturnResult fail(ResultCodeEnum rescode, T data) {
        return fail(rescode.getCode(),rescode.getMessage(),data);
    }

    public static <T> ReturnResult fail(int code,String message,T data) {
        return new ReturnResult(code,message,data);
    }
    
    
}
