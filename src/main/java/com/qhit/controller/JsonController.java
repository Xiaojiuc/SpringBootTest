package com.qhit.controller;

import com.alibaba.fastjson.JSONObject;
import com.qhit.common.util.CommonsCsvUtil;
import com.qhit.common.util.CommonsPDFUtil;
import com.qhit.common.util.LogUtil;
import com.qhit.pojo.Users;
import com.qhit.service.UsersService;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Date:2019/6/9
 * @Description:
 * @version:1.0
 */
@RestController
public class JsonController {
    public static Integer num = 1;

    @Autowired
    UsersService usersService;

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


    @RequestMapping("/imgs")
    public String img(HttpServletRequest request, MultipartFile file, HttpServletResponse response, Object files) {
//        Object file = request.getParameter("file");
        System.out.println(file);
        String s = JSONObject.toJSON(file).toString();
            System.out.println(s);
        return s;
    }

    @RequestMapping("/csv")
    public void csv(HttpServletResponse response){
        System.out.println("testSS");
        List<String> headerList = new ArrayList<String>(Arrays.asList("时间", "问题", "意图", "意图Data"));
        List<List<String>> dataList = new ArrayList<List<String>>();

        for (int i = 0; i < 10; i++) {
            List<String> rowList = new ArrayList<String>();
            rowList.add("张  三_"+i);
            rowList.add("2 ,./  0 _"+i);
            rowList.add("Gold_getPrice _"+i);
            rowList.add("mmons-csv,  由两大核心对象组成 ,CSVParser.（解析）,CSVPrinter（写csv）,");
            dataList.add(rowList);
        }

        String[] headers = new String[headerList.size()];
        headerList.toArray(headers);
        try {
            CommonsCsvUtil.exportByList(headers, dataList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("=======结束==========");
    }

    @RequestMapping("/pdf")
    public void pdf(HttpServletRequest request,HttpServletResponse response){
        try {
            CommonsPDFUtil.ExportPDF(request,response);
            int a=0/0;
        } catch (Exception e) {
            LogUtil.printLog(e,this.getClass().getName());
        }

    }

}
