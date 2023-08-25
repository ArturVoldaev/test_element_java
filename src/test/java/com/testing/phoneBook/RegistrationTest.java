package com.testing.phoneBook;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RegistrationTest extends Base {
    @BeforeMethod
    public void setUpRegistration() {
        clickOnElementByXpath("//a[normalize-space()='Register new Account']");
    }

    @Test
    public void positiveRegistrationTest() {
//      email
        fillInputByXpath("//input[@name='email']", "test@test.ru");
//      password
        fillInputByXpath("//input[@name='password']", "123456789");
        // confirm-password
        fillInputByXpath("//input[@name='confirm-password']", "123456789");
    }

    @Test
    public void negativeRegistrationLoginTest() {
        fillInputByXpath("//input[@name='email']", String.valueOf(RANDOM));
        assertTrue(isElementExist(By.xpath("//div[@id='email-error-invalid']")));
    }

    @Test
    public void negativeRegistrationNotConfirmPasswordTest() {
        fillInputByXpath("//input[@name='password']", "123456789");
        fillInputByXpath("//input[@name='confirm-password']", String.valueOf(RANDOM));
        assertTrue(isElementExist(By.xpath("//div[@id='confirm-password-error-matcher']")));
    }

    @Test
    public void negativeRegistrationNonConfirmPasswordTest() {
        clearInput("//input[@name='password']");
        clearInput("//input[@name='confirm-password']");
        fillInputByXpath("//input[@name='email']", String.valueOf(RANDOM));
        fillInputByXpath("//input[@name='password']", "123456789");
        fillInputByXpath("//input[@name='confirm-password']", String.valueOf(RANDOM));
        clearInput("//input[@name='confirm-password']");
        clickOnElementByXpath("//input[@name='confirm-password']");
        assertTrue(isElementExist(By.xpath("//*[@id=\"confirm-password-error-matcher\"]")));
    }
}
