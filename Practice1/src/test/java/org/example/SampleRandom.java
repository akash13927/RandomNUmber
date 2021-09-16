package org.example;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.driverClasses.DriverClasses;
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

import javax.swing.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class SampleRandom {
    WebDriver driver ;
    Urls url;
    Path paths;

    @BeforeTest
    public void beforeTest(){
        driver = DriverClasses.chromeDriver();
        driver.manage().window().maximize();
        url =  PageFactory.initElements(driver, Urls.class);
        paths = PageFactory.initElements(driver, Path.class);

    }

    @Test
    public void Test() throws IOException, InterruptedException {
        driver.get(url.randomNumberUrls());
        Thread.sleep(1000);
        String path = paths.randomNumberPath() ;
        File fs = new File(path);
        //Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("firstSheet");
        WebElement els =  driver.findElement(By.cssSelector("#nU5Yvb"));
        Actions act = new Actions(driver);
        act.clickAndHold(els).doubleClick().perform();
        driver.findElement(By.cssSelector("#nU5Yvb")).sendKeys("1000");
        for(int i = 0 ;i<5 ;i++){
            driver.findElement(By.id("ZdzlKb")).click();
            Thread.sleep(3000);

            String randomNumber =  driver.findElement(By.cssSelector("div.gws-csf-randomnumber__result")).getText();
            sheet.createRow(i).createCell(0).setCellValue(randomNumber);
            FileOutputStream fos = new FileOutputStream(fs);
            workbook.write(fos);
        }


    }
    @AfterTest
    public void quit(){
        driver.quit();
    }




}
//ExplicitWait
//    WebDriverWait wait=new WebDriverWait(driver,2);
//            WebElement element =
//                    wait.until
//                            (ExpectedConditions.visibilityOfElementLocated
//                                    (By.xpath("//*[@id='Zv1Nfb']/div")));
