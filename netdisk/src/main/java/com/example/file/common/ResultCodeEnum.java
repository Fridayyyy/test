package com.example.file.common;

public enum ResultCodeEnum {
    SUCCESS(true,20000,"成功"),
    UNKNOWN_ERROR(false,20001,"未知错误"),
    PARAM_ERROR(false,20002,"参数错误"),
    NULL_POINTER(false,20003,"空指针错误"),
    INDEX_OUT_OF_BOUND(false,20004,"下标越界"),
    ;

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

    private Boolean success;

    private Integer code;

    private String message;

    ResultCodeEnum(boolean success,Integer code,String message){
        this.code=code;
        this.message=message;
        this.success=success;
    }
}
