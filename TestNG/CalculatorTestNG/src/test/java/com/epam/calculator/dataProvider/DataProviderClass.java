package com.epam.calculator.dataProvider;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import java.io.File;
import java.lang.reflect.Method;
import java.io.IOException;
import java.util.List;
import org.jdom.Document;
import jxl.read.biff.BiffException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import jxl.Workbook;
import jxl.Sheet;

import org.testng.annotations.DataProvider;


/**
 * DataProviderClass contains @DataProvider
 * to read data for tests from xml-files
 * Created by GaBi on 22.05.2016.
 */
public class DataProviderClass {

    public static String getPathOfDataFile (Method method) {
        String pathPackage = "";
        String filePath;

        if (method.getName().contains(PathConstant.SUM) |
                method.getName().contains(PathConstant.SUB) |
                    method.getName().contains(PathConstant.MULT) |
                        method.getName().contains(PathConstant.DIV)){
            pathPackage = PathConstant.BASE_OPERATIONS;
        } else if (method.getName().contains(PathConstant.COS) |
                       method.getName().contains(PathConstant.SIN) |
                            method.getName().contains(PathConstant.TG) |
                                method.getName().contains(PathConstant.CTG) |
                                    method.getName().contains(PathConstant.POW) |
                                        method.getName().contains(PathConstant.SQRT)){
            pathPackage = PathConstant.ENGINEER_OPERATIONS;
        } else if (method.getName().contains(PathConstant.IS_POSITIVE) |
                       method.getName().contains(PathConstant.IS_NEGATIVE)){
            pathPackage = PathConstant.SIGN;
        }

        filePath = pathPackage + method.getName() + PathConstant.XML;
        return filePath;
    }

    @DataProvider(name="ReadDataFromXmlFile", parallel = true)
    public static Object[][] readXml(Method method) throws IOException {
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(PathConstant.PACKAGE + getPathOfDataFile(method));
        Long inputData[][] = null;

        try {

            Document document = builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren(PathConstant.TAG_NAME);

            inputData = new Long[list.size()][((Element) list.get(0)).getChildren().size()];

            for (int i = 0; i < list.size(); i++) {

                Element node = (Element) list.get(i);
                List<org.jdom.Element> o = node.getChildren();
                for (int j = 0; j < o.size(); j++) {
                    inputData[i][j] = Long.parseLong(o.get(j).getText());
                }
            }
        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }
        return inputData;
    }

/*
    @DataProvider(name="Read Data From Excel File")
    public static Object[][] readExcel(Method method) throws IOException {
        String filePath = "D:\\Galyna\\PreProdLab\\TestNG\\CalculatorTestNG\\src\\" +
                "test\\resources\\test-input\\testCalculator\\baseOperations\\testSumPassLong.xml";
        Long inputData[][] = null;

        try {
            FileInputStream fs = new FileInputStream(filePath);
            Workbook wb = Workbook.getWorkbook(fs);

            // TO get the access to the sheet
            Sheet sh = wb.getSheet(0);

            // To get the number of rows present in sheet
            int totalNoOfRows = sh.getRows();

            // To get the number of columns present in sheet
            int totalNoOfCols = sh.getColumns();

            inputData = new Long[totalNoOfRows][totalNoOfCols];

            for (int row = 0; row < totalNoOfRows; row++) {

                for (int col = 0; col < totalNoOfCols; col++) {
                    inputData[row][col] = Long.parseLong(sh.getCell(col, row).getContents());
                }
            }
        } catch (BiffException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputData;
    }
*/

}
