package org.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Urls {
    WebDriver driver;
    public Urls(WebDriver ldriver){
        this.driver = ldriver;
    }
    String gmailUrl = "https://mail.google.com/mail/u/0/#inbox";

    public String gmailUrl(){
        return gmailUrl;
    }
    String randomNumberGeneratorUrl = "https://www.google.com/search?q=random+number+g" +
            "enerator&rlz=1C1SQJL_enIN" +
            "935IN935&oq=random+number+generator&aqs=chrome.0.69i59j0i512l9.671j0" +
            "j9&sourceid=chrome&ie=UTF-8";
    public String randomNumberUrls(){
        return  randomNumberGeneratorUrl;
    }

    String excelUrl = "https://onedrive.live.com/edit.aspx?action=editnew&resid=280F3BE9E8DFAD50!106&ithint=file%2cxlsx&action" +
            "=editnew&wdNewAndOpenCt=1630979763945&wdPreviousSession=3b0a604f-7a0e-4834-853f-db30d78723c5&wdOrigin=" +
            "OFFICECOM-WEB.START.NEW";
    public String excel_url(){
        return excelUrl ;
    }


}