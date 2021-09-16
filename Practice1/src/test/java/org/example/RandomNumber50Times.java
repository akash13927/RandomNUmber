package org.example;
import com.aspose.cells.PdfSaveOptions;
import com.aspose.cells.Workbook;
import macSelenium.GmailAttachement;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.driverClasses.DriverClasses;
import org.gmailAutomation.SendPdfFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pageObject.Path;
import org.pageObject.Urls;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.*;
import javax.swing.text.Document;
import java.io.*;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class RandomNumber50Times {
    WebDriver driver ;
    Urls url;
    Path paths;
    macSelenium.GmailAttachement gmail = new GmailAttachement();
    @BeforeTest
    public void beforeTest(){
        driver = DriverClasses.chromeDriver();
        driver.manage().window().maximize();
        url =  PageFactory.initElements(driver, Urls.class);
        paths = PageFactory.initElements(driver, Path.class);

    }

    @Test
    public void Test() throws Exception {
        driver.get(url.randomNumberUrls());
        Thread.sleep(1000);
        String path = paths.getRandomNumber50Path() ;
        File fs = new File(path);

        FileOutputStream fos = new FileOutputStream(fs);

        //Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        WebElement els =  driver.findElement(By.cssSelector("#nU5Yvb"));
        Actions act = new Actions(driver);
        act.clickAndHold(els).doubleClick().perform();
        driver.findElement(By.cssSelector("#nU5Yvb")).sendKeys("1000");

        for(int i = 0 ;i<50 ;i++){
            driver.findElement(By.id("ZdzlKb")).click();
            Thread.sleep(1000);
            String randomNumber =  driver.findElement(By.cssSelector("div.gws-csf-randomnumber__result")).getText();
            sheet.createRow(i).createCell(0).setCellValue(randomNumber);
            //FileOutputStream fos = new FileOutputStream(fs);
            workbook.write(fos);
        }

        Thread.sleep(2000);
        int  max =countNumberAbove500(sheet,workbook);
        sheet.createRow(52).createCell(0).setCellValue("number above 500 are ");
        workbook.write(fos);
        sheet.createRow(53).createCell(0).setCellValue(max);
        workbook.write(fos);
        int min = countNumberBelow500(sheet,workbook);
        sheet.createRow(54).createCell(0).setCellValue("numbers below 500 are ");
        workbook.write(fos);
        sheet.createRow(55).createCell(0).setCellValue(min);
        workbook.write(fos);
        fos.close();
        workbook.close();
        ExcelToPdf.run();
        SendPdfFile.gmailToSendPdfFile();

    }

    public Integer countNumberAbove500(XSSFSheet sheet,XSSFWorkbook workbook) {
        XSSFSheet sheet1 = workbook.getSheetAt(0);
        int  count = 0;
        for(int i = 0 ; i<=2 ; i++){
            int num = Integer.parseInt(sheet1.getRow(i).getCell(0).getStringCellValue());
            if(num>500){
                count = count+1;
            }

        }
        return count;
        }
        public Integer countNumberBelow500(XSSFSheet sheet,XSSFWorkbook workbook) {
         XSSFSheet sheet1 = workbook.getSheetAt(0);
         int  count = 0;
         for(int i = 0 ; i<=49 ; i++){
             int num = Integer.parseInt(sheet1.getRow(i).getCell(0).getStringCellValue());
             if(num<500){
                 count = count+1;
             }

         }
         return count;
     }

            @AfterTest
            public void quit(){
                driver.quit();
            }


        }