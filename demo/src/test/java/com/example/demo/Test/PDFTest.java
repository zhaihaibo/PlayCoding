import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class PDFTest {
    public static void main(String[] args) throws DocumentException, IOException {
        //1.创建Docunment对象
        Document document = new Document();

        //2.打开书写器
        PdfWriter pdfWriter = PdfWriter.getInstance(document , new FileOutputStream("E:/pdf/境外采购业务折扣协议.pdf"));
//        //2.设置密码
//        String password = "123456";
//        String name = "hhh";
//        pdfWriter.setEncryption(password.getBytes(), name.getBytes(), PdfWriter.ALLOW_PRINTING,
//                PdfWriter.ENCRYPTION_AES_128);
        //3.打开对象 - 添加内容
        document.open();
        //4.中文字体,解决中文不能显示问题
        BaseFont bfChinese = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
        //5.中文要设置字体
        document.add(new Paragraph("境外采购业务折扣协议",new Font(bfChinese)));
        document.addAuthor("1");
        System.out.println("生成PDF文件成功！");
        //6.关闭对象
        document.close();
        pdfWriter.close();

    }
//public static void main(String[] args) throws DocumentException, IOException {
//    // 创建文件
//    Document document = new Document();
//    // 建立一个书写器
//    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("E:/pdf/test.pdf"));
//
//    //用户密码
//    String userPassword = "123456";
//    //拥有者密码
//    String ownerPassword = "hd";
//    writer.setEncryption(userPassword.getBytes(), ownerPassword.getBytes(), PdfWriter.ALLOW_PRINTING,
//            PdfWriter.ENCRYPTION_AES_128);
//
//    // 打开文件
//    document.open();
//
//    //添加内容
//    document.add(new Paragraph("password !!!!"));
//
//    // 关闭文档
//    document.close();
//    // 关闭书写器
//    writer.close();
//}


}
