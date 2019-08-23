package com.qhit.common.util;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @auth yuzhenhan
 * @date 2019/8/12
 * @todo
 */
public class CommonsPDFUtil {

    public static void ExportPDF(HttpServletRequest request, HttpServletResponse response) {

        try {
            ServletOutputStream outputStream = response.getOutputStream();
//            PdfFont font = PdfFontFactory.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
            PdfWriter pdfWriter = new PdfWriter(outputStream);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);
            Paragraph paragraph = new Paragraph("你好，我的世界");
            document.add(paragraph);
            String str = "你好我的世界";
            response.setHeader("Content-disposition", "attachment; filename="+ new String(str.getBytes("GB2312"),"8859_1") + ".pdf");// 设定输出文件头
//            response.setHeader("Content-disposition", "attachment; filename=" + str + ".pdf");// 设定输出文件头
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
