package com.example.demo.global;

//统一返回结果
public class RtnResult {

    private Integer code; //状态
    private Object data;  //返回对象
    private String msg;  //消息

    public RtnResult setRtnResult(RtnResultCode result) {
        this.code = result.getCode();
        this.msg = result.getMessage();
        return this;
    }

    public RtnResult setData(Object data) {
        this.data = data;
        return this;
    }

    //默认回调
    public static RtnResult deaultObject() {
        return new RtnResult();
    }


    //成功
    public static RtnResult success() {
        return deaultObject().setRtnResult(RtnResultCode.SUCCESS);
    }
    //成功带参
    public static RtnResult success(Object data) {
        return RtnResult.success().setData(data);
    }

    //失败
    public static RtnResult fail() {
        return deaultObject().setRtnResult(RtnResultCode.FAIL);
    }
    //失败带参
    public static RtnResult fail(Object object) {
        return RtnResult.fail().setData(object);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RtnResult(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public RtnResult() {
    }

    public RtnResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RtnResult(Integer code) {
        this.code = code;
    }
}
