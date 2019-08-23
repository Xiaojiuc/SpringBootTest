package com.qhit.common.util;

import java.util.logging.Logger;

public class LogUtil {
    public static void printLog(Exception e,String className){
        Logger logger = Logger.getLogger(className);
        logger.info(e.getMessage());
    }
}
