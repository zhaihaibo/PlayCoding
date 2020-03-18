package com.example.demo.controller;

import com.example.demo.global.RtnResult;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
@author  zhaihaibo
@data 2020/3/18 - 21:53
*/
@RestController
public class OutputExcelController {

    //从数据库拿数据到excel中
    @GetMapping("/OutputExcel")
    public RtnResult InputExcel() throws IOException {
        //创建excel工作簿 此处创建的是03版本的，后缀是.xls
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();

        //在excel中创建一个名为“薪酬标准模板”的工作表
        HSSFSheet sheet = hssfWorkbook.createSheet("薪酬标准模板");

        //创建第一行 1
        HSSFRow row = sheet.createRow(0);

        //创建第一行第一列 1-1
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("姓名");

        //创建第一行第二列 1-2
        HSSFCell cell1 = row.createCell(1);
        cell1.setCellValue("岗位");

        //第二行  2
        HSSFRow row1 = sheet.createRow(1);

//         2-1
        HSSFCell cell2 = row1.createCell(0);
        cell2.setCellValue("zhaihaibo");

//        2-2
        String dateTime = new DateTime().toString("yyyy-MM-dd HH:mm:ss");

        row1.createCell(1).setCellValue(dateTime);
        //创建输出流
        FileOutputStream fileOutputStream = null;
        try {
           fileOutputStream = new FileOutputStream("C:\\Users\\翟海波\\Desktop\\poi\\test-write03.xls");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //把工作簿写出去
        hssfWorkbook.write(fileOutputStream);
        System.out.println("文件写出成功！！");
        fileOutputStream.close();
        return  RtnResult.success();
    }
}
