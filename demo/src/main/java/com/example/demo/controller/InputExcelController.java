package com.example.demo.controller;

import com.example.demo.global.RtnResult;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

/*
@author  zhaihaibo
@data 2020/3/18 - 21:52
*/
@RestController
public class InputExcelController {

//从excel中拿数据到数据库中
    @GetMapping("InputExcel")
    public RtnResult InputExcel() throws IOException {

        FileInputStream inputStream = new FileInputStream("C:\\Users\\翟海波\\Desktop\\会员消费商品明细表.xls");
        //使用HSSFWorkbook工作簿读取输入流
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
        //得到第一个工作表
        Sheet sheetAt = hssfWorkbook.getSheetAt(0);

        //得到第一行所有数据（标题内容）
        Row row = sheetAt.getRow(0);
        if(row!=null){
            //获取物理列数（第一列有几列）
            int cellCount = row.getPhysicalNumberOfCells();

            //遍历每一列
            for (int i = 0; i < cellCount; i++) {
                Cell cell = row.getCell(i);
                //一定要确定cell不为空
                if (cell!=null) {
                    int cellType = cell.getCellType();
                    String stringCellValue = cell.getStringCellValue();
                    System.out.print(stringCellValue + "-");
                }
            }
            System.out.println();
        }

        //读取除标题外剩下所有的商品的行数
        int physicalNumberOfRows = sheetAt.getPhysicalNumberOfRows();

        //遍历所有行
        for (int i = 1; i < physicalNumberOfRows; i++) {
            //除标题外第一行
            Row row1 = sheetAt.getRow(i);
            if (row1!=null){
                //获取第一行所有物理列数
                int physicalNumberOfCells = row1.getPhysicalNumberOfCells();
                //遍历第一行所有列
                for (int i1 = 0; i1 < physicalNumberOfCells; i1++) {
                    System.out.print("【" + (i + 1) + "-" + (i1 + 1) + "】");

                    //当i1=0时-->代表除标题外第一行第一列
                    Cell cell = row1.getCell(i1);


                    if (cell!=null){

                        int cellType = cell.getCellType();
                        //判断第一行第一列的值类型
                        String cellValue = "";
                        switch (cellType){
                            case HSSFCell.CELL_TYPE_STRING://字符串
                                System.out.print("【STRING】");
                                cellValue = cell.getStringCellValue();
                                break;
                            case HSSFCell.CELL_TYPE_BOOLEAN://布尔
                                System.out.print("【BOOLEAN】");
                                cellValue = String.valueOf(cell.getBooleanCellValue());
                                break;
                            case HSSFCell.CELL_TYPE_BLANK://空
                                System.out.print("【BLANK】");
                                break;
                            case HSSFCell.CELL_TYPE_NUMERIC:
                                System.out.print("【NUMERIC】");
                                //cellValue = String.valueOf(cell.getNumericCellValue());
                                if (HSSFDateUtil.isCellDateFormatted(cell)) {//日期
                                    System.out.print("【日期】");
                                    Date date = cell.getDateCellValue();
                                    cellValue = new DateTime(date).toString("yyyy-MM-dd");
                                } else {
                                    // 不是日期格式，则防止当数字过长时以科学计数法显示
                                    System.out.print("【转换成字符串】");
                                    cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                                    cellValue = cell.toString();
                                }
                                break;
                            case Cell.CELL_TYPE_ERROR:
                                System.out.print("【数据类型错误】");
                                break;

                        }

                        System.out.println(cellValue);
                    }

                }
            }

        }


        inputStream.close();
        return  RtnResult.success();
    }

}
