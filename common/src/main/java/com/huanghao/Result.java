package com.huanghao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huanghao.enums.ErrorEnum;

/**
 * 
 * @Title: Result.java
 * @Description: 自定义响应数据结构
 * 				本类可提供给 H5/ios/安卓/公众号/小程序 使用
 * 				前端接受此类数据（json object)后，可自行根据业务去实现相关功能
 * 
 * 				200：表示成功
 * 				500：表示错误，错误信息在msg字段中
 * 				501：bean验证错误，不管多少个错误都以map形式返回
 * 				502：拦截器拦截到用户token出错
 * 				555：异常抛出信息
 * 				556: 用户qq校验异常
 * @author HuangHao
 */
public class Result {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    private Integer code;

    // 响应消息
    private String message;

    // 响应中的数据
    private Object data;
    
    private Boolean ok;	// 不使用

    public static Result build(Integer code, String message, Object data) {
        return new Result(code, message, data);
    }

    public static Result build(Integer code, String message, Object data, Boolean ok) {
        return new Result(code, message, data, ok);
    }
    
    public static Result ok(Object data) {
        return new Result(data);
    }

    public static Result ok() {
        return new Result(null);
    }
    
    public static Result errorMsg(String message) {
        return new Result(500, message, null);
    }

    public static Result error(ErrorEnum errorEnum) {
        return new Result(errorEnum.getCode(), errorEnum.getMessage(), null);
    }
    public static Result error(ErrorEnum errorEnum, String message) {
        return new Result(errorEnum.getCode(), message, null);
    }
    
    public static Result errorMap(Object data) {
        return new Result(501, "error", data);
    }
    
    public static Result errorTokenMsg(String message) {
        return new Result(502, message, null);
    }
    
    public static Result errorException(String message) {
        return new Result(555, message, null);
    }
    
    public static Result errorUserQQ(String message) {
        return new Result(556, message, null);
    }

    public Result() {

    }

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.ok = code == 200;
    }
    
    public Result(Integer code, String message, Object data, Boolean ok) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.ok = ok;
    }

    public Result(Object data) {
        this.code = 200;
        this.message = "OK";
        this.data = data;
        this.ok = Boolean.TRUE;
    }

    public Boolean isOK() {
        return this.code == 200;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

	public Boolean getOk() {
		return ok;
	}

	public void setOk(Boolean ok) {
		this.ok = ok;
	}

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", ok='" + ok + '\'' +
                '}';
    }
}
