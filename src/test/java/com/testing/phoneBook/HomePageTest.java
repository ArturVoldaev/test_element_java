package com.testing.phoneBook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HomePageTest extends Base {

    @Test
    public void loginElementExistOnPage() {
        isElementExist(By.xpath("//h2[normalize-space()='Phone book']"));
        isElementExist(By.xpath("//h3[normalize-space()='Login']"));
    }
}
