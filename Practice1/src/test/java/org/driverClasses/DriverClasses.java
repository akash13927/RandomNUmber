package org.driverClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverClasses {

    public static WebDriver chromeDriver(){
            System.setProperty("webdriver.chrome.driver",
                    "src\\\\Resources\\\\DriverExecutableFiles\\\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return  driver;
    }

    public static WebDriver firefoxDriver(){
        System.setProperty("webdriver.gecko.driver",
                "src\\\\Resources\\\\DriverExecutableFiles\\\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        return  driver;
    }
    public static WebDriver microsoftEdge(){
        System.setProperty("webdriver.edge.driver",
                "src\\\\Resources\\\\DriverExecutableFiles\\\\IEDriverServer.exe");
        WebDriver driver = new EdgeDriver();
        return  driver;
    }
}
