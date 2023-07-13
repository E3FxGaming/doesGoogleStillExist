package org.example.e3fxgaming;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    @Test
    public void testDoesGoogleStillExist() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("https://about.google/");
        assertTrue(driver.findElements(By.cssSelector("img.glue-header__logo-svg")).size() > 0);
    }
}