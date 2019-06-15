package com.qhit.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date:2019/6/9
 * @Description:
 * @version:1.0
 */
@RestController
public class JsonController {
    public static Integer num = 1;

    @RequestMapping("/json")
    public List json() {
//        System.out.println(JsonController.num++);
//        Map<String,List> mp=new HashMap<String,List>();
//        List<String> list=new ArrayList<String>();
//        list.add("小三");
//        list.add("test2");
//        list.add("test3");
//        list.add("test4");
//        mp.put("001", list);
        System.out.println(num++);
        List<String> list = new ArrayList<String>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        
        return list;
    }
}
