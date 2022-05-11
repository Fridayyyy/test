package com.example.file.common;

public class RestResult<T> {
    private Boolean success=true;
    private Integer code;
    private String message;
    private T data;

    public RestResult data(T param){
        this.setData(param);
        return this;
    }

    public RestResult message(String message){
        this.message=message;
        return this;
    }

    public RestResult code(Integer code){
        this.setCode(code);
        return this;
    }

    public static RestResult setResult(ResultCodeEnum result){
        RestResult r=new RestResult();
        r.setSuccess(result.getSuccess());
        r.setCode(result.getCode());
        r.setMessage(result.getMessage());
        return r;
    }

    public static RestResult success(){
        RestResult r=new RestResult();
        r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return r;
    }

    public static RestResult fail(){
        RestResult r=new RestResult();
        r.setSuccess(ResultCodeEnum.UNKNOWN_ERROR.getSuccess());
        r.setCode(ResultCodeEnum.UNKNOWN_ERROR.getCode());
        r.setMessage(ResultCodeEnum.UNKNOWN_ERROR.getMessage());
        return r;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
