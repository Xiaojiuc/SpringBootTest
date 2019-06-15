package com.qhit.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Date:2019/6/2
 * @Description:
 * @version:1.0
 */
@Configuration
public class GlobalExceptions implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView(); //判断不同异常类型，做不同视图跳转
        if (ex instanceof ArithmeticException) {
            mv.setViewName("error1");
        }
        if (ex instanceof NullPointerException) {
            mv.setViewName("error2");
        }
        System.out.println("异常类加载成功");
        mv.addObject("error", ex.toString());
        return mv;
    }
}
