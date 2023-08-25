package com.testing.phoneBook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.UUID;

public class Base {
    WebDriver driver = new FirefoxDriver();
    UUID RANDOM = UUID.randomUUID();

    @BeforeMethod
    public void setUp() {
        driver.get("http://phonebook.telran-edu.de:8080/");
        driver.manage().window().maximize();
    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }

    public boolean isElementExist(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void clickOnElementByXpath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public void clickOnElementByCss(String selector) {
        driver.findElement(By.cssSelector(selector)).click();
    }

    public void fillInputByXpath(String element, String value) {
        clickOnElementByXpath(element);
        driver.findElement(By.xpath(element)).clear();
        driver.findElement(By.xpath(element)).sendKeys(value);
    }

    public void clearInput(String element) {
        driver.findElement(By.xpath(element)).clear();
    }
}
