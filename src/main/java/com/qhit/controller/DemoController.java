package com.qhit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SpringBoot 处理异常方式一：自定义错误页面 * *
 */
@Controller
public class DemoController {
    @RequestMapping("/null")
    public String showInfo() {
        String str = null;
        str.length();
        return "index";
    }

    @RequestMapping("/arit")
    public String showInfo2() {
        int a = 10 / 0;
        return "index";
    }
}