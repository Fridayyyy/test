package com.example.file.advice;


import com.example.file.common.RestResult;
import com.example.file.common.ResultCodeEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandlerAdvice {
    //通用异常处理方法
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public RestResult error(Exception e){
        e.printStackTrace();
        return RestResult.fail();
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public RestResult error(NullPointerException e){
        e.printStackTrace();
        return RestResult.setResult(ResultCodeEnum.NULL_POINTER);
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseBody
    public RestResult error(IndexOutOfBoundsException e){
        e.printStackTrace();
        return RestResult.setResult(ResultCodeEnum.INDEX_OUT_OF_BOUND);
    }
}
