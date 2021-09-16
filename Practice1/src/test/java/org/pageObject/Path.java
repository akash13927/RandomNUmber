package org.pageObject;

import org.openqa.selenium.WebDriver;

public class Path {
    WebDriver driver;
    public Path(WebDriver ldriver){
        this.driver = ldriver;
    }

    String randomNumberPath = "E:\\SeleniumPractice\\dev\\Practice1\\src\\Resources\\RandomNumberFile\\RandomNumberExcelFile.xlsx";
    public String randomNumberPath(){
        return randomNumberPath ;
    }
    String randomNumber50 =
            "E:\\SeleniumPractice\\dev\\Practice1\\src\\Resources\\RandomNumberFile\\" +
                    "RandomNumberGenerator50Docs.xlsx";
    public String getRandomNumber50Path() {
        return randomNumber50;
    }

}
