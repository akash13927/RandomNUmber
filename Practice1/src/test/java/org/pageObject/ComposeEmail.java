package org.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComposeEmail {
    WebDriver driver;
    public ComposeEmail(WebDriver ldriver){
        driver = ldriver;
    }
    By clickingComposeButton = By.cssSelector("div[style='user-select: none']");
    By toWhomURSendingMessage = By.cssSelector("textarea.vO");
    By subjectText = By.cssSelector("input.aoT");
    By enteringTextMeassage = By.cssSelector("div[aria-label='Message Body']");
    By sendButton = By.cssSelector("div[data-tooltip-delay='800']");
    By attachePdfFile = By.cssSelector("div[data-tooltip='Attach files']");
    public void clickComposeButton(){
        driver.findElement(clickingComposeButton).click();
    }
    public void receiverEmailAddress(String receiverEmail){
        driver.findElement(toWhomURSendingMessage).sendKeys(receiverEmail);
    }
    public  void subjectText(String Subject){
        driver.findElement(subjectText).sendKeys(Subject);
    }
    public void textMessage(String testMeassage){
        driver.findElement(enteringTextMeassage).sendKeys(testMeassage);
    }
    public void sendButton(){
        driver.findElement(sendButton).click();
    }
    public void  clickAttachedPdfFileButton(){
        driver.findElement(attachePdfFile).click();
    }
}
