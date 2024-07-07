package org.example;

import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;


import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {

    private AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
//
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:deviceName", "Redmi 12");
        desiredCapabilities.setCapability("appium:udid", "859b275a7d75");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
       desiredCapabilities.setCapability("appium:appPackage", "com.androidsample.generalstore");
        desiredCapabilities.setCapability("appium:appActivity", "com.androidsample.generalstore.SplashActivity");
//        desiredCapabilities.setCapability("app", apk_file.getAbsolutePath());
        URL remoteUrl = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testGeneralStoreAPK()  {

        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
       driver.findElement(By.xpath("//*[@text=\"American Samoa\"]")).click();
       driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("popy");
       driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]")).click();
        WebElement cart = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\" and @text=\"ADDED TO CART\"]"));
        Assert.assertTrue(cart.isDisplayed());
        String hello=  driver.findElement(By.id("com.androidsample.generalstore:id/counterText")).getText();
        Assert.assertEquals(hello,"1");

       }
//     @AfterSuite
//     public void quit(){
//
//        driver.quit();



//}
}
