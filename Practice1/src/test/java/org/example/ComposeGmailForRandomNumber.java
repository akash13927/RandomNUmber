package org.example;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeBodyPart;
import org.driverClasses.DriverClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.pageObject.ComposeEmail;
import org.pageObject.GmailLogin;
import org.pageObject.Urls;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class ComposeGmailForRandomNumber
{
    WebDriver driver ;
    GmailLogin gmailLogin;
    Urls url;
    ComposeEmail composeEmail;
    @BeforeTest
    public void beforeTest(){
        driver = DriverClasses.chromeDriver();
        driver.manage().window().maximize();
        url =  PageFactory.initElements(driver, Urls.class);
        driver.get(url.gmailUrl());
        gmailLogin = PageFactory.initElements(driver, GmailLogin.class);

        composeEmail = PageFactory.initElements(driver,ComposeEmail.class);
    }
    @Test
    public void sampleRun() throws InterruptedException, IOException {

        gmailLogin.userEmailId("akashtestingautomation");
        gmailLogin.clickNextButton();
        gmailLogin.userPassword("Ak@shSingh94151");
        gmailLogin.nextClickAfterPassword();
        // changeEmailSignature("Akash_new_signature");
            composeEmail("akash03927@gmail.com ", "RandomNumber pdf file", "Hey ");

        // signOut();
    }


    public void composeEmail(String toWhom,String Subject,String textMessage) throws IOException, InterruptedException {

        //clicking compose button
        composeEmail.clickComposeButton();
        //driver.findElement(By.cssSelector("div[style='user-select: none']")).click();
        //TO whom u r sending message
        composeEmail.receiverEmailAddress(toWhom);
        //driver.findElement(By.cssSelector("textarea.vO")).sendKeys(toWhom);
        composeEmail.subjectText(Subject);
        //driver.findElement(By.cssSelector("input.aoT")).sendKeys(Subject);
        //entering text meassage
        composeEmail.textMessage(textMessage);
        //driver.findElement(By.cssSelector("div[aria-label='Message Body']")).sendKeys(textMessage);
        composeEmail.clickAttachedPdfFileButton();
        Thread.sleep(2000);
        Runtime.getRuntime().exec("E:\\SeleniumPractice\\dev\\Practice1\\Excel-to-PDF.pdf");
        composeEmail.sendButton();
        // river.findElement(By.cssSelector("div[data-tooltip-delay='800']")).click();

    }

    public void signOut(){
        driver.findElement(By.cssSelector("img[class='gb_Ca gbii']")).click();
        driver.findElement(By.cssSelector("#gb_71")).click();
    }



    public void quit(){
        //driver.quit();
    }
}
