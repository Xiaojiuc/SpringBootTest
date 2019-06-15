package com.qhit.controller;

import com.qhit.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Date:2019/6/1
 * @Description:
 * @version:1.0
 */
@Controller
public class TestController {
    /**
     * 解决异常的方式。可以在跳转页面的方法中注入一个 Uesrs 对象。
     * 注意：由于 springmvc 会将该对象放入到 Model 中传递。key 的名称会使用 该对象的驼峰式的命名规则来作为 key。
     * 参数的变量名需要与对象的名称相同。将首字母小写。
     * @param users
     * @return
     * 如果想为传递的对象更改名称，可以使用@ModelAttribute("aa")这表示当 前传递的对象的 key 为 aa。
     */
//    @ResponseBody
    @RequestMapping("/add")
    public String add(Users users){
        System.out.println("testadd");
        return "add";
    }

}
