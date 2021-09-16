package org.example;

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


import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class GmailAutomation
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
    public void sampleRun() throws InterruptedException {

        gmailLogin.userEmailId("akashtestingautomation");
        gmailLogin.clickNextButton();
        gmailLogin.userPassword("Ak@shSingh94151");
        gmailLogin.nextClickAfterPassword();
       // changeEmailSignature("Akash_new_signature");
        for(int i=0;i<2;i++){
            composeEmail("pratyaysengupta@gmail.com ", "Testing email", "Hey ");
        }

       // signOut();
    }

    public  void changeEmailSignature(String newSignature){
        //click setting button
        driver.findElement(By.cssSelector("svg.Xy")).click();
        //click on see all seting
        driver.findElement(By.cssSelector("button.Tj")).click();

        driver.findElement(By.cssSelector("span[data-action='edit']")).click();
        //entering signature
        driver.findElement(By.cssSelector("input[placeholder='Signature name']")).sendKeys(newSignature);
        driver.findElement(By.cssSelector("button[name='ok']")).click();
        driver.findElement(By.cssSelector("button[id=':75']")).click();
    }

    public void composeEmail(String toWhom,String Subject,String textMessage){

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
        composeEmail.sendButton();
        // river.findElement(By.cssSelector("div[data-tooltip-delay='800']")).click();
    }
    public void signOut(){
        driver.findElement(By.cssSelector("img[class='gb_Ca gbii']")).click();
        driver.findElement(By.cssSelector("#gb_71")).click();
    }


    @AfterTest
    public void quit(){
        //driver.quit();
         }
}
