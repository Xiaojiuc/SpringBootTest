package com.qhit.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
/**
 * springBoot 整合 Listener
 * <listener>
 *     <listener-class>com.bjsxt.listener.FirstListener</listener-class>
 * </listener>
 * 1.对Request的监听有ServletRequestListener和ServletRequestAttributeListener。
 * 前者可见监听Request的创建和销毁；而后者可以对Request的属性进行监听。
 *
 * 2.对Session的监听有HttpSessionListener和HttpSessionAttributeListener。
 * HttpSessionListener可以监听HttpSession的创建跟销毁，而HttpSessionAttributeListener则是对session中属性的监听，
 * 它可以监听到session新增属性、移除属性和属性值被替换时。
 *
 * 3.对于ServletContext的监听器有ServletContextListener和ServletContextAttributeListener。
 * ServletContextListener可以监听到ServletContext的创建和销毁，
 * 而ServletContextAttributeListener可以监听到ServletContext中属性的新增、移除和属性值的替换。
 */
@WebListener
public class UserListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("(监听器，初始化)Listener...init...");
    }
}
