package com.liushao.article.exception;

import com.liushao.entity.Result;
import com.liushao.entity.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 全局异常处理类(通知类)
 * // @ControllerAdvice
 * 组合注解，相当于@ControllerAdvice+@ResponseBody
 * @author SZ-UserBDG7
 */
@RestControllerAdvice
public class BaseExceptionHandler {

    /**
     * //增强的方法：异常通知处理
     * //当有异常的情况下自动该方法处理异常的注解
     * //如果为空，则自动抓取参数中的异常列表
     * //如果不为空，则抓取指定的异常
     * //@ExceptionHandler(Exception.class)
     */
    @ExceptionHandler
    public Result error(Exception e){
        //控制台打印
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR,e.getMessage());
    }
}
