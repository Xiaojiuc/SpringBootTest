package com.qhit.controller;

import com.qhit.pojo.Users;
import com.qhit.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date:2019/5/31
 * @Description:
 * @version:1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("/test")
    public String test(Model model) {
        int [] s=new  int[10];
        int length = s.length;
        List<Users> list = new ArrayList<Users>();
        //需要一个 Model 对象
        model.addAttribute("list", list); //跳转视图 return "userList";
        return "thymeleaftest";
    }

    @RequestMapping("/list")
    public String list() {
        List<Users> users = usersService.selectUsers();
        System.out.println("?");
        return "thymeleaftest";
    }

    /**
     * 完成用户添加
     *
     * @Valid 开启对 Users 对象的数据校验
     * BindingResult:封装了校验的结果
     */
    @RequestMapping("/add")
    public String add(@Valid Users user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add";
        }
        System.out.println("可以添加");
        return "thymeleaftest";
    }

    @RequestMapping("/sel")
    @ResponseBody
    public List<Users> selectUsersByIdName(Users users) {
        List<Users> users1 = usersService.selectUsersByIdName(users);
        return users1;
    }
}
