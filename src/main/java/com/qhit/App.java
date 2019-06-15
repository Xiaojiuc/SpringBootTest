package com.qhit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Hello world!
 */
@EnableCaching          //开启缓存
@SpringBootApplication
@ServletComponentScan //在 springBoot 启动时会扫描@WebServlet，并将该类实例化
@MapperScan("com.qhit.mapper")     //@MapperScan 用户扫描MyBatis的Mapper接口
public class App extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(App.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
