package org.example;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LovoRise{

    private AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
//
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:deviceName", "Redmi 12");
        desiredCapabilities.setCapability("appium:udid", "859b275a7d75");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appium:appPackage", "com.lovorise");
        desiredCapabilities.setCapability("appium:appActivity", "com.lovorise.MainActivity");

        URL remoteUrl = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testUserAuthentication() {
        // Test steps for user authentication

        WebElement allowButton = driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]"));
        allowButton.click();
        WebElement signUpButton = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Sign up\"]"));
        signUpButton.click();
        WebElement EnableLocation = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Enable location\"]"));
        EnableLocation.click();
        WebElement WhileUsingAppButton = driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]"));
        WhileUsingAppButton.click();

        WebElement emailField = driver.findElement(By.xpath("//android.widget.EditText"));
        emailField.click();
        emailField.sendKeys("popysarkar025@gmail.com");
        WebElement continueButton = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Continue\"]"));
        continueButton.click();

        WebElement passwordField = driver.findElement(By.xpath("//*[contains(@text,' Password')] /preceding-sibling::android.view.View/android.widget.EditText"));
        passwordField.click();
        passwordField.sendKeys("Popi@6767");


//        WebElement emailField = driver.findElement(By.xpath("//android.widget.EditText"));
//        emailField.sendKeys("popysarkar025@gmail.com");
//
//        WebElement emailField = driver.findElement(By.xpath("//android.widget.EditText"));
//        emailField.sendKeys("popysarkar025@gmail.com");






    }
}
