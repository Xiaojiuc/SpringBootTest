package com.qhit.common.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.util.*;

/**
 * @Date:2019/7/28
 * @Description:
 * @version:1.0
 */
public class CommonsCsvUtil {

    public static void main(String[] args) throws Exception {

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
        exportByList(headers, dataList);

        System.out.println("=======结束==========");
    }

    public static void exportByList(String[] headers, List<List<String>> dataList) throws FileNotFoundException {
        FileOutputStream fileos = new FileOutputStream("E:/abc.csv");
        exportByList(headers, dataList, fileos);
    }

    public static void exportByList(String[] headers, List<List<String>> dataList, OutputStream os) {
        OutputStreamWriter osw = null;
        CSVFormat csvFormat = null;
        CSVPrinter csvPrinter = null;
        try {
            osw = new OutputStreamWriter(os, "GBK");//如果是UTF-8时，WPS打开是正常显示，而微软的excel打开是乱码,
            csvFormat = CSVFormat.DEFAULT.withHeader(headers);
            csvPrinter = new CSVPrinter(osw, csvFormat);
            for (int i = 0; i < dataList.size(); i++) {
                List<String> values = dataList.get(i);
                csvPrinter.printRecord(values);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(os, csvPrinter);
        }
    }

    public static void exportByLinked(String[] headers, List<LinkedHashMap<String, Object>> dataList)
            throws FileNotFoundException {
        FileOutputStream fileos = new FileOutputStream("E:/abc.csv");
        exportByLinked(headers, dataList, fileos);
    }

    public static void exportByLinked(String[] headers, List<LinkedHashMap<String, Object>> dataList, OutputStream os) {
        OutputStreamWriter osw = null;
        CSVFormat csvFormat = null;
        CSVPrinter csvPrinter = null;
        try {

            osw = new OutputStreamWriter(os, "GBK");
            csvFormat = CSVFormat.DEFAULT.withHeader(headers);
            csvPrinter = new CSVPrinter(osw, csvFormat);

            for (int i = 0; i < dataList.size(); i++) {
                List<String> values = new ArrayList<String>();
                LinkedHashMap<String, Object> rowHashMap = dataList.get(i);
                Set<String> keys = rowHashMap.keySet();
                for (String key : keys) {
                    values.add(String.valueOf(rowHashMap.get(key)));
                }
                csvPrinter.printRecord(values);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(os, csvPrinter);
        }
    }

    private static void close(OutputStream os, CSVPrinter csvPrinter) {
        if (csvPrinter != null) {
            try {
                csvPrinter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                csvPrinter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (os != null) {
            try {
                os.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
