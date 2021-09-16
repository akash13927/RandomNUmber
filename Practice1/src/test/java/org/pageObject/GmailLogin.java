package org.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailLogin {
    WebDriver driver;
    By username = By.name("identifier");
    By nextClick = By.id("identifierNext");
    By password =By.name("password");
    By nextClickAfterPassword = By.xpath("//*[@id=\"passwordNext\"]/div/button/span");

    public GmailLogin(WebDriver lDriver){
        this.driver = lDriver;
    }
    public void userEmailId(String lUsername){
        driver.findElement(username).sendKeys(lUsername);
    }

    public void clickNextButton(){
        driver.findElement(nextClick).click();
    }
    public void userPassword(String lPassword)
    {
        driver.findElement(password).sendKeys(lPassword);

    }
    public void nextClickAfterPassword(){
        driver.findElement(nextClickAfterPassword).click();
    }

}
